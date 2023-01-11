package com.connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.entity.SMS;

public class Connection {

	private static SessionFactory sf;

	public static SessionFactory con() {
		Configuration con = new Configuration();
		Properties prop = new Properties();
		prop.put(Environment.USER, "root");
		prop.put(Environment.PASS, "pranjal2717");
		prop.put(Environment.URL, "jdbc:mysql://localhost:3306/project");
		prop.put(Environment.HBM2DDL_AUTO, "update");
		prop.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		prop.put(Environment.SHOW_SQL, "true");
		prop.put(Environment.FORMAT_SQL, "true");
		prop.put(Environment.USE_SQL_COMMENTS, "true");
		con.setProperties(prop);
		con.addAnnotatedClass(SMS.class);
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		sf = con.buildSessionFactory(sr);
		return sf;

	}
}
