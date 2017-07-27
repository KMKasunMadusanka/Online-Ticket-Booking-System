package com.film.management.jaxrs.service.Message;


import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.*;

@Path("/films")
public class FilmService {

	FilmService filmManagementService = new FilmService();
	
	public Map<String,String> getAllMovies(){
		Map<String, String> Movies = new HashMap<>();
		
		Movies.put("Ali Kathava", "Libearty Plaza,Amity,Savoy");
		Movies.put("Dispickable Me3", "Libearty Plaza,Amity,Savoy");
		Movies.put("Transformers", "Libearty Plaza,Amity,Savoy");
		
		
		return Movies;
		
	}
	
	@GET
    @Consumes("text/plain")
    @Produces("MediaType.APPLICATION_JSON")
	@Path("/get")
    public Map<String,String> getMovies() {
        
		
		return filmManagementService.getAllMovies();
     }
 

	
	
	
}