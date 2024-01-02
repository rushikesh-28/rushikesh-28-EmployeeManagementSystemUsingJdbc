package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.model.Emplyee;
public class EmployeeDao 
{
	
	public int insertEmployee(Emplyee e)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","Rushikesh");
			String sql="insert into Employee(ename,ecompany,edesignation,esalary)values(?,?,?,?)";
			pst=con.prepareStatement(sql);
			pst.setString(1,e.getEname() );
			pst.setString(2,e.getEcompany());
			pst.setString(3,e.getEdesignation());
			pst.setDouble(4,e.getEsalary());
			check=pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		finally
		{
			
			try {
				con.close();
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return check;
	}
		
	public Emplyee find(int eid)
	{
		Emplyee e=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","Rushikesh");
		String sql="select  eid,ename,ecompany,edesignation,esalary from Employee where eid=?"; 
		pst=con.prepareStatement(sql);
		pst.setInt(1,eid);
		rs=pst.executeQuery();
		while(rs.next())
		{
			e=new Emplyee();
			e.setEid((int)rs.getObject("eid"));
			e.setEname((String)rs.getObject("ename"));
			e.setEcompany((String)rs.getObject("ecompany"));
			e.setEdesignation((String)rs.getObject("edesignation"));
			e.setEsalary((double)rs.getObject("esalary"));
		}
			}catch(ClassNotFoundException |SQLException e1) {
			e1.printStackTrace();		
			}
		finally
		{
			
			try {
				rs.close();
				con.close();
				pst.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return e;
	}
	public int delete(int eid)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem", "root", "Rushikesh");
			String sql="delete from employee where eid =?";
			pst=con.prepareStatement(sql);
			pst.setInt(1,eid);
			pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			
			try {
				con.close();
				pst.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		return check;
		
	}
	public int update(Emplyee e)
	{
		int check=0;
		Connection con=null;
		PreparedStatement pst=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","Rushikesh");
			String sql="update Employee set ename=?,ecompany=?,edesignation=?,esalary=? where eid=?";
			pst=con.prepareStatement(sql);
			pst.setString(1,e.getEname() );
			pst.setString(2,e.getEcompany());
			pst.setString(3,e.getEdesignation()); 
			pst.setDouble(4,e.getEsalary());
			pst.setInt(5, e.getEid());
			check=pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		finally
		{
			
			try {
				con.close();
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		return check;
	}
	

}
