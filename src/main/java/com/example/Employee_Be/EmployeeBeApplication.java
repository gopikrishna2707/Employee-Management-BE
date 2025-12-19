package com.example.Employee_Be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class EmployeeBeApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeBeApplication.class, args);
		List<String> sList = List.of("Ajay", "balu","dev", "gop");
		sList.forEach(System.out::println);
		List<String> result = sList.stream().filter(e -> e.startsWith("A")).collect(Collectors.toList());
		System.out.println(result + "list");
		System.out.println("good to start");

	}
}
