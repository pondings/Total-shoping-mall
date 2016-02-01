package com.tsm.project.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class ObjectMapperFactory {
	private static ObjectMapper objectMapper;

	static {
		Hibernate4Module hibernate4Module = new Hibernate4Module();
		// Registering Hibernate4Module to support lazy objects
		objectMapper = new ObjectMapper().registerModule(hibernate4Module);
	}

	public static ObjectMapper create() {
		return objectMapper;
	}
}
