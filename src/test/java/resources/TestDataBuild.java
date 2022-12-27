package resources;

import pojo.EmployeeDataSet;

public class TestDataBuild {
	

	public EmployeeDataSet createEmployeePayload(String name,String salary,String age) {
		EmployeeDataSet sed = new EmployeeDataSet();
		
		
		sed.setName(name);
		sed.setSalary(salary);
		sed.setAge(age);
		
		return sed;
		
	}

}
