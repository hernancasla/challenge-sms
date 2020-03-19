package challengesms;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IntermediateTest {
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
	public void testIntermediatePerson() {
		personCeballos.setAmount(200000);

		CriterionStrategy criterion = CriterionStrategyFactory.BuildIntermediateStrategy(personCeballos);
		personCeballos.setCriterionStrategy(criterion);
		assertTrue(personCeballos.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount*2);
	}
	@Test
	public void testIntermediatePlusCompany() {
		List<Person> listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(50);
		companySMS.setEmployees(listMock);
		
		CriterionStrategy criterion = CriterionStrategyFactory.BuildIntermediateStrategy(companySMS);
		companySMS.setCriterionStrategy(criterion);
		assertTrue(companySMS.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount*3);
	}

}
