package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Order implements Serializable {

    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("items")
    private List<String> items;
    @JsonProperty("price")
    private double price;
    @JsonProperty("user")
    private String user;
    @JsonProperty("email")
    private String email;

}
