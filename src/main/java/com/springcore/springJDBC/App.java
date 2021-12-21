package com.springcore.springJDBC;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springcore.springJDBC.dao.StudentDao;
import com.springcore.springJDBC.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("!!!___Program is getting Started___!!!");
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);
		StudentDao bean = applicationContext.getBean("studentDao", StudentDao.class);
		
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter 1 for Entering the new record of Student.");
			System.out.println("Enter 2 for Updating the record of Student by ID.");
			System.out.println("Enter 3 for Deleting the record of Student.");
			System.out.println("Enter 4 for Selecting the particular record.");
			System.out.println("Enter 5 for Selecting the whole record.");
			System.out.println("Enter 6 for Stopping the app.");
			System.out.println("Enter the operation number...");
			int ch=sc.nextInt();
			
			switch(ch) 
			{
				case 1:
					System.out.println("Enter the Id of student:");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name of student:");
					String name=sc.nextLine();
					System.out.println("Enter the city of student:");
					String city=sc.nextLine();
					
					Student student = new Student();
					student.setId(id);
					student.setName(name);
					student.setCity(city);
					int r=bean.insert(student);
					System.out.println(r+" Row inserted.");
					break;
					
				case 2:
					System.out.println("Enter the Existing Id of student:");
					int existingid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the New name of student:");
					String newname = sc.nextLine();
					System.out.println("Enter the New city of student:");
					String newcity=sc.nextLine();
					
					Student student1 = new Student();
					student1.setId(existingid);
					student1.setName(newname);
					student1.setCity(newcity);
					int u=bean.change(student1);
					System.out.println(u+" Row updated.");
					break;
					
				case 3:
					System.out.println("Enter the Existing Id of student to be deleted:");
					int eid=sc.nextInt();
					sc.nextLine();
					int d=bean.delete(eid); 
				    System.out.println("Row with "+eid+" deleted");
				    break;
				    
				case 4:
					System.out.println("Enter the Existing Id of student to be fetched:");
					int fid=sc.nextInt();
					sc.nextLine();
					Student student2=bean.getStudent(fid); 
					System.out.println(student2);
					break;
					
				case 5:
					System.out.println("All data is there.");
					List<Student> all = bean.getAll();
					for (Student s : all) {
						System.out.println(s);
					}
					break;
					
				case 6:
					System.exit(0);
					break;
		
				}
		}

		
	}
}
