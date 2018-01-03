package com.org.ldap;

import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

public class LDAPAccess {

	public LDAPAccess() {

	}
	public void doLookup() {
	Properties properties = new Properties();
	properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	properties.put(Context.PROVIDER_URL, "ldap://localhost:10389/o=myuser");
	properties.put(Context.SECURITY_AUTHENTICATION, "simple");
	properties.put(Context.SECURITY_PRINCIPAL, "uid=ggarg, ou=dev,o=myuser"); //we have 2 \\ because it's a escape char
	properties.put(Context.SECURITY_CREDENTIALS, "pass1");

	try {
	DirContext context = new InitialDirContext(properties);
	System.out.println("Before update..");
	Attributes attrs = context.getAttributes("uid=ggarg, ou=dev");
	System.out.println("Before update1..");
	System.out.println("Surname: " + attrs.get("sn").get());
	System.out.println("Common name : " + attrs.get("cn").get());
	System.out.println("User Id : " + attrs.get("uid").get());
	System.out.println("Password : " + attrs.get("userpassword").get());


	} catch (NamingException e) {
	e.printStackTrace();
	}
	}
	public static void main(String[] args) {
		LDAPAccess sample = new LDAPAccess();
		sample.doLookup();
	}
}
