package api.endpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import io.restassured.response.Response;
import api.payload.*;
//create to perform CRUD operation
public class UserEndpoints2 {
	
	
	static ResourceBundle getUrl() {
		ResourceBundle routes=  ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createUser(User payload) {
		
		String post_url=getUrl().getString("post_url");
		
	Response response=	given()
		.contentType("application/json")
		.accept("application/json")
		.body(payload)
		.when()
		.post(post_url);

	return response;
		
		
	}
	
	public static Response readUser(String username) {
		String get_url=getUrl().getString("get_url");
		Response response=	given()
			
			.pathParam("username", username)
			.when()
			.get(get_url);

		return response;
			
			
		}
	
	public static Response updateUser(User payload,String username) {
		String update_url=getUrl().getString("update_url");
		Response response=	given()
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
			.pathParam("username", username)
			.when()
			.put(update_url);

		return response;
			
			
		}
	
	public static Response deleteUser(String username) {
		String delete_url=getUrl().getString("delete_url");
		Response response=	given()
			
			.pathParam("username", username)
			.when()
			.delete(delete_url);

		return response;
			
			
		}
	
	
	
	
	
	
	
	

}
