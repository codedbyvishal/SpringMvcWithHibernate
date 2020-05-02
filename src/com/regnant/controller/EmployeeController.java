package com.regnant.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.regnant.dto.Employee;
import com.regnant.util.UserException;

@Controller
public class EmployeeController {

	private static final String MSG = "msg";

	private static final String EMP = "emp";

	private static final String COMMAND = "command";

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/register")
	public ModelAndView showAddEmp() {
		Employee employee = new Employee();
//			employee.setAge(21);
//			employee.setEmail("example@gmail.com");
//			employee.setName("Vishal");
		return new ModelAndView("register", "command", employee);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView addEmp(@ModelAttribute("employee") Employee employee, BindingResult result) {
		employee.setDate(new Date());
		employee.setAttempts(0);
		String loginname = employee.getLoginName();
		employee.setStatus(1);
		employee.setCreatedBy(loginname);
		try {
			employeeService.addEmployee(employee);
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("register", "command", employee);
			modelAndView.addObject("msg", msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("login", "emp", employee);
		model.addObject("msg", "Employee Created!");
		return model;
	}

//	@RequestMapping("/login")
//	public String login() throws Exception {
//		return "login";
//	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(@ModelAttribute("command") Employee employee, BindingResult result, HttpSession session) {
//		Employee validUser = employeeService.getValidEmpByAuth(employee);
//		if (validUser != null) {
//			session.setAttribute("myId", validUser.getId()); // add emp id to the session
//			session.setAttribute("loginName", validUser.getLoginName());
//			session.setAttribute("password", validUser.getPassword());
//			session.setAttribute("usertype", validUser.getUserType());
//			session.setAttribute("name", validUser.getName() + "," + validUser.getlName());
//			session.setAttribute("status", validUser.getStatus());
//			if (validUser.getUserType().equalsIgnoreCase("user")) {
//				ModelAndView modelAndView = new ModelAndView("showforUser", "emp", validUser);
//				return modelAndView;
//			} else {
//				ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
//				return modelAndView;
//			}
//		}
//		return new ModelAndView("login", "msg", "Invalid Login..");
//	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(@ModelAttribute(COMMAND) Employee employee, BindingResult result, HttpSession session) {
//		Employee validUser = employeeService.getValidEmpByAuth(employee);
//		if (validUser != null) {
//			session.setAttribute("myId", validUser.getId()); // add emp id to the session
//			session.setAttribute("loginName", validUser.getLoginName());
//			session.setAttribute("password", validUser.getPassword());
//			session.setAttribute("name", (validUser.getName() + "," + validUser.getlName()));
//			session.setAttribute("usertype", validUser.getUserType());
//			if(validUser.getUserType().equalsIgnoreCase("user")) {
//				ModelAndView modelAndView = new ModelAndView("showForUser","emp",validUser);
//			}
//			else {
//				ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
//				return modelAndView;
//			}
//					}
//		return new ModelAndView("login", "msg", "Invalid Login..");
//	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public ModelAndView profile(@RequestParam("loginName") String name) {
		Employee validUser = employeeService.getEmpByName(name);
		if (validUser != null) {
			ModelAndView modelAndView = new ModelAndView("profile", "emp", validUser);
			return modelAndView;
		}
		return new ModelAndView("profile", "msg", validUser);
	}

	@RequestMapping(value = "/user_profile", method = RequestMethod.GET)
	public ModelAndView profileForUser(@RequestParam("loginName") String name) {
		Employee valiEmployee = employeeService.getEmpByName(name);
		if (valiEmployee != null) {
			ModelAndView modelAndView = new ModelAndView("userProfile", EMP, valiEmployee);
			return modelAndView;
		}
		return new ModelAndView("userProfile", "msg", valiEmployee);
	}

//	public ModelAndView showChangePassword()

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("loginName");
		session.removeAttribute("name");
		session.invalidate();
		ModelAndView response = new ModelAndView("login");
		response.addObject("msg", "Logout successfull");
		return response;
	}

	@RequestMapping("/addEmp")
	public ModelAndView showLoginEmpToOthers() {
		Employee employee = new Employee();
		return new ModelAndView("showAddEmp", "command", employee);
	}

	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public ModelAndView addEmp1(@ModelAttribute("employee") Employee employee, BindingResult result,
			HttpSession session) {
		employee.setDate(new Date());
		employee.setStatus(1);
		String name = (String) session.getAttribute("loginName");
		employee.setCreatedBy(name);
		try {
			employeeService.addEmployee(employee);
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showAddEmp", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
		ModelAndView model = new ModelAndView("showEmp", EMP, employee);
		model.addObject(MSG, "Employee Created!");
		return model;
	}

	@RequestMapping("/readUser")
	public String showGetEmp() throws Exception {
		return "readUser";
	}

	@RequestMapping(value = "/readUser", method = RequestMethod.POST)
	public ModelAndView getEmpById(@RequestParam("id") int empId) throws Exception {
		Employee employee = employeeService.getEmpById(empId);
		ModelAndView modelAndView = new ModelAndView("readUser");
		if (employee == null) {
			modelAndView.addObject(MSG, "Employee Not found");
		} else {
			modelAndView.addObject(EMP, employee);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/user_readUser")
	public String showUserGetEmp() throws Exception {
		return "showreaduser";
	}

	@RequestMapping(value = "userreadUser", method = RequestMethod.POST)
	public ModelAndView getEmpsById(@RequestParam("id") int empId) throws Exception {
		Employee employee = employeeService.getEmpById(empId);
		ModelAndView modelAndView = new ModelAndView("showreaduser");
		if (employee == null) {
			modelAndView.addObject(MSG, "Employee Not Found");
		} else {
			modelAndView.addObject(EMP, employee);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/getAllEmps")
	public ModelAndView getAllEmp(HttpSession session) {
		Integer id = (Integer) session.getAttribute("myId");
		List<Employee> list = employeeService.getAllEmp(id);
//		System.out.println(list);

		ModelAndView modelAndView = new ModelAndView("showAllUser");

		modelAndView.addObject("list", list);

		return modelAndView;

	}

	@RequestMapping(value = "/user_getAllEmps")
	public ModelAndView getAllEmpsUser(HttpSession session) {
		Integer id = (Integer) session.getAttribute("myId");
		List<Employee> list = employeeService.getAllEmp(id);

		ModelAndView modelAndView = new ModelAndView("userShowAll");

		modelAndView.addObject("list", list);
		return modelAndView;
	}

//	@RequestMapping(value = "/getAllEmps")
//	public ModelAndView getAllEmpsExcept(@RequestParam("myId") int userId,HttpSession session) {
//		Integer id = (Integer) session.getAttribute("myId");
//		List<Employee> list = employeeService.getEmpExpectLoggedin(id);
//		ModelAndView modelAndView = new ModelAndView("showAllUser");
//		modelAndView.addObject("list",list);
//		return modelAndView;
//		
//	}

	@RequestMapping("/deleteEmp")
	public String showDeleteEmp() throws Exception {
		return "deleteUser";
	}

//	@RequestMapping(value="/deleteUser")
//	 public ModelAndView deleteEmpById(@RequestParam("id") int empId) throws Exception{
//		int row  = employeeService.deleteEmp(empId);
//		 ModelAndView modelAndView = new ModelAndView("deleteUser");
//		 if(row== 0) {
//			 modelAndView.addObject("msg","Employee does not exist");
//			 return modelAndView;
//		 }
//		 else {
//			 modelAndView.addObject("msg",row);
//			 modelAndView.addObject("msg1","User SuccessFully deleted");
//			 return modelAndView;
//		 }
//	 }

	@RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
	public ModelAndView deleteEmp(@RequestParam("id") int userId, HttpSession session) throws Exception {
		Integer myId = (Integer) session.getAttribute("myId");
		if (myId.intValue() == userId) {
			return new ModelAndView("deleteUser", "messageInfo", "You cannot delete your Profile..");
		}
		Employee emp = new Employee();
		emp.setId(userId);
		boolean status = employeeService.deleteEmployee(emp);
		if (!status) {
			return new ModelAndView("deleteUser", "messageInfo", "Employee Id Not found.");
		}
		return new ModelAndView("deleteUser", "messageInfo", "Deleted successfully");
	}

	@RequestMapping("/editEmp")
	public ModelAndView showEditEmp(@RequestParam("empId") int empId) {
		Employee emp = employeeService.getEmpById(empId);
		return new ModelAndView("showEditEmp", COMMAND, emp);
	}

	@RequestMapping(value = "/editEmp", method = RequestMethod.POST)
	public ModelAndView updateEmp(@ModelAttribute("employee") Employee employee, BindingResult result) {
		
		try {
			employeeService.updateEmployee(employee);
			ModelAndView modelAndView = new ModelAndView("showEmp", "emp", employee);
			modelAndView.addObject(MSG, "update successful!!");
			return modelAndView;
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showEditEmp", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
	}

	// Link for Edit Profile (admin)
	@RequestMapping("/editProfile")
	public ModelAndView showEditEmplink(@RequestParam("empId") int empId) {
		Employee emp = employeeService.getEmpById(empId);
		return new ModelAndView("showEditEmp", "command", emp);
	}

	// Redirecting The Edit
	@RequestMapping(value = "/editEmps", method = RequestMethod.POST)
	public ModelAndView updateEmpLink(@ModelAttribute("employee") Employee employee, BindingResult result) {
		try {
			employeeService.updateEmployee(employee);
			ModelAndView modelAndView = new ModelAndView("showEmp", "emp", employee);
			modelAndView.addObject(MSG, "update successful!!");
			return modelAndView;
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showEditEmp", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
	}

	// Showing User Edit profile Method
	@RequestMapping(value = "/user_editEmp")
	public ModelAndView showUpdateLink(@RequestParam("empId") int empId) {
		Employee emp = employeeService.getEmpById(empId);
		return new ModelAndView("showUserEdit","command", emp);
	}

	// Requesting User Edit Profile Method
	@RequestMapping(value = "/user_editEmp", method = RequestMethod.POST)
	public ModelAndView updateEmpViaLink(@ModelAttribute("employee") Employee employee, BindingResult results) {
		try {
			employeeService.updateEmployee(employee);
			ModelAndView modelAndView = new ModelAndView("userProfile", "emp", employee);
			modelAndView.addObject(MSG, "update successful!!");
			return modelAndView;
		} catch (UserException e) {
			String msg = e.getMessage();
			ModelAndView modelAndView = new ModelAndView("showUserEdit", COMMAND, employee);
			modelAndView.addObject(MSG, msg);
			return modelAndView;
		}
	}

//	@RequestMapping(value = "/deleteEmps", method = RequestMethod.POST)
//	public ModelAndView deleteEmp(@ModelAttribute("Myid") Employee emp.set, BindingResult result,HttpSession session) {
//			session.setAttribute("Myid", employee.getId());
//			employeeService.deleteEmployee(employee.getId());
//	}
//	
	@RequestMapping(value = "/deleteEmps")
	public ModelAndView deleteEmployeeViaLink(@RequestParam("empId") int userId, HttpSession session) {

		employeeService.deleteEmployeeLink(userId);
		Integer myId = (Integer) session.getAttribute("myId");
		List<Employee> list = employeeService.getAllEmp(myId);
		ModelAndView modelAndView = new ModelAndView("showAllUser");
		modelAndView.addObject("list", list);
		return modelAndView;

	}

	
	// Admin Password Edit
	@RequestMapping(value = "editPassword")
	public ModelAndView showEditpass() {
		return new ModelAndView("changePassword");
	}

	// Admin Password Edit
	@RequestMapping(value = "/editPassw", method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam("oldPassword") String oldPass,
			@RequestParam("password") String newPass, @RequestParam("repassword") String copyPass,
			HttpSession session) {

		String checkPass = (String) session.getAttribute("password");

		if (checkPass.equals(oldPass)) {

			if (newPass.equals(copyPass)) {
				Integer id = (Integer) session.getAttribute("myId");
				employeeService.editPwdById(id, newPass);
				String msg = "Password changed.. login again ";
				ModelAndView modelandview = new ModelAndView("login");
				modelandview.addObject("msg", msg);
				return modelandview;
			} else {
				String msg = "Passwords not matched.. ";
				ModelAndView modelandview = new ModelAndView("changePassword");
				modelandview.addObject("msg", msg);
				return modelandview;
			}

		} else {
			String msg = "Password not matched with old password.. try again ";
			ModelAndView modelandview = new ModelAndView("changePassword");
			modelandview.addObject("msg", msg);
			return modelandview;
		}

	}

	// User Or Other Profile Password Change
	@RequestMapping(value = "user_editPassword")
	public ModelAndView showUserEditPassowrd() {
		return new ModelAndView("userChangePassword");
	}

	// uSer Or Other Profile Password Reset
	@RequestMapping(value = "/usereditPassw", method = RequestMethod.POST)
	public ModelAndView userchangePassword(@RequestParam("oldPassword") String oldPass,
			@RequestParam("password") String newPass, @RequestParam("repassword") String copyPass,
			HttpSession session) {

		String checkPass = (String) session.getAttribute("password");

		if (checkPass.equals(oldPass)) {

			if (newPass.equals(copyPass)) {
				Integer id = (Integer) session.getAttribute("myId");
				employeeService.editPwdById(id, newPass);
				String msg = "Password changed.. login again ";
				ModelAndView modelandview = new ModelAndView("login");
				modelandview.addObject("msg", msg);
				return modelandview;
			} else {
				String msg = "Passwords not matched.. ";
				ModelAndView modelandview = new ModelAndView("userChangePassword");
				modelandview.addObject("msg", msg);
				return modelandview;
			}

		} else {
			
			String msg = "Password not matched with old password.. try again ";
			ModelAndView modelandview = new ModelAndView("userChangePassword");
			modelandview.addObject("msg", msg);
			return modelandview;
		}

	}

}
