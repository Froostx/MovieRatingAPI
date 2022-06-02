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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Movies")
public class Movie {

    @NotEmpty(message = "Movie name may not be empty")
    @Id
    @Indexed(unique = true)
    @Field("name")
    private String name;

    @Min(value = 0, message = "Ranking must not be less than 0")
    @Max(value = 10, message = "Ranking must not be more than 10")
    @Field("ranking")
    private int ranking;

    @Field("comments")
    private String comments;
}
