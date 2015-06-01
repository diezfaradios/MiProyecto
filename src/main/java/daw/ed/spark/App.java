package daw.ed.spark;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.get;
import static spark.Spark.post;
import spark.template.freemarker.FreeMarkerRoute;
import spark.ModelAndView;
import spark.Spark;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        //creamos conexion
        final  MongoClient client = new MongoClient();
        final MongoDatabase database = client.getDatabase("discoteca");
        final MongoCollection<Document> collection = database.getCollection("discos");

        Spark.staticFileLocation("/public");

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                //consultamos la base de datos
                
                ArrayList<Disco> discos = new ArrayList<>();
                
                MongoCursor<Document> cursor = collection.find().iterator();
                try {
                    while (cursor.hasNext()) {
                        Document cur = cursor.next();

                        Disco miDisco = new Disco(cur.getString("nombre"),
                                cur.getString("autor"),
                                cur.getDouble("año"),
                                cur.getString("estilo"),
                                cur.getDouble("numeroCanciones")
                        );
                        discos.add(miDisco);
                        
                    }
                } finally {
                    cursor.close();
                }
                
                Map<String, Object> data = new HashMap<>();
                data.put("discos", discos);

                return modelAndView(data, "userList.ftl");
            }
        });
        //crear un disco

        post(new Route("/disco/create") {
            @Override
            public Object handle(Request request, Response response) {

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                Integer año = Integer.parseInt(request.queryParams("año"));
                String estilo = request.queryParams("estilo");
                Integer numeroCanciones = Integer.parseInt(
                        request.queryParams("numeroCanciones"));
                
                Document miDisco = new Document();
                
                miDisco.put("nombre", titulo);
                miDisco.put("autor", autor);
                miDisco.put("año", new Double(año));
                miDisco.put("estilo", estilo);
                miDisco.put("numeroCanciones", new Double(numeroCanciones));
                
                collection.insertOne(miDisco);

                response.redirect("/");
                return response;
            }
        });
        // se crea un indice identificatorio.Borrar un disco indice.

        get(new Route("/disco/borrar/:indice") {
           
            @Override
            public Object handle(Request request, Response response) {
                int indice = Integer.parseInt(
                        request.params(":indice"));
                         miDisco.remove(new BasicDBObject().append("id", "indice"));
              
                response.redirect("/");
                return null;

            }
        });
        // Boton editar manda al indice al formulario para editarlo.

        get(new FreeMarkerRoute("disco/editar/:indice") {
            @Override
            public ModelAndView handle(Request request, Response response) {

                int indice = Integer.parseInt(
                        request.params(":indice"));
                Disco disco = MiDisco.get(indice);

                Map<String, Object> data = new HashMap<>();
                data.put("disco", disco);

                return modelAndView(data, "editUser.ftl");
            }
        });
        //editar en el formulario de edicion, indice; pasar los datos a la pagina principal

        post(new Route("disco/editar/:indice") {
            @Override
            public Object handle(Request request, Response response) {

                int indice = Integer.parseInt(
                        request.params(":indice"));
                Disco disco = discos.get(indice);

                disco.setAutor(request.queryParams("autor"));
                disco.setTitulo(request.queryParams("titulo"));
                disco.setAño(request.queryParams("año"));
                disco.setEstilo(request.queryParams("estilo"));
                disco.setNumeroCanciones(Integer.parseInt(request.queryParams("numeroCanciones")));

                response.redirect("/");
                return null;
            }
        });

    }
}
