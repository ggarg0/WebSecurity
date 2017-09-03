package com.gaurav.client;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import com.gaurav.ws.HelloWorld;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name = request.getParameter("txtName");
		
		URL url = new URL("http://localhost:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		//1st argument service URI, refer to wsdl document above
		//2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.gaurav.com/", "HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorld hello = service.getPort(HelloWorld.class);

		
		BindingProvider prov = (BindingProvider)hello;
		prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "garg");
		prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "pass1234");

	
		
		//Application Security
		Map<String, Object> requestContext = ((BindingProvider)hello).getRequestContext();

		requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();

		requestHeaders.put("username", Collections.singletonList("garg"));
		requestHeaders.put("Password", Collections.singletonList("pass1234"));

		requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
		 
		
		System.out.println(hello.getHelloWorldAsString(Name));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
