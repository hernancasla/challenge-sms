package challengesms;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ConservativeTest {

	double reasonableAmount;
	Person personCeballos;
	Company companySMS;
	
	@Before
	public void init() {
		personCeballos = new Person();
		personCeballos.setBussinesName("CEBALLOS  OSVALDO");
		personCeballos.setCUIT("203938744733");
		personCeballos.setDateOfEntry(new Date());
		
		companySMS = new Company();
		companySMS.setAmount(100000);
		companySMS.setBussinesName("GRUPO SMS");
		companySMS.setCUIT("2055533");
		companySMS.setDateOfEntry(new Date());
		
		reasonableAmount = 100000;
	}
	
	@Test
	public void testConservativePerson() {
		personCeballos.setAmount(200000);

		CriterionStrategy criterion = CriterionStrategyFactory.BuildConservativeStrategy();
		personCeballos.setCriterionStrategy(criterion);
		assertTrue(personCeballos.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount*0.5);
	}
	
	@Test
	public void testConservativeCompany() {
		CriterionStrategy criterion = CriterionStrategyFactory.BuildConservativeStrategy();
		companySMS.setCriterionStrategy(criterion);
		assertTrue(companySMS.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount*0.5);
	}

}
