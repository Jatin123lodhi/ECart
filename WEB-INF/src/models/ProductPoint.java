package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

import models.Product;

public class ProductPoint
{
	private Integer productPointId;
	private String pointHeader;
	private String pointValue;
	private Product product;
	//######### Constructor ##############
	public ProductPoint(){
	
	}
	public ProductPoint(String pointHeader,String pointValue){
		this.pointHeader = pointHeader;
		this.pointValue = pointValue;
	}

	//########## other methods ##############
	
	public static ArrayList<ProductPoint> getProductPoints(Integer productId){
		Connection con = null;
		ArrayList<ProductPoint> productPoints = new ArrayList<ProductPoint>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "select point_header,point_value from product_points where product_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,productId);

			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				productPoints.add(new ProductPoint(rs.getString(1),rs.getString(2)));
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
		return productPoints;
	}



	public static void saveProductPoints(Integer productId,String[] pointTitle,String[] pointValue){
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "insert into product_points (product_id,point_header,point_value) value (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1,productId);
			for(int i=0;i<pointTitle.length;i++){
				
				ps.setString(2,pointTitle[i]);
				ps.setString(3,pointValue[i]);

				ps.executeUpdate();
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


	//######### Getter Setter ############

	public void setProductPointId(Integer productPointId){
		this.productPointId = productPointId;
	}
	public Integer getProductPointId(){
		return productPointId;
	}

	public void setPointHeader(String pointHeader){
		this.pointHeader = pointHeader;
	}
	public String getPointHeader(){
		return pointHeader;
	}

	public void setPointValue(String pointValue){
		this.pointValue = pointValue;
	}
	public String getPointValue(){
		return pointValue;
	}
	public void setProduct(Product product){
		this.product = product;
	}
	public Product getProduct(){
		return product;
	}
}