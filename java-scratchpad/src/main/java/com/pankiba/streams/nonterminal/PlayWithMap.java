package com.pankiba.streams.nonterminal;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToLongFunction;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithMap {
	public static void main(String[] args) {
		
		ApplicationUtils.logHeader("Obtain a list of employee's who are Developer's and increase their salary by 10%");
		
		List<Employee> employeeList = ApplicationUtils.getTestData();
		
		employeeList.stream().map(new IncrSal()).forEach( em -> System.out.println(em));
		
		
	}
}

class ToLong implements ToLongFunction<Employee> {

	@Override
	public long applyAsLong(Employee value) {
		
		return value.getSalary();
	}
	
}

class IncrSal implements Function<Employee, Long>{

	@Override
	public Long apply(Employee t) {
		
		Long sal = t.getSalary();
		
		sal = (long) (sal + sal * .10);
		
		return sal;
	}
	
}