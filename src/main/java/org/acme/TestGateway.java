package org.acme;

import java.util.List;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestQuery;

@RegisterRestClient(baseUri = "http://localhost:8080")
public interface TestGateway {

    @GET
    @Path("/exampleAPI")
    public Uni<String> doRequest(
        @RestQuery("status") List<EnumField> statuses
    );
}
