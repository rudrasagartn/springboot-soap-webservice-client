package com.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.soapclient.generated.Add;
import com.springboot.soapclient.generated.AddResponse;
import com.springboot.soapclient.generated.Subtract;
import com.springboot.soapclient.generated.SubtractResponse;
import com.springboot.ws.connector.SoapWebServiceConnector;

@SpringBootApplication
public class SpringbootSoapWebserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSoapWebserviceClientApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SoapWebServiceConnector soapConnector) {
		return args -> {
			Add request = new Add();
			request.setIntA(5);
			request.setIntB(6);
			AddResponse response = (AddResponse) soapConnector
					.callAddService("http://www.dneonline.com/calculator.asmx", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Addition Result : " + response.getAddResult());

		};
	}

	@Bean
	CommandLineRunner lookup2(SoapWebServiceConnector soapConnector) {
		return args -> {

			Subtract sub = new Subtract();
			sub.setIntA(5);
			sub.setIntB(2);
			SubtractResponse response2 = soapConnector.callSubtractService("http://www.dneonline.com/calculator.asmx",
					sub);
			System.out.println("Subtract Result>" + response2.getSubtractResult());
		};
	}

}
