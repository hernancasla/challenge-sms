package challengesms;

public class ConservativeStrategy implements CriterionStrategy {
	private static final double _MULTIPLIER = 0.5;

	public double getCreditLimit(double reasonableAmount) {
		return reasonableAmount*_MULTIPLIER;
	}

}
