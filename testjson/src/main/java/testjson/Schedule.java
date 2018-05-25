package testjson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

class ScheduleEntry {
	@JsonProperty(required = true)
	 String actorName;

	@JsonProperty(required = true)
	 int singleRateInstanceNumber;

	@JsonProperty(required = true)
	 int start;

	@JsonProperty(required = true)
	 int end;

	@JsonProperty(required = true)
	 String processingElementName;

	@JsonProperty(required = false)
	 int graphIteration;

}

public class Schedule {

	@JsonProperty(required = true)
	List<ScheduleEntry> scheduleEntries;
}
