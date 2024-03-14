package restAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {
	
	/*
	 * 1. Valid users can be checked in Authentication
	 * 
	 * Types of Authentication
	 * Basic 
	 * Digest
	 * Preemptive
	 * 
	 * Bearer Token
	 * OAuth
	 * API Key
	 * 
	 */
	
	@Test
	void basicAuthentication()
	{
		given()
		.auth().basic("postman", "password")
		
		.when()
		.get("https://postman-echo.com/basic-auth")
		
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true));
		
	}

}
