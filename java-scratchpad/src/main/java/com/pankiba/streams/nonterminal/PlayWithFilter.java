package com.pankiba.streams.nonterminal;

import java.util.List;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

/**
 * 
 * @author barvepan
 *
 *         filter() method is an intermediate operation of the Stream interface that allows us to filter elements of a
 *         stream that match a given Predicate:
 */
public class PlayWithFilter {
	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("Obtain a list of employee's who are Developer's");

		employeeList.stream().filter(employee -> employee.getGrade().getLevel().equals("Developer"))
				.forEach(System.out::println);

		ApplicationUtils.logHeader("Obtain a list of employee's who are Developer's and female's");

		employeeList.stream().filter(employee -> employee.getGrade().getLevel().equals("Developer"))
				.filter(employee -> employee.getGender().equals("F")).forEach(System.out::println);

	}
}
