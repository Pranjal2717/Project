package com.project.StudentDetails;

import java.util.Scanner;

import com.menu.Menu;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String u_name;
		String pass;
		String uname = "pranjal";
		String upass = "12345";
		System.out.println("****************WELCOME TO STUDENT MANAGEMENT SYSTEM*************");
		System.out.println("                          Admin login");
		System.out.println("Enter Username: ");
		u_name = sc.next();
		System.out.println("Enter Password: ");
		pass = sc.next();

		if (u_name.equals(uname) && pass.equals(upass)) {
			System.out.println("                      Login Success");
			Menu m = new Menu();
			m.menu();

		} else {
			System.out.println("                      Access denied");
		}
		sc.close();
	}
}
