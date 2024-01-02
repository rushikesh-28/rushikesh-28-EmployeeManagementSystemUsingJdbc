package com.demo;
import java.util.Scanner;
import com.dao.EmployeeDao;
import com.model.Emplyee;
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	EmployeeDao ed= new EmployeeDao();
    	
    	System.out.println("1.do you want add new data");
    	System.out.println("2.do you want find  data");
    	System.out.println("3.do you want Delete data");
    	System.out.println("4.do you want update data");
    	System.out.println("Enter your choice");
    	int choice=sc.nextInt();
    	switch(choice)
    	{
    	case 1:
    		Emplyee e=new Emplyee();
    		System.out.println("Enter Name:"+" ");
    		e.setEname(sc.next());
    		System.out.println("Enter Company:"+" ");
    		e.setEcompany(sc.next());
    		System.out.println("Enter Edesignation:"+" ");
    		e.setEdesignation(sc.next());
    		System.out.println("Enter Salary:"+" ");
    		e.setEsalary(sc.nextDouble());
    		System.out.print(ed.insertEmployee(e));
    		break;
    	case 2:
    		System.out.print("Enter ID number:");
    		
    		System.out.println(ed.find(sc.nextInt()));
    		break;
    	case 3:
    		System.out.println("Enter ID number:");
    		System.out.println(ed.delete(sc.nextInt()));
    		break;
    	case 4:
    		Emplyee e1=new Emplyee();
    		System.out.println("Enter ID number:"+" s");
    		e1=ed.find(sc.nextInt());
    		System.out.println(e1);
    		System.out.println("1.do you want update ename");
    		System.out.println("2.do you want update ecompany");
    		System.out.println("3.do you want update edesignation");
    		System.out.println("4.do you want update esalary");
    		System.out.println("Enter your choice"+" ");
    		choice=sc.nextInt();
    		switch(choice)
    		{
    		case 1:
    			System.out.print("Enter name"+" ");
    			e1.setEname(sc.next());
    			break;
    		case 2: 
    			System.out.print("Enter company"+" ");
    			e1.setEcompany(sc.next());
    			break;
    		case 3:
    			System.out.print("Enter designation"+" ");
    			e1.setEdesignation(sc.next());
    			break;
    		case 4:
    			System.out.print("Enter salary"+" ");
    			e1.setEsalary(sc.nextDouble());
    			break;
    		}
    		ed.update(e1);
    		}
    	}
       
    }

