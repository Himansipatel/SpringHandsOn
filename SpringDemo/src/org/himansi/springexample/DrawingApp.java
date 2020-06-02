package org.himansi.springexample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {

	public static void main(String[] args) {

		// BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		// application context provides all the functionality which is provided by BeanFactory and many more such as event notification and AOP
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		Triangle trianglebyconstruct = (Triangle) context.getBean("trianglebyconstruct");
		trianglebyconstruct.Draw();
		
		Square square = (Square) context.getBean("square");
		square.Draw();
		
		((ClassPathXmlApplicationContext) context).close(); //bcz close() is not defined in ApplictionContext 

	}

}
