/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: defines Programmer Employee
 */

import java.util.ArrayList;

public class Programmer extends Employee {
	private ArrayList<String> technologies;

	public Programmer(String name, String ssn) {
		super(name, ssn, 65000.00);
		technologies = new ArrayList<String>();
		setJobDescription("Programmer");
	}

	public void addTechnology(String tech) {
		if(!technologies.contains(tech)) {
			technologies.add(tech);
		}
	}

	public double getSalary() {
		double bonus = 0;
		if(technologies.contains("Java")) {
			bonus = 3000.00;
		}
		return super.getSalary() + technologies.size() * 5000.00 + bonus;
	}

	public String toString() {
	    // An efficient implementation that
	    // includes commas where appropriate.
		StringBuilder returnVal = new StringBuilder(super.toString());
		if (technologies.size() > 0) {
			returnVal.append(" and knows ");
			if (technologies.size() == 1) {
				returnVal.append(technologies.get(0));
			}
			else if (technologies.size() == 2) {
				returnVal.append(technologies.get(0));
				returnVal.append(" and ");
				returnVal.append(technologies.get(1));
			}
			else {
				for (int i = 0; i < technologies.size() - 1; i++)
					returnVal.append(technologies.get(i) + ", ");
				returnVal.append("and ");
				returnVal.append(technologies.get(technologies.size() - 1));
			}
		}
		return returnVal.toString();
	}

	public boolean knowsTechnology(String tech) {
		if(technologies.contains(tech)) {
			return true;
		}
		return false;
	}
}
