package restAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class XMLResponse {
	/*
	 * 1. Index will start from 0, if index not specified then it consider the first one
	 * 
	 * 2. how to automate File upload and download
	 * 
	 * 3. response validation vs schema validation
	 * schema validation: type of data validation is it integer, string ?
	 * response validation: data validation, status code is 200?
	 * 
	 * 4. jsonformatter.org will provide you the json schema when you give json as an input
	 * xml to xsd covert xml response to xml schema --> convertsimple.com
	 * assertThat is used to validate the schema
	 * JSON Schema --- > assertThat.body(JsonSchemaValidator.matchesJsonSchemainClassPath("put the schema.json file under resource path)
	 * XML Schema ---- > assertThat.body(RestAssuredMatchers.matchesXsdinClassPath("put the schema.json file under resource path)
	 * 
	 * postman too doesnt provide xml schema but it provides only schema of Json to compare
	 * 
	 * json response(.json) ----> json schema(.json)
	 * xml response(.xml) ------> xml schema(.xsd)
	 *
	 *
	 *
	 *5. Body(json) ----> request ----> response(json)
	 *Serialization and Deserialization : done because java object are heavy so will be sent through json  .
	 *Converting POJO object to JSON object - Serialization
	 *Converting JSON object back to POJO - Deserailization
	 *
	 *
	 * 
	 */
	
	@Test
	void testXMLResponse()
	{
		given()
		
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
		.statusCode(200)
		.header("Content-Type","application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		
		.body("TravelerinformationResponse.travelers.Travelerinformation[4].name", equalTo("Ashor"));
	}

	
	@Test(priority=1)
	void printXMLResponse()
	{
		Response res = given()
		
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		System.out.println(res.header("Content-Type"));
		Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
		
		
		String pageNum= res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNum, "1");
		
		String travellerName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[4].name").toString();		
		System.out.println(travellerName);
		
		Assert.assertEquals(travellerName, "Ashor");
		
		//Approch 2
		
		XmlPath xmlp = new XmlPath(res.asString());
		
		List<String> travellerInfo =  xmlp.getList("ravelerinformationResponse.travelers.Travelerinformation.name");
		
		for(String trName : travellerInfo)
		{
		 System.out.println(trName);
		}
	}
}
