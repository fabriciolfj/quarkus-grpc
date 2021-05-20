package com.github.fabriciolfj.service;

import com.github.fabriciolfj.mapper.PersonMapper;
import com.github.fabriciolfj.proto.person.MutinyPersonServiceGrpc.PersonServiceImplBase;
import com.github.fabriciolfj.proto.person.Person;
import com.github.fabriciolfj.proto.person.PersonRequest;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PersonService extends PersonServiceImplBase {

    @Inject
    private PersonMapper mapper;

    @Override
    public Uni<Person> generatedDoc(PersonRequest request) {
        return Uni.createFrom()
                .item(() -> mapper.toModel(request));
    }
}
