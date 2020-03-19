package challengesms;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RiskyTest {
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
	public void testRiskyPerson() {
		personCeballos.setAmount(200000);
		try {
			CriterionStrategy criterion = CriterionStrategyFactory.BuildRiskyStrategy(personCeballos);
			personCeballos.setCriterionStrategy(criterion);
			assertTrue(personCeballos.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount);
		} catch (InvalidCriterionException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
		
	}
	@Test
	public void testFailRiskyPerson() {
		personCeballos.setAmount(100000);
		try {
			CriterionStrategy criterion = CriterionStrategyFactory.BuildRiskyStrategy(personCeballos);
			personCeballos.setCriterionStrategy(criterion);
			fail("This test must fail");
		} catch (InvalidCriterionException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
		
	}
	@Test
	public void testRiskyCompany() {
		List<Person> listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(10);
		companySMS.setEmployees(listMock);
		
		try {
			CriterionStrategy criterion = CriterionStrategyFactory.BuildRiskyStrategy(companySMS);
			companySMS.setCriterionStrategy(criterion);
			assertTrue(companySMS.getCriterionStrategy().getCreditLimit(reasonableAmount )==reasonableAmount);
		} catch (InvalidCriterionException e) {
			// TODO Auto-generated catch block
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testFailRiskyCompany() {
		List<Person> listMock = Mockito.mock(List.class);
		Mockito.when(listMock.size()).thenReturn(9);
		companySMS.setEmployees(listMock);
		
		try {
			CriterionStrategy criterion = CriterionStrategyFactory.BuildRiskyStrategy(companySMS);
			companySMS.setCriterionStrategy(criterion);
			fail("This test must fail");
		} catch (InvalidCriterionException e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

}
