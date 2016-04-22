/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: defines Clerical Worker Employee
 */

public class ClericalWorker extends Employee
{
	public ClericalWorker(String name, String ssn)
	{
		super(name, ssn, 45000.00);
		setJobDescription("Clerical worker");
	}
}
