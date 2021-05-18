package com;

import model.Supplier;
import javax.ws.rs.*; 

import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;

import com.google.gson.*;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 



@Path("/Items") 

public class SupplierService {
	
	Supplier supplierObj = new Supplier();  
	
	//Implement the Read Items Operation 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readSupplier() 
	 { 
		return supplierObj.readsupplier();
	 } 	
	
	//Implement the Create/Insert Item Operation 
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String insertSupplier(@FormParam("Supplier_code") String Supplier_code, 
		@FormParam("Name") String Name, 
		@FormParam("Phone") String Phone) 
		
		{ 
			String output = supplierObj.insertsupplier(Supplier_code, Name, Phone); 
			return output; 
		}
		
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String updatesupplier(String itemData) 
		{ 
		//Convert the input string to a JSON object 
		 JsonObject supplier = new JsonParser().parse(itemData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String supplierID = supplier.get("supplierID").getAsString(); 
		 String Supplier_code = supplier.get("Supplier_code").getAsString(); 
		 String Name = supplier.get("Name").getAsString(); 
		 String Phone = supplier.get("Phone").getAsString(); 
		  
		 String output = supplierObj.updatesupplier(supplierID, Supplier_code, Name, Phone); 
		return output; 
		}
		
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		public String deleteSupplier(String itemData) 
		{ 
		//Convert the input string to an XML document
				 
		 JsonObject supplier = new JsonParser().parse(itemData).getAsJsonObject(); 
		//Read the value from the element <supplierID>
		 String supplierID = supplier.get("supplierID").getAsString(); 
		 String output = supplierObj.deletesupplier(supplierID); 
		return output; 
		}

			
}
