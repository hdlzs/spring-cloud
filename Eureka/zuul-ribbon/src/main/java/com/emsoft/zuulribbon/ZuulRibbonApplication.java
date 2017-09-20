package com.emsoft.zuulribbon;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableZuulProxy
@SpringBootApplication
@EnableHystrix
public class ZuulRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulRibbonApplication.class, args);
	}
}
