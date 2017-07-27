package com.snack.management.jaxrs.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.*;

@Path("/sancks")

public class SnackService {

	public Map<String,String> getSnackDetails(){
		Map<String, String> snack = new HashMap<>();
		
		snack.put("P&S", "Malupan:30,CreamBun:50,coolDrink:50");
		snack.put("PizzaHut", "Pizza:300,coolDrink:30");
		
		
		
		return snack;
		
	}
		SnackService  snackManagementService = new SnackService();
		
		@GET
	    @Consumes("text/plain")
	    @Produces("MediaType.APPLICATION_JSON")
	    @Path("/get")
	    public Map<String,String> getSnack() {
	        
			
			return snackManagementService.getSnackDetails();
	     }
		
		
		
		

}


