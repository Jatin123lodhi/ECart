package models;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.util.ArrayList;


public class Category
{
	private String category;
	private Integer categoryId;
	
	// ##### Constructors #######

	public Category(){
		
	}
	public Category(Integer categoryId){
		this.categoryId = categoryId;
	}
	
	public Category(Integer categoryId,String category){
		this.categoryId = categoryId;
		this.category = category;
	}

	//#### methods ##########

	public static ArrayList<Category> collectCategories(){
		ArrayList<Category> categories = new ArrayList<Category>();
		Connection con = null;
		try
		{
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select * from categories";
			PreparedStatement  pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			int i= 0;
			while(rs.next())
			{
				categories.add( new Category(rs.getInt(1),rs.getString(2)));
				
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
		return categories;
	}


	//#### Getter Setter ########

	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return category;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}
	public Integer getCategoryId(){
		return categoryId;
	}


}