package challengesms;

public class RiskyStrategy implements CriterionStrategy {
	private static final double _MULTIPLIER = 1;

	public double getCreditLimit(double reasonableAmount) {
		// TODO Auto-generated method stub
		return reasonableAmount*_MULTIPLIER;
	}

}
