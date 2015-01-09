package db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
 



import org.gjt.mm.mysql.Driver;

import com.mysql.jdbc.*;

public class Dbdriver {
	public static Connection getConn() {
		Connection conn = null;
		String url = null;
		String username = null;
		String password = null;
		try {
			InputStream is =Dbdriver.class.getResourceAsStream("/db.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			 
			url = prop.getProperty("jdbc.url");
			username= prop.getProperty("jdbc.username");
			password = prop.getProperty("jdbc.password");
			conn = DriverManager.getConnection(url, username, password);
			//conn=DriverManager.getConnection("jdbc:mysql://sql4.ihostwell.com/db=u103442047_users","u103442047_root","rm041690416");
			//String uuString="http://sql4.ihostwell.com/db=u103442047_users&lang=zh_CN";
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("conn:"+url+","+username+","+password);
		return conn;
	}
	
	public static String driver()
	{
		String driver="com.mysql.jdbc.Driver";
		System.out.println("driver String :"+driver);
		return driver;
	}
	
	
}
