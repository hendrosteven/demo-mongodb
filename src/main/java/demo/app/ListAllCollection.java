package demo.app;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ListAllCollection {
	public static void main(String[] args) {
		try {
			
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase database = mongoClient.getDatabase("testdb");
			
			for(String collection : database.listCollectionNames()) {
				System.out.println(collection);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
