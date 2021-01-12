package eu.ensup.webservice;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest/*")
public class WebserviceApplication extends ResourceConfig
{
	public WebserviceApplication()
	{
		register(JacksonFeature.class);
		packages("eu.ensup.webservice");
	}
}