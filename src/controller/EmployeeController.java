package controller;

import javax.faces.bean.ManagedBean;

import dao.EmployeeDao;
import model.EmployeeBean;

@ManagedBean
public class EmployeeController {
	
	private EmployeeBean employee = new EmployeeBean();
	
	public EmployeeBean getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}
	
	public void cadEmployee() {
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.cadEmployee(employee);
	}
}
