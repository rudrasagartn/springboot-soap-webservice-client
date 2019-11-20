package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.springboot.ws.connector.SoapWebServiceConnector;

@Configuration
public class SoapWSBeanConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.springboot.soapclient.generated");
		return marshaller;
	}

	@Bean
	public SoapWebServiceConnector soapConnector(Jaxb2Marshaller marshaller) {
		SoapWebServiceConnector client = new SoapWebServiceConnector();
		client.setDefaultUri("http://www.dneonline.com/calculator.asmx");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
