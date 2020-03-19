package challengesms;

public class IntermediatePlusStrategy extends IntermediateStrategy {
	private static final double _MULTIPLIER = 3;

	public double getCreditLimit(double reasonableAmount) {
		return reasonableAmount*_MULTIPLIER;
	}

}
