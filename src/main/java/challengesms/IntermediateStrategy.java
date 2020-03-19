package challengesms;

public class IntermediateStrategy implements CriterionStrategy {

	private static final double _MULTIPLIER = 2;

	public double getCreditLimit(double reasonableAmount) {
		// TODO Auto-generated method stub
		return reasonableAmount*_MULTIPLIER;
	}

}
