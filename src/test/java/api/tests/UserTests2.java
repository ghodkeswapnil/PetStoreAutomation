package api.tests;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		
		userPayload = new User();
		userPayload.setId(67);
		userPayload.setUsername("swa");
		userPayload.setFirstName("dfghj");
		userPayload.setLastName("dfghj");
		userPayload.setEmail("sfgfduiooo@gmo");
		userPayload.setPassword("wakliihv2123456");
		userPayload.setPhone("1234567890");
		
		//logs
		
		logger=LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void testPostRequest() {
		
		logger.info("****USER POST REQUEST**");
		Response response=UserEndpoints2.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2)
	public void testGetRequest() {
		logger.info("***Get request process**");
		Response response=UserEndpoints2.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	
	@Test(priority = 3)
	public void testUpdateRequest() {
		logger.info("***update request process**");
		userPayload.setFirstName("Mangesh");
		userPayload.setLastName("Gund");
		Response response=UserEndpoints2.updateUser(userPayload, this.userPayload.getUsername());
		response.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority=4)
	public void deleteRequest() {
		logger.info("***delete request process**");
		Response response=UserEndpoints2.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}

}
