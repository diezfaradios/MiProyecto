package daw.ed.spark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
public class App 
{
    public static void main( String[] args )
    {
        Spark.staticFileLocation("/public");
        
    	final ArrayList<Disco>discos = new ArrayList<>();
        discos.add(new Disco("Viento de Cara","Supersubmarina","2015","Pop",12));
        discos.add(new Disco("Lana Del Rey","Born to Die","2012","Pop",12));
        discos.add(new Disco("Vetusta Morla","la Deriva","2015","Pop",12));

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {            	

                Map<String, Object> data = new HashMap<>();
                data.put("discos",discos); 
                
            	return modelAndView(data, "userList.ftl");
            }
        });
        
        
        post(new FreeMarkerRoute("/disco/create") {
            @Override
            public ModelAndView handle(Request request, Response response) {            	

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                String año = request.queryParams("año");
                String estilo = request.queryParams("estilo");
               // int numeroCanciones = request.queryParams("numeroCanciones");
                Disco miDisco = new Disco(titulo,autor,año,estilo);
                /*Map<String, Object> data = new HashMap<>();
                data.put("discos",discos); 
                
            	return modelAndView(data, "userList.ftl");*/
                return modelAndView(null,"borra.ftl");
            }
        });
    }
}
