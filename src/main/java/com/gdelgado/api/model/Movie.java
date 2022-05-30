package com.gdelgado.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Movies")
public class Movie {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field("name")
    private String name;
    @Max(value = 10, message = "Ranking should not be more than 10")
    @Field("ranking")
    private int ranking;
    @Field("comments")
    private String comments;
}
