package com.java8.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OptionalEx {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(12,43);
		isEmpty(list);
	}

	public static void isEmpty(List<Integer> list) {
		Optional.ofNullable(list)
				.orElseGet(Collections::emptyList)
				.stream()
				.filter(Objects::nonNull)
			//	.map(note->Notes::getNotesTag)
				.forEach(System.out::println);
	}
}
