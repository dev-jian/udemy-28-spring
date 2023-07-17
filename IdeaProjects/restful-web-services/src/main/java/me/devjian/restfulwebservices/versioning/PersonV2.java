package me.devjian.restfulwebservices.versioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class PersonV2 {

    @JsonProperty(value = "first")
    private String firstName;

    @JsonProperty(value = "last")
    private String lastName;
}
