package com.rest.employee.client;

import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeeDELETEClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource=client.resource
				("http://localhost:7001/EmployeeServiceProvider/rest/emp/delete/100");
		
		ClientResponse response = 
				webResource.type("application/xml").delete(ClientResponse.class);
		System.out.println("Delete operation response processing... ");

		String output=response.getEntity(String.class);
		System.out.println("Output : "+ output);

	}

}
