package com.beehyv.algebra_services;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import javax.script.ScriptException;

@SpringBootTest
class AlgebraServicesApplicationTests {

	@Autowired
	private AlgebraServicesService algebraServicesService;
	
	@Test
	public void calculate_test() throws Exception {
		assertEquals(algebraServicesService.calculateEquation("1","5*(3+(1-5))/5"),-1);
	}
	
	@Test
	public void userchoice_test() throws Exception {
		algebraServicesService.calculateEquation("2","3*(2-5)");
		algebraServicesService.calculateEquation("2","2*(4+5)");
		algebraServicesService.calculateEquation("2","3*5");
		assertEquals(algebraServicesService.getUserChoice("2"),'*');
	}
}