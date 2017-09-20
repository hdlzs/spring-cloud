package com.emsoft.ribbon;

import com.emsoft.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@EnableZuulProxy
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		System.out.println("in app");
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;
	@RequestMapping(value = "/hi")
	public String hi(@RequestParam String name){
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		System.out.println(url+"  "+method+"  "+uri+"   "+queryString);
		request.setAttribute("myid","fff");
		request.setAttribute("myid","dfd");
		ra.setAttribute("myid","jjj",ra.SCOPE_REQUEST);
		RequestContextHolder.setRequestAttributes(ra);
		Map map = new HashMap();
		map.put("myid","fff");
		return restTemplate.getForObject("http://compute-service/hi?name="+name,String.class,map);
		//String myid = "2";
		//return restTemplate.getForObject("http://compute-service/hi?name="+name,String.class);
	}
}
