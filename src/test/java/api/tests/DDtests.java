package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class DDtests {
   
	@Test(priority=1,dataProvider="Data",dataProviderClass=Dataproviders.class)
	public void testPost(String id,String uname,String fname,String lname,String email,String pwd,String ph) {
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(uname);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response =UserEndpoints.createUser(userPayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = Dataproviders.class)
	public void testdeleteByUsername(String uname) {
		Response response=UserEndpoints.deleteUser(uname);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
