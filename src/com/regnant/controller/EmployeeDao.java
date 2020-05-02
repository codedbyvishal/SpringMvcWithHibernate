package com.regnant.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.regnant.dto.Employee;

@Repository("empDao")
public class EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void saveEmployee(final Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.save(employee);
		transaction.commit();
		session.close();
		}

	public boolean isEmployeeExists(String str) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("select count(*) from Employee  where loginname=:inputName");
		q.setParameter("inputName", str);
		long count = (Long) q.uniqueResult();
		session.close();
		return count >= 1 ? true : false;
	}

	public boolean isEmpEmailExist(String str) {
		Session s = sessionFactory.openSession();
		Query q = s.createQuery("select count(*) from Employee where email=:inputemail");
		q.setParameter("inputemail", str);
		long count = (long) q.uniqueResult();
		s.close();
		return count >= 1 ? true : false;
	}

	public Employee getValidEmpByAuth(Employee employee) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee e where e.loginName=:eName and e.password=:ePass");
		q.setParameter("eName", employee.getLoginName());
		q.setParameter("ePass", employee.getPassword());
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	}

	public Employee searchByName(String name) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee e where loginName=:name");
		q.setParameter("name", name);
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	}

	public Employee getEmpById(int Myid) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee e where e.id=:myid");
		q.setParameter("myid", Myid);
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
	}

	public List<Employee> getAllEmps(int id) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee e where id!=:id");
		q.setParameter("id", id);
		List<Employee> list = (List<Employee>) q.list();
		session.close();
		return list;
	}
	
//	public List<Employee> getAllEmpsExectLogin(int Myid){
//		Session session = sessionFactory.openSession();
//		Query q = session.createQuery("from Employee e where e.id !=:Myid");
//		q.setParameter("Myid", Myid);
//		List<Employee> list = q.list();
//		session.close();
//		return list;
//	}

//	 public int deleteEmpById(int id) {
//		 Session session = sessionFactory.openSession();
//		
//		 Transaction txn = session.beginTransaction();
//		 txn.begin();
//		 Query q = session.createQuery("delete Employee where id = :id");
//		 q.setParameter("id", id);
//		 int row=q.executeUpdate();
//		 txn.commit();
//		 
//		 session.close();
//		return row; 
//	 }
//	 
//	 

	public boolean deleteEmployee(final Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();
		session.delete(employee);
		transaction.commit();
		session.close();
		return true;
	}
	
	public void deleteEmployeeDirect(int id) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete Employee e where e.id=:id");
		q.setParameter("id", id);
		q.executeUpdate();
		session.close();
		}

	public void updateEmployee(final Employee newEmpDetails) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();
		transaction.begin();

		Employee empFromDB = getEmpById(newEmpDetails.getId());
		copyEmp(newEmpDetails, empFromDB);

		session.merge(empFromDB);
		transaction.commit();
		session.close();
	}

	private void copyEmp(Employee source, Employee target) {
		if (StringUtils.isNotEmpty(source.getName())) {
			target.setName(source.getName());
		}
		if (StringUtils.isNotEmpty(source.getlName())) {
			target.setlName(source.getlName());
		}
		if (StringUtils.isNotEmpty(source.getEmail())) {
			target.setEmail(source.getEmail());
		}
		target.setAge(source.getAge());
		target.setSalary(source.getSalary());
		target.setUserType(source.getUserType());
	}

	public void changePass(int id, String password) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Employee e set e.password=:pwd where e.id=:id");
		q.setParameter("id", id);
		q.setParameter("pwd", password);
		q.executeUpdate();
		session.close();
	}
	
	public void updateAttempts(String loginName,int count) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Employee e set e.attempts=:cnt where e.loginName=:loginName");
		q.setParameter("cnt", count);
		q.setParameter("loginName", loginName);
		q.executeUpdate();
		session.close();
	}

	public Employee getEmpByLoginName(String loginName) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Employee e where e.loginName=:loginName");
		q.setParameter("loginName", loginName);
		Employee validEmp = (Employee) q.uniqueResult();
		session.close();
		return validEmp;
		
	}
	
	public void updatestatus(int id,int status) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Employee e set e.status=:stat where e.id=:id");
		q.setParameter("stat", status);
		q.setParameter("id", id);
		q.executeUpdate();
		session.close();
	}
	



}
