package com.eureka.auth.eurekaauth.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean messageDispatcherServlete(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/soap/*");
		
	}
	
	@Bean
	public XsdSchema mySchema() {
		return new SimpleXsdSchema(new ClassPathResource("XMLSchema1.xsd"));
	}
	
	@Bean
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema mySchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setSchema(mySchema);
		definition.setLocationUri("/soap");
		definition.setPortTypeName("AuthServicePort");
		definition.setTransportUri("XMLSchema1.xsd");
		return definition;
	}
}

