import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnectionManager;

public class RegisterServlet extends HttpServlet {
    
    @Override 
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
    	String name = req.getParameter("name");
    	String surname = req.getParameter("surname");
    	
    	System.out.println("name: " + name);
    	System.out.println("surname: " + surname);
    	
    	DBConnectionManager dbMan = DBConnectionManager.getInstance();
    	
    	try (Connection conn = dbMan.getConnection()) {
    		
    		String insertSQL = "insert into users(name, surname) values(?, ?)";
    		
    		PreparedStatement stmt = conn.prepareStatement(insertSQL);
    		
    		stmt.setString(1, name);
    		stmt.setString(2, surname);
    		
    		int rowsNum = stmt.executeUpdate();
    		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    
    }
}
