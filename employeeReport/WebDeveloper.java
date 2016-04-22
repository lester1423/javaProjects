/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: defines Web Developer Employee
 */

public class WebDeveloper extends Programmer {
	public WebDeveloper(String name, String ssn) {
		super(name, ssn);
		setJobDescription("Web developer");
	}
}
