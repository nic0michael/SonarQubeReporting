package za.co.nico.poc.business.logic.processors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import za.co.nico.poc.dtos.GetProjectsResponse;
import za.co.nico.poc.services.SonarServiceImpl;



@RunWith(SpringRunner.class)
public class BusinessLogicProcessorTest {
	BusinessLogicProcessor processor=null;
	
	@Test
	public void sendToMessageQueuePassingTest() {
		SonarServiceImpl service =new SonarServiceImpl();
		if(processor==null) {
			processor=new BusinessLogicProcessor(service);
		}
		GetProjectsResponse response = processor.getProjectsList();
		assertThat(response, is(notNullValue()));
	}

}
