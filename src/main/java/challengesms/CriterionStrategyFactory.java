package challengesms;

public class CriterionStrategyFactory {
	public static final CriterionStrategy BuildIntermediateStrategy(Client client) {
		if(client.getEmployeesNumber()>=50)
			return new IntermediatePlusStrategy();
		else return new IntermediateStrategy();
	}
	public static final  CriterionStrategy BuildRiskyStrategy(Client client) throws InvalidCriterionException {
		Property property = new Property();
		if(client.getEmployeesNumber()>=10)
			return new RiskyStrategy();
		else if (client.getEmployeesNumber()==0 && client.getAmount()>=property.getDouble("amount"))
			return new RiskyStrategy();
		else throw new InvalidCriterionException("Is not possible to choose this criterion with the current configuration");

	}
	public static final  CriterionStrategy BuildConservativeStrategy() {
		return new ConservativeStrategy();
	}
}
