package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.dto.PersonResponse;
import com.github.fabriciolfj.proto.person.PersonRequest;
import com.github.fabriciolfj.proto.person.PersonServiceGrpc;
import io.quarkus.grpc.runtime.annotations.GrpcService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static java.util.Optional.ofNullable;


@Path("/person")
public class PersonController {

    @Inject
    @GrpcService("personProto")
    PersonServiceGrpc.PersonServiceBlockingStub client;

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public PersonResponse createDoc(@PathParam("name") String name) {
        return ofNullable(client.generatedDoc(PersonRequest.newBuilder()
                .setName(name)
                .build()))
                .map(p ->  new PersonResponse(p.getName(), p.getDocument()))
                .orElseGet(() -> new PersonResponse());
    }
}
