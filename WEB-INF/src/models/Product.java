package models;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import models.Seller;
import models.Category;

import java.util.ArrayList;

public class Product
{
	private Integer productId;
	private String productName;
	private Integer quantity;
	private Integer price;
	private Integer sold;
	private Integer discount;
	private String description;
	private String warranty;
	private String returningPolicy;
	private String paymentDetails;
	private String shipmentDetails;
	private Seller seller;
	private Category category;
	
	//##### Constructors #######
	
	public Product(){
		super();
	}

	public Product(int productId){
		this.productId = productId;
	}
	public Product(Seller seller,Category category,String productName,Integer quantity,Integer price,Integer discount){
		this.seller = seller;
		this.category = category;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}
	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount){
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.sold = sold;
		this.price = price;
		this.discount = discount;
	}
	public Product(Integer productId,String productName,Integer quantity,Integer sold,Integer price,Integer discount,Seller seller){
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.sold = sold;
		this.price = price;
		this.discount = discount;
		this.seller = seller;
	}

	//######################################## other methods ##############################
	
	public static ArrayList<Product> searchProducts(String searchKey){
		System.out.println(" inside method ***********");
		ArrayList<Product> products = new ArrayList<Product>();
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select product_id,product_name,quantity,sold,price,discount,p.seller_id,seller_account_name "
			+"from products as p inner join sellers as s where p.seller_id=s.seller_id and product_name like '%"+searchKey+"%'";

			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{	
				System.out.println("#############################################");
				products.add(new Product(rs.getInt(1),
										rs.getString(2),
										rs.getInt(3),
										rs.getInt(4),
										rs.getInt(5),
										rs.getInt(6),
										new Seller(rs.getInt(7),rs.getString(8)))
				);
				
				
			}
		}
		catch (SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return products;
	}



	public void getProductInfo(){
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select product_name,quantity,sold,price,discount,description,warranty,returning_policy,"
			+"shipment_details,payment_details,p.seller_id,seller_account_name from products as p "
			+"inner join sellers as s where product_id=? and p.seller_id=s.seller_id"; // inner join revise kar....


			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,productId);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				productName = rs.getString(1);
				quantity = rs.getInt(2);
				sold = rs.getInt(3);
				price = rs.getInt(4);
				discount = rs.getInt(5);
				description = rs.getString(6);
				warranty = rs.getString(7);
				returningPolicy = rs.getString(8);
				System.out.println(returningPolicy+"  --- returningPolicy");
				shipmentDetails = rs.getString(9);
				paymentDetails = rs.getString(10);
				seller = new Seller(rs.getInt(11),rs.getString(12));
				
			}
		}
		catch (SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static ArrayList<Product> collectAllProducts(Integer sellerId){
		Connection con = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select product_id,product_name,quantity,sold,price,discount "+
			"from products where seller_id=? order by product_id desc";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,sellerId);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				list.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6)));
			}
			
		}
		catch (SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean savePaymentDetails(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "update products set payment_details=? where product_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,paymentDetails);
			ps.setInt(2,productId);

			int res = ps.executeUpdate();

			if(res==1){
				flag = true;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	public boolean saveShipmentDetails(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "update products set shipment_details=? where product_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,shipmentDetails);
			ps.setInt(2,productId);

			int res = ps.executeUpdate();

			if(res==1){
				flag = true;
			}			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();	
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return flag;
	}
	public boolean saveReturningPolicy(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "update products set returning_policy=? where product_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,returningPolicy);
			ps.setInt(2,productId);

			int res = ps.executeUpdate();

			if(res==1){
				flag = true;
			}			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();	
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return flag;
	}
	
	
	
	
	public boolean saveWarranty(){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "update products set warranty=? where product_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1,warranty);
			ps.setInt(2,productId);

			int res = ps.executeUpdate();

			if(res==1){
				flag = true;
			}			
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();	
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return flag;
	}

	public boolean saveDescription(){
		Connection con = null;
		Boolean flag = false;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "update  products set description=? where product_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,description);
			pst.setInt(2,productId);

			int res = pst.executeUpdate();
			System.out.println("executeUpadate ******************************************************");
			if (res==1)
			{
				flag = true;
			}
			
		}
		catch (SQLException|ClassNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}




	public boolean saveProduct(){

		System.out.println(seller.getSellerId()+"$%$%$%$%$%$$%$%%%%$$$4 - seller obj . getSellerID() ");
		Boolean flag = false;
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "insert into products (seller_id,category_id,product_name,quantity,price,discount) value (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,seller.getSellerId());
			pst.setInt(2,category.getCategoryId());
			pst.setString(3,productName);
			pst.setInt(4,quantity);
			pst.setInt(5,price);
			pst.setInt(6,discount);


			int res = pst.executeUpdate();
			if (res==1)
			{	
				flag = true;
				ResultSet rs = pst.getGeneratedKeys();
				if (rs.next())
				{
					productId = rs.getInt(1);
				}
			}
		}
		catch (SQLException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}finally{
			try
			{
				con.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}

	//### Getter Setter  #####

	public void setProductId(Integer productId){
		this.productId = productId;
	}
	public Integer getProductId(){
		return productId;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}
	public String getProductName(){
		return productName;
	}

	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}
	public Integer getQuantity(){
		return quantity;
	}

	public void setPrice(Integer price){
		this.price = price;
	}
	public Integer getPrice(){
		return price;
	}
	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}
	public void setSold(Integer sold){
		this.sold = sold;
	}
	public Integer getSold(){
		return sold;
	}
	
	public void setDiscount(Integer discount){
		this.discount = discount;
	}
	public Integer getDiscount(){
		return discount;
	}

	public void setReturningPolicy(String returningPolicy){
		this.returningPolicy = returningPolicy;
	}
	public String getReturningPolicy(){
		return returningPolicy;
	}

	public void setWarranty(String warranty){
		this.warranty = warranty;
	}
	public String getWarranty(){
		return warranty;
	}

	public void setPaymentDetails(String paymentDetails){
		this.paymentDetails = paymentDetails;
	}
	public String getPaymentDetails(){
		return paymentDetails;
	}

	public void setShipmentDetails(String shipmentDetails){
		this.shipmentDetails = shipmentDetails;
	}
	public String getShipmentDetails(){
		return shipmentDetails;
	}

	public void setSeller(Seller seller){
		this.seller = seller;
	}
	public Seller getSeller(){
		return seller;
	}

	public void setCategory(Category category){
		this.category = category;
	}
	public Category getCategory(){
		return category;
	}
}