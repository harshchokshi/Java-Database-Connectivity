package delete;
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
		
		int result = stmt.executeUpdate("DELETE FROM employee WHERE empid = 10");
		
		// Display records
		
		if (result > 0 ) {
			System.out.println(result + " record deleted");
		}

		// Close the connection
		
		con.close();
		
		} catch (Exception ex) {
			
        System.out.println("Error Message: "+ ex);      
		
		}
		
}

}
