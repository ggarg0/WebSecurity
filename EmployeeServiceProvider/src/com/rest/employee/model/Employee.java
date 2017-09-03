package com.rest.employee.model;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 

@XmlRootElement
public class Employee {

	public Employee()
	{}
	
	@XmlElement(name="EmpID", required=true)
	private int EmployeeId;
	private String EmployeeName;
	private String EmployeeMail;
	
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	@XmlElement(name="EmpName", required=true)
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	
	@XmlElement(name="EmpMail", required=true)
	public String getEmployeeMail() {
		return EmployeeMail;
	}
	public void setEmployeeMail(String employeeMail) {
		EmployeeMail = employeeMail;
	}
	
} 
