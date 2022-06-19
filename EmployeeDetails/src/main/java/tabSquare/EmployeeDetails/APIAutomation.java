package tabSquare.EmployeeDetails;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

/*
 Given curl command (with response):
curl -location -request GET 'https://qvl7e.mocklab.io/tabsquare/employee/details'
{
 "company": "Tabsquare",
 "address": "Singapore",
 "employeeDetails": [
 {
 "firstName": "Budi",
 "lastName": "Cahya",
 "DOB": "221150"
 },
 {
 "firstName": "Susi",
 "lastName": "Kya",
 "DOB": "512300"
 }
 ]
}
Please create an API automation to get the value for "address" and "employeeDetails"

*/
public class APIAutomation {
	public static void main(String[] args) {
		RestAssured.baseURI = "https://qvl7e.mocklab.io";
		String getEmployeeDeatilsResponse = given().when().get("tabsquare/employee/details").then().assertThat()
				.statusCode(200).extract().response().asString();

		JsonParsing.jsonParseAndPrintEmployeeDetails(getEmployeeDeatilsResponse);

	}
}
