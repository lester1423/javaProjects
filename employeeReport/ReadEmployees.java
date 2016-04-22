/*
     Author: Jacob Lester
     Course Section: CSC 260-002
     Date: 11/17/15
     Assignment: HW8
     Description: reads text file of employee data
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class ReadEmployees {

	public static void main(String[] args) throws Exception  {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Scanner input = new Scanner(new File("/Users/Jake/Documents/CSC 260/workspace1/Assignment8/Employees.txt"));
		double totalSalary = 0;
		double avgTotalSalary = 0;
		int programmers = 0;
		double totalProgrammerSalary = 0;
		double avgProgrammerSalary = 0;
		int javaProgrammers = 0;
		double totalJavaSalary = 0;
		double avgJavaSalary = 0;
		int ocamlProgrammers = 0;
		double totalOcamlSalary = 0;
		double avgOcamlSalary = 0;
		for (int i=0; i<8; i++) {
			String inputLine = input.nextLine();
			String[] details = inputLine.split(":");
			switch(details[0]) {
				case "Employee": Employee e = new Employee(details[1], details[2]);
					employees.add(e);
					break;
				case "Clerical worker": ClericalWorker cw = new ClericalWorker(details[1], details[2]);
					employees.add(cw);
					break;
				case "Programmer": Programmer p = new Programmer(details[1], details[2]);
					if (details.length > 3) {
						for (int j=3; j<details.length; j++) {
							p.addTechnology(details[j]);
						}
					}
					employees.add(p);
					break;
				case "Web developer": WebDeveloper w = new WebDeveloper(details[1], details[2]);
					if (details.length > 3) {
						for (int j=3; j<details.length; j++) {
							w.addTechnology(details[j]);
						}
					}
					employees.add(w);
					break;
				case "Contract programmer": ContractProgrammer cp = new ContractProgrammer(details[1], details[2]);
					if (details.length > 3) {
						for (int j=3; j<details.length; j++) {
							cp.addTechnology(details[j]);
						}
					}
					employees.add(cp);
					break;
				}
		}

		input.close();

		for(Employee staff: employees) {
			totalSalary += staff.getSalary();
			if(staff instanceof Programmer) {
				programmers++;
				totalProgrammerSalary += staff.getSalary();
				if(((Programmer)staff).knowsTechnology("Java")) {
					javaProgrammers++;
					totalJavaSalary += staff.getSalary();
				}
				else if(((Programmer)staff).knowsTechnology("Ocaml")) {
					ocamlProgrammers++;
					totalOcamlSalary += staff.getSalary();
				}
			}
		}

		avgTotalSalary = totalSalary / employees.size();
		avgProgrammerSalary = totalProgrammerSalary / programmers;
		avgJavaSalary = totalJavaSalary / javaProgrammers;
		avgOcamlSalary = totalOcamlSalary / ocamlProgrammers;


		// Write text file EmployeeReport.txt
		PrintWriter output = new PrintWriter("/Users/Jake/Documents/CSC 260/workspace1/Assignment8/EmployeeReport.txt");

		for(Employee staff: employees) {
			output.println(staff.toString());
		}
		output.println();

		DecimalFormat df = new DecimalFormat("$#,##0.00");
		output.println("Number of employees: " + employees.size() + "\nTotal of employee salaries: " + df.format(totalSalary) + ((employees.size() != 0)? "\nAverage salary of employees: " + df.format(avgTotalSalary) : ""));
		output.println();

		output.println("Number of programmers: " + programmers + "\nTotal of programmer salaries: " + df.format(totalProgrammerSalary) + ((programmers != 0)? "\nAverage salary of programmers: " + df.format(avgProgrammerSalary) : ""));
		output.println();

		output.println("Number of Java programmers: " + javaProgrammers + "\nTotal of Java programmer salaries: " + df.format(totalJavaSalary) + ((javaProgrammers != 0)? "\nAverage salary of Java programmers: " + df.format(avgJavaSalary) : ""));
		output.println();

		output.println("Number of Ocaml programmers: " + ocamlProgrammers + "\nTotal of Ocaml programmer salaries: " + df.format(totalOcamlSalary) + ((ocamlProgrammers != 0)? "\nAverage salary of Ocaml programmers: " + df.format(avgOcamlSalary) : ""));
		output.println();

		output.close();
	}
}
