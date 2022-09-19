package com.pankiba.generics.boundedwildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayWithUpperBoundedWildCard {

	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		sumOfList(integerList);

		List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
		sumOfList(doubleList);

		ArrayList<Integer> intArrList = new ArrayList<>();

	}

	/**
	 * Use extends when you only get values out of data structure
	 * 
	 * An upper bounded wild card uses the extends keyword to set a superclass limit. For example, to define a list of
	 * numbers that will allow int's, long's, double's, and even BigDecimal instances to be added to it
	 * 
	 * ? extends Number translates to "any type that is an Number type or its sub type"
	 * 
	 */

	public static void sumOfList(List<? extends Number> list) {

		double totalValue = list.stream().mapToDouble(Number::doubleValue).sum();
		log.info(" sum = {} ", totalValue);
	}
}
