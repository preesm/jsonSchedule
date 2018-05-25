package testjson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonScheduleTest {

	
	@Test
	public void testParse() throws IOException {
		String filePath = "src/test/resources/testSchedule.json";
		
		ObjectMapper mapper = new ObjectMapper();
		Schedule readValue = mapper.readValue(new File(filePath), Schedule.class);
		
		System.out.println(readValue);
		System.out.println(readValue.scheduleEntries);
		System.out.println(readValue.scheduleEntries.get(0).actorName);
	}
	
	@Test
	public void testUnparse() throws JsonProcessingException {

		ScheduleEntry se1 = new ScheduleEntry();
		se1.actorName = "Read";
		se1.graphIteration = 0;
		se1.singleRateInstanceNumber = 0;
		se1.processingElementName = "Core0";
		se1.start = 0;
		se1.end = 10;

		ScheduleEntry se2 = new ScheduleEntry();
		se2.actorName = "Proess";
		se2.graphIteration = 0;
		se2.singleRateInstanceNumber = 0;
		se2.processingElementName = "HWCore1";
		se2.start = 10;
		se2.end = 50;
		
		ScheduleEntry se3 = new ScheduleEntry();
		se3.actorName = "Display";
		se3.graphIteration = 0;
		se3.singleRateInstanceNumber = 0;
		se3.processingElementName = "Core0";
		se3.start = 50;
		se3.end = 60;

		Schedule s = new Schedule();
		s.scheduleEntries = new ArrayList<ScheduleEntry>();
		s.scheduleEntries.add(se1);
		s.scheduleEntries.add(se2);
		s.scheduleEntries.add(se3);
		
		System.out.println(ScheduleUtility.unparseSchedule(s));
	}
}
