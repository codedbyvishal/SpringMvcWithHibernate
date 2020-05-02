package com.regnant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.regnant.dto.Employee;
import com.regnant.util.ErrorEnum;
import com.regnant.util.UserException;

@Service("employeeService")
@Transactional
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public void addEmployee(Employee employee) throws UserException {
		if (employeeDao.isEmployeeExists(employee.getLoginName()))
			throw new UserException(ErrorEnum.ERRO4.getErrorCode(), ErrorEnum.ERRO4.getMsg());
		if (employeeDao.isEmpEmailExist(employee.getEmail()))
			throw new UserException(ErrorEnum.ERRO3.getErrorCode(), ErrorEnum.ERRO3.getMsg());
			employeeDao.saveEmployee(employee);
			}
		

	

//	 public void emailValidate(Employee employee) throws UserException {
//		 if(employeeDao.isEmpEmailExist(employee.getEmail()))
//			 throw new UserException(ErrorEnum.ERRO3.getErrorCode(), ErrorEnum.ERRO3.getMsg());
//		 employeeDao.saveEmployee(employee);
//	 }

	public Employee getValidEmpByAuth(Employee employee) {
		return employeeDao.getValidEmpByAuth(employee);
	}

	public Employee getEmpByName(String name) {
		return employeeDao.searchByName(name);
	}

	public Employee getEmpById(int id) {
		return employeeDao.getEmpById(id);
	}

	public List<Employee> getAllEmp(int id) {
		return employeeDao.getAllEmps(id);

	}



	public boolean deleteEmployee(Employee employee) {
		// check if the employee exists
		Employee empById = employeeDao.getEmpById(employee.getId());

		// if the employee doesnt exists then dont make db call, just return false;
		if (empById == null) {
			return false;
		}
		return employeeDao.deleteEmployee(employee);
	}

	public void updateEmployee(Employee employee) throws UserException {
		employeeDao.updateEmployee(employee);
	}

	public void editPwdById(int id, String password) {
		employeeDao.changePass(id, password);

	}
	
	public void deleteEmployeeLink(int Myid) {
		employeeDao.deleteEmployeeDirect(Myid);
	}
	
	public void changeAttempts(String loginName,int count) {
		employeeDao.updateAttempts(loginName, count);
	}




	public Employee getEmpByLoginName(String LoginName) {
		return	employeeDao.getEmpByLoginName(LoginName);
		
	}
	
	public void changeUserStatus(int id, int status) {
		 employeeDao.updatestatus(id, status);
	}
	
//	public List<Employee> getEmpExpectLoggedin(int id) {
//		return employeeDao.getAllEmpsExectLogin(id);
//	}

}
