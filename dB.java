import java.sql.*;

public class dB {
	static Connection conn;
	static Statement myStat;
	static ResultSet yap(String sqlpass) {
		ResultSet myRs=null;
		try {
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/moviebase?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root",sqlpass);
			 myStat=(Statement) conn.createStatement();
			 myRs=myStat.executeQuery("select * from kullanici");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return myRs;
	}
	static ResultSet yapF() {
		ResultSet myRs=null;
		try {
			 myRs=myStat.executeQuery("select * from kullaniciprogram");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return myRs;
	}
	static void ekle(String sql) {
		
		try{
			myStat.executeUpdate(sql);
		}catch(SQLException e2) {
			e2.printStackTrace();
		}
		
	}
	static void update(String sql) {
		try {
			myStat.executeUpdate(sql);
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	static ResultSet sorgula(String sql) {
		ResultSet myRs=null;
		try{myRs=myStat.executeQuery(sql);}
		catch(Exception e3) {
			e3.printStackTrace();
		}
		return myRs;
		
	}
	
}
