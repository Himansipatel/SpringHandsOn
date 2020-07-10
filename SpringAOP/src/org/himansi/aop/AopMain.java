package org.himansi.aop;

import org.himansi.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class AopMain {

	public static void main(String[] args) {
		ApplicationContext  context = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = context.getBean("shapeService",ShapeService.class);    //give bean name and class name so that getbean method automatically takes care of casting it
		System.out.println(shapeService.getCircle().getName());
//		System.out.println(shapeService.getTriangle().getName());
	}

}
