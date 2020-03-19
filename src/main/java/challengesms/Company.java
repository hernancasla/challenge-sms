package challengesms;

import java.util.List;

public class Company extends Client {
	private List<Person> employees;

	@Override
	int getEmployeesNumber() {
		if(employees == null)
			return 0;
		
		return employees.size();
	}

	public List<Person> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Person> employees) {
		this.employees = employees;
	}

}
