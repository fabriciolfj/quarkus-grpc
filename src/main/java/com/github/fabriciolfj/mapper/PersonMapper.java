package com.github.fabriciolfj.mapper;

import javax.enterprise.context.ApplicationScoped;
import com.github.fabriciolfj.proto.person.Person;
import com.github.fabriciolfj.proto.person.PersonRequest;

import java.util.Random;

@ApplicationScoped
public class PersonMapper {

    private static final Random RANDOM = new Random();

    public Person toModel(PersonRequest request) {
        return Person.newBuilder()
                .setName(request.getName())
                .setDocument(RANDOM.nextInt())
                .build();
    }
}
