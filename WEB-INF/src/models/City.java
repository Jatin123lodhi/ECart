package models;

import java.sql.*;
import java.util.ArrayList;


public class City{
	private Integer cityId;
	private String city;
	private State state;

	//############### Constructor ##############
	
	public City(Integer cityId ){
		this.cityId = cityId;
	}

	public City(Integer cityId,String city){
		this.cityId = cityId;
		this.city = city;
	}

	public City(Integer cityId,String city,State state ){
		this.cityId = cityId;
		this.city = city;
		this.state = state;
	}

	//############### Methods ###################
	public static ArrayList<City> getAllCities(){
		ArrayList<City> cities = new ArrayList<City>();
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");
			
			String query = "select city_id,city,s.state_id,s.state from cities as c inner join states as s where c.state_id=s.state_id";
			PreparedStatement pst = con.prepareStatement(query); // java.sql.PreparedStatement;
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				City city = new City(rs.getInt(1),rs.getString(2),new State(rs.getInt(3),rs.getString(4)));
				cities.add(city);
			}
			con.close();
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return cities;
	}
	
	
	public static ArrayList<City> searchCity(String skey){
		ArrayList<City> cities = new ArrayList<City>();
		Connection con = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdb?user=root&password=1234");

			String query = "select city_id,city from cities where city like '"+skey+"%'";

			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				cities.add(new City(rs.getInt(1),rs.getString(2)));
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

		return cities;
	}


	public void setState(State state){
		this.state = state;
	}

	public State getState(){
		return state;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;	
	}

	public void setCityId(Integer cityId){
		this.cityId = cityId;
	}

	public Integer getCityId(){
		return cityId;
	}
}