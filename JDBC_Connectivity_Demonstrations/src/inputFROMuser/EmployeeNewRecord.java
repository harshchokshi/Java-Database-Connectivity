package inputFROMuser;
import java.sql.*;
import java.util.Scanner;

public class EmployeeNewRecord {


	private int empid;
	private String empname;
	
	
	public static void main(String[] args) {
		EmployeeNewRecord eds = new EmployeeNewRecord();
		eds.getFromUser();
		try {
		
		// Register the driver class
			
		Class.forName("com.mysql.cj.jdbc.Driver");	
        
		// Create the connection object
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplilearndb", "root", "root");
		
		// Create the statement object
		
		PreparedStatement stmt = con.prepareStatement("INSERT INTO employee VALUES (?,?)");
		
		stmt.setInt(1, eds.getEmpid());
		
		stmt.setString(2,eds.getEmpname());
		
		// Create the resultSet object and execute the query
		
		int result = stmt.executeUpdate();
		
		// Display records
		
		if (result > 0 ) {
			System.out.println(result + " record inserted");
		}

		// Close the connection
		
		con.close();
		
		} catch (Exception ex) {
			
        System.out.println("Error Message: "+ ex);      
		
		}
		
}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void getFromUser () {
		int empId;
		String empName;
		Scanner ss = new Scanner (System.in);
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter the employee ID: ");
		
		try {
			empId = sc.nextInt();
		    if ( empId < 0) {
		    	System.out.println("Invalid Input");
		    	getFromUser();
		    }
		    setEmpid(empId);
		} catch (Exception e) {
			System.out.println("You have not enter the number");
			getFromUser();
		}
	
		System.out.print("Enter the employee Name: ");
		try {
			empName = ss.nextLine();
			setEmpname(empName);
		    if ( empName.matches("")) {
		    	System.out.println("Invalid Input");
		    	getFromUser();
		    }
		} catch (Exception e) {
			System.out.println("Null Value");
			getFromUser();
		}

	}
	
     

}
