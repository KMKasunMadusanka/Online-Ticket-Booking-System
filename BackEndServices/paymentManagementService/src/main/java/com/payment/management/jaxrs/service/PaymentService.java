package com.payment.management.jaxrs.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/payments")
public class PaymentService {

	Message msg = new Message();

	public static Map<String, Map<String, String>> payment = new HashMap<>();
	
	 Map<String, Double> CardDetails = new HashMap<>();
	

	@POST
   @Consumes("text/plain")
   @Produces("MediaType.APPLICATION_JSON") 
   @Path("/doPayment")
	public Response insertUsers(
			 @QueryParam("PaymentId") String PaymentId,
			 @QueryParam("Amount") Double Amount,
	         @QueryParam("Status") String Status,
	         @QueryParam("CardNo") String CardNo ){
		
		
		//enter values to cardDetails Map
		
		CardDetails.put("0717656657",45200.00);
		CardDetails.put("0773010177",100000.00);
		CardDetails.put("0718656657",50000.00);
		
		
		PaymentId = PaymentId.trim();
	     if (CardDetails.containsKey(PaymentId)) {
	    	
	    	 double cardValue = CardDetails.get(PaymentId);
	    	
	    	if(cardValue>=Amount){
	    		
	    		 Map<String, String> info = new HashMap<>();
		         
		       
		         info.put("Amount", Double.toString(Amount));
		         info.put("Status", Status);
		         info.put("CardNo", CardNo);
		          
		         payment.put(PaymentId,info);
		         
		         
		         msg.setMessage("Payment Successful");
		         return Response.ok(msg).build();
	    	}
	    	else
	    	{
	    		 
		         msg.setMessage("Payment UnSuccessful... Account Value Is Not Enough to do the transaction.");
		         return Response.ok(msg).build();
	    	}
	    	
	     }
	        
	     
        msg.setMessage("Invalid Card No.");
        return Response.ok(msg).build();  
	         

	    }
	

	
}
	
