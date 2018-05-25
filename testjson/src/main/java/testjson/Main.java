package testjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

public class Main {

	
	public static void main(String[] args) throws JsonProcessingException {
		final ObjectMapper MAPPER = new ObjectMapper();
        JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
		JsonSchema jsonSchema = generator.generateSchema(Schedule.class);
		
		System.out.println(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(jsonSchema));
	}
}
