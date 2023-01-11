package com.menu;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.SMS;

public class Menu {

	public void menu() {
		Scanner s = new Scanner(System.in);
		int ch;
		System.out.println("Select an option from the menu: ");
		System.out.println();
		System.out.println("1. Insert new Student Data");
		System.out.println("2. See existing Student Data");
		System.out.println("3. Update any Student Data");
		System.out.println("4. Delete any Student Data");
		System.out.println();
		System.out.println("Enter your choice: ");
		ch = s.nextInt();

		SessionFactory sf = com.connection.Connection.con();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();

		switch (ch) {
		case 1:
			SMS s1 = new SMS();
			System.out.println("Enter Student ID: ");
			s1.setS_id(s.nextInt());
			System.out.println("Enter Student Name: ");
			s1.setS_name(s.next());
			System.out.println("Enter Student Contact Number: ");
			s1.setS_contact(s.next());
			System.out.println("Enter Student Address: ");
			s1.setS_address(s.next());
			sess.save(s1);
			tr.commit();
			System.out.println("Object Saved...");

			break;
		case 2:
			SMS read = new SMS();
			System.out.println("Enter the student id: ");
			read = sess.get(SMS.class, s.nextInt());
			System.out.println(read);
			tr.commit();
			break;
		case 3:
			SMS update = new SMS();
			System.out.println("Enter Student ID: ");
			update = sess.load(SMS.class, s.nextInt());
			System.out.println("Enter Student Name: ");
			update.setS_name(s.next());
			System.out.println("Enter Student Contact Number: ");
			update.setS_contact(s.next());
			System.out.println("Enter Student Address: ");
			update.setS_address(s.next());
			sess.save(update);
			tr.commit();
		case 4:
			SMS delete = new SMS();
			System.out.println("Enter Student ID: ");
			delete = sess.load(SMS.class, s.nextInt());
			sess.delete(delete);
			sess.save(delete);
			tr.commit();
		}
		s.close();
	}
}
