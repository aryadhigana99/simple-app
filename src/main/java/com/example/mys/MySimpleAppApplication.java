package com.example.mys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class MySimpleAppApplication {

	@RequestMapping(value="/")
	public String coba() {
		return "<h1> Hello World 1 </h1>";
	}
	
// 	@RequestMapping(value="/hello2")
// 	public String coba2() {
// 		return "<h1> Hello World </h1>";
// 	}
	
	public static void main(String[] args) {
		SpringApplication.run(MySimpleAppApplication.class, args);
	}

}
