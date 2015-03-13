package com.intelcia.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] {"spring-config.xml"});
 
		CustomerService cust = (CustomerService) appContext.getBean("customerService");
 
		System.out.println("*************************");
		cust.printURL();
		System.out.println("*************************");

        cust.printThrowException();

		System.out.println("*************************");

 
	}
}