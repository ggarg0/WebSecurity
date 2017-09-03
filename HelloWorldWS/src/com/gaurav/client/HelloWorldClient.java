package com.gaurav.client;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import weblogic.wsee.security.unt.ClientUNTCredentialProvider;
import weblogic.xml.crypto.wss.provider.CredentialProvider;
import weblogic.xml.crypto.wss.WSSecurityContext;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.imageio.ImageIO;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.MTOMFeature;
import javax.xml.ws.soap.SOAPBinding;

import com.gaurav.ws.HelloWorldImpl;

public class HelloWorldClient {
	public static void main(String[] args) throws Exception {

		URL url = new URL(
				"http://[2001:0:9d38:90d7:489:8de7:3b30:abef]:7001/HelloWorldWS/HelloWorldImplService?WSDL");

		// 1st argument service URI, refer to wsdl document above
		// 2nd argument is service name, refer to wsdl document above
		QName qname = new QName("http://ws.gaurav.com/",
				"HelloWorldImplService");

		Service service = Service.create(url, qname);

		HelloWorldImpl hello = service.getPort(HelloWorldImpl.class);

	

		String USERNAME = "garg";
		String PASSWORD = "pass1234";

		BindingProvider bindingProvider = (BindingProvider) hello;
		Map<String, Object> requestContext = ((BindingProvider)hello).getRequestContext();
		
		requestContext.put(BindingProvider.USERNAME_PROPERTY, USERNAME);
		requestContext.put(BindingProvider.PASSWORD_PROPERTY, PASSWORD);

		System.out.println(hello.getHelloWorldAsString("Gausrav"));

		
	}

	public void getWSconnection() {

	}


}
