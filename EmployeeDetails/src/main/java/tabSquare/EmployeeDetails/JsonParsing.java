package tabSquare.EmployeeDetails;


import io.restassured.path.json.JsonPath;

public class JsonParsing {
	
	public static void jsonParseAndPrintEmployeeDetails(String jsonResponse)
	{
		
		JsonPath js=new JsonPath(jsonResponse);
		//Get the count of Employee Details
		int count=	js.getInt("employeeDetails.size()");
		
		System.out.println("The address is "+js.get("address"));
		
		
		for(int i=0;i<count;i++)
		  {    
			  System.out.println("The employee "+(i+1)+ " details as below");
			  //String courseTitles=js.get("employeeDetails["+i+"].title");
			  System.out.println("FirstName: "+ js.get("employeeDetails["+i+"].firstName").toString());
			  System.out.println("LastName: "+js.get("employeeDetails["+i+"].lastName").toString());
			  System.out.println("DateOfBirth: "+js.get("employeeDetails["+i+"].DOB").toString());
			  
			  //System.out.println(courseTitles);
			  
		  }
		
	}

}
