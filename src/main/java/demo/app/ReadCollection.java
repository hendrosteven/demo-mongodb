package demo.app;

import java.util.Collection;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class ReadCollection {

	public static void main(String[] args) {
		try {
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase database = mongoClient.getDatabase("testdb");
			MongoCollection<Document> collections = database.getCollection("cars");

			MongoCursor<Document> cursor = collections.find().iterator();

			while (cursor.hasNext()) {
				Collection<Object> data = cursor.next().values();
				Object[] doc = data.toArray();
				System.out.println(doc[1] + " " + doc[2]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
