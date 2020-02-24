package inputFROMuser;
import java.sql.*;

public class EmployeeDetails {
	
	
	public static void main(String[] args) {
		
		try {
		
		// Register the driver class
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
        
		// Create the connection object
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearndb", "root", "root");
		
		// Create the statement object
		
		PreparedStatement stmt = con.prepareStatement("UPDATE employee SET empname = ? WHERE empid = ?");
		
		// Values to be updated
		
		stmt.setString(1, "King Kochaar");
		stmt.setInt(2, 1);
		
		// Create the resultSet object and execute the query
		
		int result = stmt.executeUpdate();
		
		// Display records
		
		if (result > 0 ) {
			System.out.println(result + " record updated");
		}

		// Close the connection
		
		con.close();
		
		} catch (Exception ex) {
			
        System.out.println("Error Message: "+ ex);      
		
		}
		
}

}
