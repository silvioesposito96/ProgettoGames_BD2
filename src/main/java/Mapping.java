import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.lang.Double;


public class Mapping {
    public static void main (String[] arg) throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("src/vgsales.csv"));
        String row;
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false"
                )
        );
        MongoDatabase database = mongoClient.getDatabase("Project_Games");
        MongoCollection<Document> y = database.getCollection("Games");
        List<Document> toInsert = new ArrayList();
        boolean i = false;

        while ((row = csvReader.readLine()) != null) {
            if(!i) {
                i= true;
                continue;
            }


            String[] data = row.split(",");




            Document document1 = new Document();
            document1.put("Rank", data[0]);
            document1.put("Name", data[1]);
            document1.put("Platform", data[2]);
            document1.put("Year", data[3]);
            document1.put("Genre", data[4]);
            document1.put("Publisher", data[5]);
            document1.put("NA_Sales", data[6]);
            document1.put("EU_Sales",data[7] );
            document1.put("JP_Sales", data[8]);
            document1.put("Other_Sales", data[9]);
            document1.put("Global_Sales", data[10]);

            toInsert.add(document1);
        }
        y.insertMany(toInsert);
        csvReader.close();
        System.out.println("succ");
        y.createIndex(Indexes.ascending("Rank"));

    }
}
