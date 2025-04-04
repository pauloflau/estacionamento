package com.jmp.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class SpringTimeZoneConfig { //classe para definir o meu timezone e locale default
	
	@PostConstruct //inicializa apos o construtor
	public void timeZoneConfig() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
}
