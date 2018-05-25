package testjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class ScheduleUtility {

	public static final String read(File fileName) throws IOException {
		String line = null;
		StringBuffer sb = new StringBuffer();
		FileReader fileReader = new FileReader(fileName);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line + "\n");
		}
		bufferedReader.close();
		return sb.toString();
	}

	public static void main(String[] args) throws JsonProcessingException {
		sysoutSchema();
	}

	private static final void sysoutSchema() throws JsonMappingException, JsonProcessingException {
		final ObjectMapper MAPPER = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
		JsonSchema jsonSchema = generator.generateSchema(Schedule.class);
		System.out.println(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
	}

	public static final Schedule parseJsonFile(final File inputJsonFile) throws IOException {
		String fileContent = read(inputJsonFile);
		return parseJsonString(fileContent);
	}

	public static final Schedule parseJsonString(final String inputJsonString) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Schedule readValue = mapper.readValue(inputJsonString, Schedule.class);
		return readValue;
	}

	public static final String unparseSchedule(final Schedule schedule) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(schedule);
		return writeValueAsString;
	}
}
