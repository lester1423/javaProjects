/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: defines general employee object
 */

import java.text.DecimalFormat;

public class Employee {
	private String jobDescription = "Employee";
	private String name;
	private String ssn;
	private double baseSalary;

	public Employee(String name, String ssn) {
	  this(name, ssn, 35000);
	}

	public Employee(String name, String ssn, double baseSalary) {
	  this.setName(name);
	  this.setSsn(ssn);
	  this.setBaseSalary(baseSalary);
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	private void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public double getSalary() {
		return baseSalary;
	}

	protected double getBaseSalary() {
		return baseSalary;
	}

	protected void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return getJobDescription() + " " + getName() + " with SSN " + getSsn()
			+ " has salary $" + df.format(this.getSalary());
	}

	public boolean equals(Object other) {
		return other instanceof Employee
			&& this.ssn.equals(((Employee)other).ssn);
	}
}
