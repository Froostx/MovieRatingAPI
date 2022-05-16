package com.gdelgado.api;

import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

		MongoClient client = MongoClients.create("mongodb+srv://superAdmin:1234@cluster0.tqlj5.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");

		MongoDatabase db = client.getDatabase("moviesDB");

		MongoCollection col = db.getCollection("moviesCollection");

		//Insert documento en mongoDB
		//Document sampleDoc = new Document("id_", "1").append("name", "John Smith");

		//Delete--
		//col.deleteOne(new Document("id_", "1"));

		//insert --
		//col.insertOne(sampleDoc);

	}

}
