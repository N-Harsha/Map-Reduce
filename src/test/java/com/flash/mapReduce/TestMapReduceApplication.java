package com.flash.mapReduce;

import org.springframework.boot.SpringApplication;

public class TestMapReduceApplication {

	public static void main(String[] args) {
		SpringApplication.from(MapReduceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
