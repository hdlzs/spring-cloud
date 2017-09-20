package com.emsoft.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class EurekaclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}

	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		Enumeration e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String ke = (String) e.nextElement();
			String value = request.getHeader(name);
			System.out.println(ke+" = "+value);

		}
		e = request.getParameterNames();
		while(e.hasMoreElements()){
			String ke = (String) e.nextElement();
			String value = request.getParameter(name);
			System.out.println(ke+" = "+value);

		}
		return "hi "+name+",i am from port:" +port;
	}

}
