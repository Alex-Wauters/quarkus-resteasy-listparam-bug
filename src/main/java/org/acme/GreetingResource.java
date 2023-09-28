package org.acme;

import java.util.List;

import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/")
public class GreetingResource {

    private final TestGateway testGateway;

    public GreetingResource(@RestClient TestGateway testGateway) {this.testGateway = testGateway;}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    @Path("/hello")
    public String hello() {
        return testGateway.doRequest(List.of(EnumField.IN_PROGRESS, EnumField.PUBLISHED)).await().indefinitely();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Blocking
    @Path("/exampleAPI")
    public String exampleAPI() {
        return "Received request - see console logs for params ";
    }
}
