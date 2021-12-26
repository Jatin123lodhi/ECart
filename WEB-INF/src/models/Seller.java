package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.User;

public class Seller 
{
	private Integer sellerId;
	private String sellerAccountName;
	private User user;
	private Timestamp startDate;
	//### Constructors #####

	public Seller(){
	
	}
	public Seller(Integer sellerId,String sellerAccountName){
		this.sellerId = sellerId;
		this.sellerAccountName = sellerAccountName;
	}
	public Seller(User user,String sellerAccountName){
		this.user = user;
		this.sellerAccountName = sellerAccountName;
	}
	public Seller(Integer sellerId,String sellerAccountName,Timestamp startDate){
		this.sellerId = sellerId;
		this.sellerAccountName = sellerAccountName;
		this.startDate = startDate;
	}
	
	
	

	//#### method ###################

	public  void createSellerAccount(){
		Connection con = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "insert into sellers (user_id,seller_account_name,start_date) value (?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,user.getUserId());
			pst.setString(2,sellerAccountName);
			pst.setTimestamp(3,new Timestamp(new java.util.Date().getTime()));
			
			pst.executeUpdate();
		}
		catch (SQLException | ClassNotFoundException e)
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
	
	public static ArrayList<Seller> collectSellerAccounts(Integer userId){
		Connection con = null;
		ArrayList<Seller> seller = new ArrayList<Seller>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			String query = "select * from sellers where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				seller.add(new Seller(rs.getInt(1),rs.getString(3),rs.getTimestamp(4)));
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
		return seller;
	} 

	//## Getter Setter ##

	public void setSellerId(Integer sellerId){
		this.sellerId = sellerId;
	}
	public Integer getSellerId(){
		return sellerId;
	}

	public void setSellerAccountName(String sellerAccountName){
		this.sellerAccountName = sellerAccountName;
	}
	public String getSellerAccountName(){
		return sellerAccountName;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setStartDate(Timestamp startDate){
		this.startDate = startDate;
	}
	public Timestamp getStartDate(){
		return startDate;
	}
}


//sab se phele seller btn banayi  , jese click karne par request send hogi , seller_page.do
//seller_page.do isse se mapped he SellerPageServlet or ussme code likha ha seller accounts to lane ka 
//jisse seller_page 