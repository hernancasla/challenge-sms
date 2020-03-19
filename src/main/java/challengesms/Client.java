package challengesms;

import java.util.Date;

public abstract class Client {
	private String bussinesName;
	private String CUIT;
	private Date dateOfEntry;
	private double amount;
	private CriterionStrategy criterionStrategy;
	
	abstract int getEmployeesNumber();
	
	public String getBussinesName() {
		return bussinesName;
	}
	public void setBussinesName(String bussinesName) {
		this.bussinesName = bussinesName;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public Date getDateOfEntry() {
		return dateOfEntry;
	}
	public void setDateOfEntry(Date dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CriterionStrategy getCriterionStrategy() {
		return criterionStrategy;
	}
	public void setCriterionStrategy(CriterionStrategy criterionStrategy) {
		this.criterionStrategy = criterionStrategy;
	}
	
		
}
