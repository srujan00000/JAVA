//JDBC1.java


import java.sql.*;
import java.util.*;
class JDBC1 {
	public static void main(String [] args)
	throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter FirstName");
		String fname=sc.next();
		System.out.print("Enter lastName");
		String lname=sc.next();
		System.out.print("Enter Email");
		String email=sc.next();
		System.out.print("Enter Pass");
		String pass=sc.next();
		System.out.print("Enter Mobile");
		long mobile=sc.nextLong();
		sc.nextLine();
		System.out.print("Enter Address");
		String address=sc.next();
		
		// the following driver class connects us oracle DB
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pat","pat"); 
		
		
		Statement stmt=con.createStatement();  
		
		// pk generation
		int regid=0;
		ResultSet rs= stmt.executeQuery("select ma(regid) from register");
		if(rs.next()){
			regid=rs.getInt(1);
		}
		regid++;
		
		
		PreparedStatement pstmt=con.prepareStatement("INSERT INTO register VALUES (?, ?, ?, ?, ?, ?, ?, )");
		
		pstmt.setInt(1, regid);
		pstmt.setString(2, fname);
		pstmt.setString(3, lname);
		pstmt.setString(4, email);
		pstmt.setString(5, pass);
		pstmt.setLong(6, mobile);
		pstmt.setString(7, address);
		pstmt.executeUpdate();
		pstmt.close(); rs.close(); stmt.close(); con.close();
	}
}
