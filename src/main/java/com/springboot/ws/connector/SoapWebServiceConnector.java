package com.springboot.ws.connector;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

import com.springboot.soapclient.generated.Add;
import com.springboot.soapclient.generated.AddResponse;
import com.springboot.soapclient.generated.Subtract;
import com.springboot.soapclient.generated.SubtractResponse;

public class SoapWebServiceConnector extends WebServiceGatewaySupport {

	public AddResponse callAddService(String url, Add request) {
		return (AddResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, webServiceMessage -> {
			((SoapMessage) webServiceMessage).setSoapAction("http://tempuri.org/Add");
		});
	}

	public SubtractResponse callSubtractService(String url, Subtract request) {
		return (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(url, request, webServiceMessage -> {
			((SoapMessage) webServiceMessage).setSoapAction("http://tempuri.org/Subtract");
		});
	}

}
