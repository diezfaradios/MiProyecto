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
        discos.add(new Disco("Born to Die","Lana Del Rey","2012","Pop",12));
        discos.add(new Disco("Vetusta Morla","la Deriva","2015","Pop",12));

        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {            	

                Map<String, Object> data = new HashMap<>();
                data.put("discos",discos); 
                
            	return modelAndView(data, "userList.ftl");
            }
        });
        //crear un disco
        
        post(new Route("/disco/create") {
            @Override
            public Object handle(Request request, Response response) {            	

                String titulo = request.queryParams("titulo");
                String autor = request.queryParams("autor");
                String año = request.queryParams("año");
                String estilo = request.queryParams("estilo");
                Integer numeroCanciones = Integer.parseInt(
                        request.queryParams("numeroCanciones"));
                
                Disco miDisco = new Disco(titulo,autor,año,estilo,numeroCanciones);
                discos.add(miDisco);
                
                response.redirect("/");
                return null;
            }
        });
        // se crea un indice identificatorio.Borrar un disco indice.
        
        get(new Route("/disco/borrar/:indice") {
                        @Override
                        public Object handle(Request request, Response response) {
                            int indice = Integer.parseInt(
                                    request.params(":indice"));                            
                            discos.remove(indice);
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
                Disco disco = discos.get(indice);
                
                Map<String, Object> data = new HashMap<>();
                data.put("disco",disco);
                
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

