package com.pankiba.streams.nonterminal;

import java.util.List;
import java.util.function.Predicate;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithFilter {

	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("filter - traditional");
		employeeList.stream().filter(new EmployeePredicate()).forEach(new EmployeeConsumer());

		ApplicationUtils.logHeader("filter - lambda expression");
		employeeList.stream().filter(employee -> employee.getSalary() > 20000L).forEach(System.out::println);

		ApplicationUtils.logHeader("filter - composed predicate - logical AND");

		Predicate<Employee> predicate1 = employee -> employee.getSalary() > 20000L;
		Predicate<Employee> predicate2 = employee -> employee.getGender().equals("F");

		employeeList.stream().filter(predicate1.and(predicate2)).forEach(System.out::println);

		ApplicationUtils.logHeader("filter - composed predicate - logical OR");
		employeeList.stream().filter(predicate1.or(predicate2)).forEach(System.out::println);

	}
}

class EmployeePredicate implements Predicate<Employee> {

	@Override
	public boolean test(Employee employee) {
		return employee.getSalary() > 20000L;
	}
}
