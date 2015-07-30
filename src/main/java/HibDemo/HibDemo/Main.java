package HibDemo.HibDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tuyenld.bean.Employee;

public class Main {
	private static SessionFactory factory;
	private static Session session;
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		// creating configuration object
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");// populates the data of the
											// configuration file

		// creating seession factory object
		factory = cfg.buildSessionFactory();
		// creating session object
		session = factory.openSession();

		//setEmp();
		getEmp();
		session.close();
	}
	
	public static void setEmp() {
		// creating transaction object
				Transaction t = session.beginTransaction();

				Employee e1 = new Employee();
				e1.setId(115);
				e1.setFirstName("sonoo");
				e1.setLastName("jaiswal");

				session.persist(e1);// persisting the object

				t.commit();// transaction is committed
				

				System.out.println("successfully saved");
	}
	
	
	public static void getEmp() {
		// creating transaction object
		Transaction t = session.beginTransaction();
		Employee e1 = (Employee) session.get(Employee.class, 115);
		System.out.println("Employee id :" + e1.getId());
		System.out.println("Employee first name :" + e1.getFirstName());
		System.out.println("Employee last name :" + e1.getLastName());
		t.commit();// transaction is committed
		
	}
}
