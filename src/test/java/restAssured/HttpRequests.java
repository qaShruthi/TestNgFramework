package restAssured;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequests {
/* 
 * 1. Gerkins keywords used - given(), when(), then()
 * Need to add static imports so that we can access static members of class directly without class name or instance of it 
 * 2. 
 * Pre Requisite : given() - content type, cookies, add auth, add param, add query param, set header info
 * Request : when() - get, post, put, delete
 * Response : then()- validate status code, status line, extract response, extract headers, cookies and response body
 * 
 * 3. Path & Query Parameters
 * Any number of path parameters which are like variables can have user defined names and query parameters can be defined under given()
 *
 *4 . cookies and Headers:
 *
 *5. log().all() : prints response in console window includes cookie, header, body
 *log().body() -> only response
 *log().cookies() -> only cookies
 *log().headers() -> only headers
 *
 *
 *jsonpathfinder.com, parse json response to find the element and its value
 *
 *JSONObject js = new JSONObject(res.toString());  - converts response to json object type
 */
	
	
	int ID;
	//1. get
	@Test
	void getUsers()
	{
		//https://reqres.in/api/users?page=2
		given()
		.pathParam("mypath", "users")
		.queryParam("page", "2")
		
		
		.when()
		.get("https://reqres.in/api/{mypath}")
		
		
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		
		.log().all();
	}
	
	
	@Test
	void getUser()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users/2")
		
		
		.then()
		  .statusCode(200)
		
		  .log().all();
	}
	
	@Test
	void getCookieDetails()
	{
		//https://reqres.in/api/users?page=2
		
		Response res =
		given()
		.when()
		.get("https://google.com");
		
		
		//single cookie data
		System.out.println(res.getCookie("AEC"));
		
		//all cookie data
		Map<String, String> cookieMap = res.getCookies();
		
		System.out.println(cookieMap.keySet());
		
	}
	
	
	@Test
	void getHeaderDetails()
	{
		//https://reqres.in/api/users?page=2
		
		
		given()
		
		.when()
		.get("https://google.com")
		
		
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		//.and()
		//.header("Content-Encoding", "gZip")
		.log().all();
		
		/*
		 * 
		Response res =
		given()
		.when()
		.get("https://google.com");
		
		
		//single cookie data
		System.out.println(res.getHeader("Content-Type"));
		
		//all cookie data
		Headers myHeader = res.getHeaders();
		
		System.out.println(myHeader.getValue("Content-Type"));
		
		*/
		
	}
	
	//2. post/create
	/* 4 ways to create request body 
	 * 1) Hashmap
	 * 2) Using org.json
	 * 3) using POJO (Plain Old Java Object)
	 * 4) using External Json File
	 */
	@Test
	void postUserUsingHashMap()
	{
        HashMap data = new HashMap();
        data.put("name", "shruthi");
        data.put("job", "engineer");
		
        
        // ID = given()
        
        given()
          .contentType(ContentType.JSON)
          .body(data)
		
		.when()
		  .post("https://reqres.in/api/users")
		  
		 // .jsonPath().getInt("id");
		  
		
         .then()
            .statusCode(201)
            .body("name", equalTo("shruthi"))
            .header("Content-Type", "application/json; charset=utf-8")
            .log().all();
	}
	
	@Test
	void postUserUsingJsonLibrary()
	{
        JSONObject data = new JSONObject();
        data.put("name", "shruthi");
        data.put("job", "engineer");
		
        
        // ID = given()
        
        given()
          .contentType(ContentType.JSON)
          .body(data.toString())
		
		.when()
		  .post("https://reqres.in/api/users")
		  
		 // .jsonPath().getInt("id");
		  
		
         .then()
            .statusCode(201)
            .body("name", equalTo("shruthi"))
            .header("Content-Type", "application/json; charset=utf-8")
            .log().all();
	}
	
	@Test
	void postUserUsingPOJO()
	{
        POJO_PostRequest pojo = new POJO_PostRequest();
        pojo.setName("shruthi");
        pojo.setJob("engineer");
		
        
        // ID = given()
        
        given()
          .contentType(ContentType.JSON)
          .body(pojo)
		
		.when()
		  .post("https://reqres.in/api/users")
		  
		 // .jsonPath().getInt("id");
		  
		
         .then()
            .statusCode(201)
            .body("name", equalTo("shruthi"))
            .header("Content-Type", "application/json; charset=utf-8")
            .log().all();
	}
	
	@Test(enabled=false)
	void postUserUsingExternalJsonFile() throws FileNotFoundException
	{
        File file = new File(".\\employee.json");
        FileReader fr = new FileReader(file);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject jsonObJ = new JSONObject(jt);
		
        
        // ID = given()
        
        given()
          .contentType(ContentType.JSON)
          .body(jsonObJ.toString())
		
		.when()
		  .post("http://localhost:3000/students")// need to run node.js cmd file so that it refers json object with external file data
		  
		 // .jsonPath().getInt("id");
		  
		
         .then()
            .statusCode(201)
            .body("userId", equalTo("rirani"))
            .header("Content-Type", "application/json; charset=utf-8")
            .log().all();
	}
	
	
	//3. put/update
	
	@Test
	void putUser()
	{
        HashMap data = new HashMap();
        data.put("name", "shruthi");
        data.put("job", "Sr engineer");
		
        
        given()
          .contentType(ContentType.JSON)
          .body(data)
		
		.when()
		  .put("https://reqres.in/api/users/" + ID)
		 
		.then()
		  .statusCode(200)
		  .log().all();
	}
	//4. delete
	
	@Test
	void deleteUser()
	{
        
		
		when()
		  .delete("https://reqres.in/api/users/" + ID)
		 
		.then()
		  .statusCode(204)
		  .log().all();
	}
}

class POJO_PostRequest
{
	String name;
	String job;
	
	public String getName()
	{
		return name;
	}
	public void setName(String EName)
	{
	  this.name = EName;
	}
	public String getJob()
	{
		return job;
	}
	public void setJob(String EJob)
	{
		this.job = EJob;
	}
}
