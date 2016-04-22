/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: defines Contract Programmer Employee
 */

public class ContractProgrammer extends Programmer {
	public ContractProgrammer(String name, String ssn) {
		super(name, ssn);
		setJobDescription("Contract programmer");
		setBaseSalary(70000.00);
	}

	public double getSalary() {
		return getBaseSalary();
	}
}
