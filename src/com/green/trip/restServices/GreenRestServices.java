package com.green.trip.restServices;


import java.sql.SQLException;
import java.sql.Statement;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType; 
import org.json.simple.JSONValue;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.green.trip.db.SqlDataBaseConnection;
import com.green.trip.model.Customer;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


@Path("/parent")
public class GreenRestServices {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	public Response getFirstMethodValue(@QueryParam("txtFname") String name) 
	{
		System.out.println("Inside Get Part");
		 Customer cust = new Customer();
		 cust.setFirstName("Sam");
		 cust.setLastName("Korah");
		 cust.setCustEmail("samkorah@yahoo.com");
		 cust.setCustLocId(20);
		 cust.setCustomerId(100);  //Generate Cust ID using 
		 cust.setCustType("Owner");
		 cust.setNickName("samk");
		 cust.setCustStatus("Active");
		 cust.setCustContact("805-608-9183");
		 cust.setVehicleId(10);
		 GsonBuilder gb = new GsonBuilder();
		 Gson g = gb.create();
		 System.out.println(g.toJson(cust));
		//String headerName=httpReq.getHeaderValue("name").toString();
		//System.out.println("Name>>>>>>>>> "+headerName );
		//String returnXMl="<root><name>"+name+"</name><location>madurai</location></root>";
	//	return Response.status(200).entity(returnXMl).build();
		return Response.status(200).entity(g.toJson(cust)).build();
	}
	
	@POST
	@Path("/child")
	@Produces(MediaType.APPLICATION_XML)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
	public Response getNestedMethodValue(String data)
	{
		
		//String result = "Data post: "+ data;
		System.out.println(data);
		//Parsing JSON
		  String txtFname1="";
		  int counter=0;
		  long idCount=0;
		  String txtLname1="";
		try{
			JSONObject jsonObj = new JSONObject();
			 jsonObj = (JSONObject)JSONValue.parse(data);
			 // Object obj=JSONValue.parse(data);
			//  JSONArray array=(JSONArray)obj;
			  System.out.println("======the 2nd element of array======");
			  System.out.println(jsonObj.get("txtFname").toString());
			  System.out.println();
			  counter=Integer.parseInt(jsonObj.get("Age").toString()); 
			  txtFname1= jsonObj.get("txtFname").toString();            
			  txtLname1= jsonObj.get("txtLname").toString();
			  
			/*  GsonBuilder gb = new GsonBuilder();
			  Gson g = gb.create();
			  //g.toJson()*/
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	         
		Statement stmt=null;
		try{
		//String sql = "SELECT idtesttab, testdesc1, testdesc2 FROM mainschema.testtab";
		String insertq="INSERT INTO mainschema.testtab ( idtesttab, testdesc1, testdesc2 ) VALUES ("+counter+",'"+txtFname1+"','"+txtLname1+"')";
		int result=SqlDataBaseConnection.getDbCon().insert(insertq);
		System.out.println("Insert Resuly: " + result);
		}
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      }//end finally try
		  
		
		
		//return Response.status(200).entity(result).build();
		//String area="chennai";
		String returnXMl="<root><name>sasi</name><location>"+data+"</location></root>";
		return Response.status(200).entity(returnXMl).build();
	}

	private long getCutId()
	{
		long id=0;
		return(id);
	}
	
	
}

