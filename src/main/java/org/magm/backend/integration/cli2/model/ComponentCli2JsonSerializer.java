package org.magm.backend.integration.cli2.model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class ComponentCli2JsonSerializer extends StdSerializer<ComponentCli2> {

	private static final long serialVersionUID = -3706327488880784297L;

	public ComponentCli2JsonSerializer(Class<?> t, boolean dummy) {
		super(t, dummy);
	}

	@Override
	public void serialize(ComponentCli2 value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		gen.writeStartObject();                                  // {
		gen.writeNumberField("id", value.getId());               //    "id" : 123,
		gen.writeStringField("component", value.getComponent()); //    "component" : "componente 1"
		gen.writeEndObject();                                    // }
 
	}

}
