package api.endpoints;

public class Routes {
	
/*
 https://petstore.swagger.io/#/user/createUsersWithListInput
 https://petstore.swagger.io/#/user/getUserByName
 https://petstore.swagger.io/#/user/updateUser
 https://petstore.swagger.io/#/user/deleteUser
 
 */

	
	public static String base_url="https://petstore.swagger.io/v2";
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
}
