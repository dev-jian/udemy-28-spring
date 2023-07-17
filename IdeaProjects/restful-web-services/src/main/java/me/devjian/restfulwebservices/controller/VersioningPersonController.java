package me.devjian.restfulwebservices.controller;

import me.devjian.restfulwebservices.versioning.PersonV1;
import me.devjian.restfulwebservices.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeader() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeader() {
        return new PersonV2("Bob", "Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/devjian.app-v1+json")
    public PersonV1 getFirstVersionOfPersonMediaType() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept", produces = "application/devjian.app-v2+json")
    public PersonV2 getSecondVersionOfPersonMediaType() {
        return new PersonV2("Bob", "Charlie");
    }
}
