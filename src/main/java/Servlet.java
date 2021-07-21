import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Sorts;
import model.Game;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "ServletQuerys", value = "/ServletQuerys")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MongoClient mongoClient = new MongoClient(
                new MongoClientURI(
                        "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&ssl=false"
                )
        );
        MongoDatabase database = mongoClient.getDatabase("Project_Games");
        MongoCollection<Document> collection = database.getCollection("Games");
        String query = request.getParameter("query");
        String order = request.getParameter("Order");
        if(query.equals("one")) {
            String Platform = request.getParameter("Platform");
            FindIterable<Document> res = collection.find
                    (new Document("Platform",
                            new Document("$eq", Platform)))
                    .skip(50)
                    .limit(20);
            MongoCursor res1 = res.iterator();
            ArrayList<Game> ret = new ArrayList<>();
            while (res1.hasNext()) {
                Game g = new Game();
                Document curr = (Document) res1.next();

                g.setName(curr.getString("Name"));
                g.setGenre(curr.getString("Genre"));
                g.setRank(curr.getString("Rank"));
                g.setPlatform(curr.getString("Platform"));
                g.setPublisher(curr.getString("Publisher"));
                g.setYear(curr.getInteger("Year"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setEU_Sales(curr.getDouble("EU_Sales"));
                g.setJP_Sales(curr.getDouble("JP_Sales"));
                g.setOther_Sales(curr.getDouble("Other_Sales"));
                g.setGlobal_Sales(curr.getDouble("Global_Sales"));

                ret.add(g);
            }
            request.setAttribute("result", ret);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OneQuery.jsp");
            dispatcher.forward(request, response);

        }

        else if(query.equals("two")) {
            String Genre = request.getParameter("Genre");
            FindIterable<Document> res = collection.find
                    (new Document("Genre",
                            new Document("$eq", Genre)))
                    .skip(50)
                    .limit(20);
            MongoCursor res1 = res.iterator();
            ArrayList<Game> ret = new ArrayList<>();
            while (res1.hasNext()) {
                Game g = new Game();
                Document curr = (Document) res1.next();
                g.setRank(curr.getString("Rank"));
                g.setName(curr.getString("Name"));
                g.setPlatform(curr.getString("Platform"));
                g.setYear(curr.getInteger("Year"));
                g.setGenre(curr.getString("Genre"));
                g.setPublisher(curr.getString("Publisher"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setEU_Sales(curr.getDouble("EU_Sales"));
                g.setJP_Sales(curr.getDouble("JP_Sales"));
                g.setOther_Sales(curr.getDouble("Other_Sales"));
                g.setGlobal_Sales(curr.getDouble("Global_Sales"));

                ret.add(g);
            }
            request.setAttribute("result2", ret);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TwoQuery.jsp");
            dispatcher.forward(request, response);

        }


        else if(query.equals("three")) {
            String Name = request.getParameter("Name");
            BasicDBObject andQuery = new BasicDBObject();
            List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
            andQuery.put("Name", new BasicDBObject ("$regex", Name).append("$options", "i"));

            //andQuery.put("$and", obj);
            FindIterable<Document> docIterator1 = collection.find(andQuery);
            MongoCursor<Document> cursorquery2 = docIterator1.iterator();
            ArrayList<Game> ret = new ArrayList<>();
            while (cursorquery2.hasNext()) {
                Game g = new Game();
                Document curr = (Document) cursorquery2.next();
                g.setRank(curr.getString("Rank"));
                g.setName(curr.getString("Name"));
                g.setPlatform(curr.getString("Platform"));
                g.setYear(curr.getInteger("Year"));
                g.setGenre(curr.getString("Genre"));
                g.setPublisher(curr.getString("Publisher"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setEU_Sales(curr.getDouble("EU_Sales"));
                g.setJP_Sales(curr.getDouble("JP_Sales"));
                g.setOther_Sales(curr.getDouble("Other_Sales"));
                g.setGlobal_Sales(curr.getDouble("Global_Sales"));

                ret.add(g);
            }
            request.setAttribute("result", ret);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ThreeQuery.jsp");
            dispatcher.forward(request, response);

        }


        else if(query.equals("four")) {

            Integer Year = Integer.valueOf(request.getParameter("Year"));

            FindIterable<Document> res = null;

            if (order.equals("OrdinamentoCrescente")) {
                res = collection.find
                        (new Document("Year",
                                new Document("$gte", Year)))
                        .sort(Sorts.ascending("Year"))
                        .skip(750)
                        .limit(250);
            }

            else if (order.equals("OrdinamentoDecrescente")) {
                res = collection.find
                        (new Document("Year",
                                new Document("$gte", Year)))
                        .sort(Sorts.descending("Year"))
                        .skip(850)
                        .limit(250);
            }

            else if (order.equals("NessunOrdinamento")) {
                res = collection.find
                        (new Document("Year",
                                new Document("$gte", Year)))

                        .skip(850)
                        .limit(250);
            }


            MongoCursor res1 = res.iterator();
            ArrayList<Game> ret = new ArrayList<>();
            while (res1.hasNext()) {
                Game g = new Game();
                Document curr = (Document) res1.next();

                g.setName(curr.getString("Name"));
                g.setGenre(curr.getString("Genre"));
                g.setRank(curr.getString("Rank"));
                g.setPlatform(curr.getString("Platform"));
                g.setPublisher(curr.getString("Publisher"));
                g.setYear(curr.getInteger("Year"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setEU_Sales(curr.getDouble("EU_Sales"));
                g.setJP_Sales(curr.getDouble("JP_Sales"));
                g.setOther_Sales(curr.getDouble("Other_Sales"));
                g.setGlobal_Sales(curr.getDouble("Global_Sales"));

                ret.add(g);
            }
            request.setAttribute("result", ret);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FourQuery.jsp");
            dispatcher.forward(request, response);

        }




        else if(query.equals("five")) {
            String Publisher = request.getParameter("Publisher");
            BasicDBObject andQuery = new BasicDBObject();
            List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
            obj.add(new BasicDBObject("Publisher", Publisher));

            andQuery.put("$and", obj);
            FindIterable<Document> docIterator1 = collection.find(andQuery);
            MongoCursor<Document> cursorquery2 = docIterator1.iterator();
            ArrayList<Game> ret = new ArrayList<>();
            while (cursorquery2.hasNext()) {
                Game g = new Game();
                Document curr = (Document) cursorquery2.next();
                g.setRank(curr.getString("Rank"));
                g.setName(curr.getString("Name"));
                g.setPlatform(curr.getString("Platform"));
                g.setYear(curr.getInteger("Year"));
                g.setGenre(curr.getString("Genre"));
                g.setPublisher(curr.getString("Publisher"));
                g.setNA_Sales(curr.getDouble("NA_Sales"));
                g.setEU_Sales(curr.getDouble("EU_Sales"));
                g.setJP_Sales(curr.getDouble("JP_Sales"));
                g.setOther_Sales(curr.getDouble("Other_Sales"));
                g.setGlobal_Sales(curr.getDouble("Global_Sales"));

                ret.add(g);
            }
            request.setAttribute("result", ret);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FiveQuery.jsp");
            dispatcher.forward(request, response);

        }




    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
