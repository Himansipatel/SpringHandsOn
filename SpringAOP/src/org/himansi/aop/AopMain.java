package org.himansi.aop;

import org.himansi.aop.model.Circle;
import org.himansi.aop.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//		give bean name and class name so that getbean method automatically takes care of casting it
		
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		
		System.out.println(shapeService.getCircle().getName());
		System.out.println(shapeService.getTriangle().getName());
//		shapeService.getCircle().setName("Dummy Name");
		
		shapeService.getCircle().cetReturn(1);
		
		Circle circle = shapeService.getCircle();
		shapeService.setCircle(circle);

	}

}
