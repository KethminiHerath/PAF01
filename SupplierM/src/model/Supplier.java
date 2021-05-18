package model; 
import java.sql.*; 
public class Supplier
{ //A common method to connect to the DB
private Connection connect() 
 { 
 Connection con = null; 
 try
 { 
 Class.forName("com.mysql.jdbc.Driver"); 
 
 //Provide the correct details: DBServer/DBName, username, password 
 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/shop", "root", ""); 
 } 
 catch (Exception e) 
 {e.printStackTrace();} 
 return con; 
 } 
public String insertsupplier(String Supplier_code, String Name, String phone)
 	{ 
		String output = ""; 
	try
	{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
			// create a prepared statement
			String query = " insert into supplier (`supplierID`,`Supplier_code`,`Name`,`Phone`)"
 + " values (?, ?, ?, ?)"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, 0); 
 preparedStmt.setString(2, Supplier_code); 
 preparedStmt.setString(3, Name); 
 
 preparedStmt.setString(4, phone); 
// execute the statement3
 preparedStmt.execute(); 
 con.close(); 
 output = "Inserted successfully"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while inserting the supplier."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String readsupplier() 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for reading."; } 
 // Prepare the html table to be displayed
 output = "<table border='1'><tr><th>Supplier_code</th><th>Name</th>" +
 "<th> Phone</th>" + 
 
 "<th>Update</th><th>Remove</th></tr>"; 
 
 String query = "select * from supplier"; 
 Statement stmt = con.createStatement(); 
 ResultSet rs = stmt.executeQuery(query); 
 // iterate through the rows in the result set
 while (rs.next()) 
 { 
 String supplierID = Integer.toString(rs.getInt("supplierID")); 
 String Supplier_code = rs.getString("Supplier_code"); 
 String Name = rs.getString("Name"); 

 String Phone = rs.getString("Phone"); 
 // Add into the html table
 output += "<tr><td>" + Supplier_code + "</td>"; 
 output += "<td>" + Name + "</td>"; 
 output += "<td>" + Phone+ "</td>"; 
  
 // buttons
 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"+"<td><form method='post' action='Supplier.jsp'>"+"<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"+"<input name='itemID' type='hidden' value='" + supplierID +"'>" + "</form></td></tr>"; 
 } 
 con.close(); 
 // Complete the html table
 output += "</table>"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while reading the supplier."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String updatesupplier(String supplierID, String Supplier_code, String name, String Phone)
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for updating."; } 
 // create a prepared statement
 String query = "UPDATE supplier SET Supplier_code=?,Name=?,Phone=? WHERE supplierID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setString(1, Supplier_code); 
 preparedStmt.setString(2, name); 
 preparedStmt.setString(3, Phone); 
 preparedStmt.setInt(4, Integer.parseInt(supplierID)); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 output = "Updated successfully"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while updating the supplier."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 } 
public String deletesupplier(String supplierID) 
 { 
 String output = ""; 
 try
 { 
 Connection con = connect(); 
 if (con == null) 
 {return "Error while connecting to the database for deleting."; } 
 // create a prepared statement
 String query = "delete from supplier where supplierID=?"; 
 PreparedStatement preparedStmt = con.prepareStatement(query); 
 // binding values
 preparedStmt.setInt(1, Integer.parseInt(supplierID)); 
 // execute the statement
 preparedStmt.execute(); 
 con.close(); 
 output = "Deleted successfully"; 
 } 
 catch (Exception e) 
 { 
 output = "Error while deleting the supplier."; 
 System.err.println(e.getMessage()); 
 } 
 return output; 
 }
public String readItems() {
	// TODO Auto-generated method stub
	return null;
} 
}