package searchRecord;
import java.sql.*;

public class EmployeeDetails {
	
	
	public static void main(String[] args) {
		
		try {
		
		// Register the driver class
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
        
		// Create the connection object
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearndb", "root", "root");
		
		// Create the statement object
		
		Statement stmt = con.createStatement();
		
		// Create the resultSet object and execute the query
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM employee where empid = 4");
		
		// Display records
		
		if (rs.next()) {
			System.out.println(rs.getInt(1)+ ". " + rs.getString(2));
		}

		// Close the connection
		
		con.close();
		
		} catch (Exception ex) {
			
        System.out.println("Error Message: "+ ex.getMessage());      
		
		}
		
}

}
