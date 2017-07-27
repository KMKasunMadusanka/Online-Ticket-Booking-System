package com.user.management.jaxrs.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserService {

public static Map<String, Map<String, String>> User = new HashMap<>();
	
	UserService UserService = new UserService();
	
	@POST
    @Consumes("text/plain")
    @Produces("MediaType.APPLICATION_JSON") 
    @Path("/post")
	public Response insertUsers(
			 @QueryParam("id") String id,
			 @QueryParam("Name") String Name,
	         @QueryParam("Telephone") String Telephone,
	         @QueryParam("Email") String Email,
	         @QueryParam("Address") String Address,
	         @QueryParam("Password") String Password){
	     
	         Map<String, String> info = new HashMap<>();
	         
	         info.put("Name", Name);
	         info.put("Telephone", Telephone);
	         info.put("Email", Email);
	         info.put("Address", Address);
	         info.put("Password", Password);
	         
	         User.put(id, info);
	         Message msg = new Message();
	         msg.setMessage("Successfully registered");
	         return Response.ok(msg).build();

	    }
	
	public Map<String, String> GetUserData(){
		
		Map<String, String> User = new HashMap<>();
		
		User.put("abc", "123");
		User.put("ccc", "111");
		
		
		
		return User;
	}

	@POST
    @Consumes("text/plain")
    @Produces("MediaType.APPLICATION_JSON")
    @Path("/authenticate")
    public boolean getAuthentication(
    @QueryParam("username") String username,
	@QueryParam("password") String password) {
        
		if(UserService.GetUserData().containsKey(username)){
			
			if(UserService.GetUserData().get(username)==password){
				return true;
			}
			
		}
		
		
		return false;
     }

	
	
	
	
	
}