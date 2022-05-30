package com.gdelgado.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Field("ranking")
    private int ranking;
    @Field("comments")
    private String comments;
}


    //public void setRanking(int ranking) {
      //  if (ranking <= 10) {
        //    this.ranking = ranking;
       // }else throw new java.lang.Error("Error, user inserted raking more than 10");
    //}
