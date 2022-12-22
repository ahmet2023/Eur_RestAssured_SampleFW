package com.visa.eur.pojos;

import lombok.Data;

@Data //this will add getter/setters for each variable. Lombok Library (@Setter, @Getter)
public class PojoSample {

    /**
     * Response Sample:
     {
        "id" : 1
        "name" : "austin"
        "city" : "new york"
     }
     */
    private int id;
    private String name;
    private String city;
}
