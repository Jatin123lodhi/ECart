package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;


public class ProductPic 
{
	private Integer productPicId;
	private Integer productId;
	private String productPic;

	//############## Constructors ###################
	public ProductPic(){
		
	}
	public ProductPic(Integer productId,String productPic){
		this.productId = productId;
		this.productPic = productPic;
	}

	
	//####### other methods #######
	public static ArrayList<ProductPic> getAllProductPics(Integer productId){ // yhana int bhi likh sakte han kya...doubt
		ArrayList<ProductPic> productPics = new ArrayList<ProductPic>();
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			
			String query = "select product_pic_id,product_pic from product_pics where product_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,productId);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				productPics.add(new ProductPic(rs.getInt(1),rs.getString(2)));
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
	
	
		return  productPics;
	} 
		
	
	public static String getSingleProductPic(Integer productId){
		Connection con = null;
		String picPath = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select product_pic from product_pics where product_id=? limit 1";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,productId);
			ResultSet rs = pst.executeQuery();
			if (rs.next())
			{
				picPath = rs.getString(1);
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
		return picPath;
	}

	public static void saveProductPic(Integer productId,ArrayList<String> productPics){
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "insert into product_pics (product_id,product_pic) value (?,?)";
			PreparedStatement pst  = con.prepareStatement(query);
			
			pst.setInt(1,productId);
			for(String proPic: productPics){
				pst.setString(2,proPic);
				pst.executeUpdate();
			}
			
			System.out.println(con+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@con");
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
	
	
	
	//####### Getter Setter #######

	public void setProductPicId(Integer productPicId){
		this.productPicId  = productPicId;
	}
	public Integer getProductPicId(){
		return productPicId;
	}

	public void setProductId(Integer productId){
		this.productId = productId;
	}
	public Integer getProductId(){
		return productId;
	}

	public void setProductPic(String productPic){
		this.productPic = productPic;
	}
	public String getProductPic(){
		return productPic;
	}
}
