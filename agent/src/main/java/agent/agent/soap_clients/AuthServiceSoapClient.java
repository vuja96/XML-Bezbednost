package agent.agent.soap_clients;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import agent.agent.model.GetAgentRequest;
import agent.agent.model.GetAgentResponse;

public class AuthServiceSoapClient extends WebServiceGatewaySupport{

	private static final String SERVICE_URI = "http://localhost:8762/auth/soap";
	
	public GetAgentResponse getAgentRequest() {
		GetAgentRequest request = new GetAgentRequest();
		GetAgentResponse response = (GetAgentResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_URI, request, new SoapActionCallback("/mySoapAction"));
	
		return response;
	}
}
