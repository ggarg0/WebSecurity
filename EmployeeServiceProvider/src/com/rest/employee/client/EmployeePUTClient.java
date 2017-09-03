package com.rest.employee.client;

import com.rest.employee.model.Employee;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EmployeePUTClient {

	public static void main(String[] args) {
		Client client = Client.create();
		WebResource webResource=client.resource
				("http://localhost:7001/EmployeeServiceProvider/rest/emp/update");
		
		Employee emp = new Employee();
		emp.setEmployeeId(1001);
		emp.setEmployeeName("Gurav Garg");
		emp.setEmployeeMail("gauravgarg.gg25@gmail.com");
		
		ClientResponse response = 
				webResource.type("application/xml").put(ClientResponse.class,emp);
		System.out.println("Update operation response processing... ");
		String output=response.getEntity(String.class);
		System.out.println("Output : "+ output);
	}

}
