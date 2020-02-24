package prepareStatement;
import java.sql.*;

public class EmployeeDetails {
	
	
	public static void main(String[] args) {
		
		try {
		
		// Register the driver class
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
        
		// Create the connection object
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearndb", "root", "root");
		
		// Create the statement object
		
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM employee");
		
		// Create the resultSet object and execute the query
		
		ResultSet rs = stmt.executeQuery();
		
		// Display records
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+ ". " + rs.getString(2));
		}

		// Close the connection
		
		con.close();
		
		} catch (Exception ex) {
			
        System.out.println("Error Message: "+ ex);      
		
		}
		
}

}
