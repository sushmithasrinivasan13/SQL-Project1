package dao;

import java.sql.SQLException;

import connectionManager.ConnectionManager;
import model.Product;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO 
{
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		ConnectionManager conn= new ConnectionManager();
		Connection con = conn.establishConnection();
		
		String sql = "insert into product (productId,productName,minsellQuantity,price,quantity)values(?,?,?,?,?)";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, product.getProductId());
	    ps.setString(2, product.getProductName());
	    ps.setInt(3, product.minSellQuantity());
	    ps.setInt(4, product.getPrice());
	    ps.setInt(5, product.getQuantity());
	    ps.executeUpdate();
	    
	    conn.closeConnection();
	}
	public void display() throws ClassNotFoundException, SQLException
	{
		ConnectionManager conn= new ConnectionManager();
		Connection con = conn.establishConnection();
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from product");
		
		while(rs.next())
		{
			System.out.println("______________________________________________________________________________");
			System.out.println(rs.getInt("productId")+"|"+rs.getString("productName")+"|"+rs.getInt("minSellQuantity")+"|"+rs.getInt("price")+"|"+rs.getInt("quantity"));
		}
		conn.closeConnection();
	}
	
}