package com.js.dao;

import java.sql.Connection;
 import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/book_store?user=root&password=root";
	static Connection c;
	public int insertBook(Book b) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps =c.prepareStatement("insert into book  values(?,?,?,?,?)");
			ps.setInt(1,b.getBid());
			ps.setString(2,b.getBname());
			ps.setString(3, b.getBauthor());
			ps.setInt(4,b.getBpage());
			ps.setDouble(5,b.getBpricel());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteBookById(int Bid) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps =c.prepareStatement("delete from book where Bid=?");
			ps.setInt(1, Bid);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int updateBookById(int id ,Book b) {
		try {
			Class.forName(path);
			c=DriverManager.getConnection(address);
			PreparedStatement ps =c.prepareStatement("Update book set Bname=?,Bauthor=?,Bpage=?,Bpricel=? where Bid=?");
			
			ps.setString(1, b.getBname());
			ps.setString(2, b.getBauthor());
			ps.setInt(3,b.getBpage());
			ps.setDouble(4, b.getBpricel());
			ps.setInt(5,id);
			
			return ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				c.close();
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public Book getBookById(int Bid) {
		Book b=null;
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps =c.prepareStatement("Select * from book where Bid=?");
			ps.setInt(1, Bid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				b = new Book();
			b.setBid((rs.getInt(1)));
			b.setBname((rs.getString(2)));
			b.setBauthor((rs.getString(3)));
			b.setBpage((rs.getInt(4)));
			b.setBpricel((rs.getDouble(5)));
			return b;
			}else {
				return b;
			
			}
			
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
}
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> al = new ArrayList<Book>()	;
		try {
			Class.forName(path);
			 c = DriverManager.getConnection(address);
		  PreparedStatement ps = c.prepareStatement("select * from book");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Book b = new Book();
			b.setBid(rs.getInt(1));
			b.setBname(rs.getString(2));
			b.setBauthor(rs.getString(3));
			b.setBpage(rs.getInt(4));
			b.setBpricel(rs.getDouble(5));
			al.add(b);
		}
		return al;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
		}
}


