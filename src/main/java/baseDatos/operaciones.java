package baseDatos;    

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 *
 * @author juanjo
 */
public class operaciones {

    public static void main(String[] args) {
        System.out.println("Prueba conexión MongoDB");
        MongoClient mongo = null;
        try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
 
        if (mongo != null) {
 
            //Si no existe la base de datos la crea
            DB db = mongo.getDB("discoteca");
 
            //Crear una tabla si no existe y agrega datos
            DBCollection table = db.getCollection("disco");
            
            BasicDBObject document1 = new BasicDBObject();

            document1.put("nombre", "Viento de Cara");
            document1.put("autor", "Supersubmarina");
            document1.put ("anyo", 2015);//("año", new Date());
            document1.put("estilo", "pop");
            document1.put("numeroCanciones", 12);
 
            BasicDBObject document2 = new BasicDBObject();
            
            document2.put("nombre", "Born to Die");
            document2.put("autor", "Lana Del Rey");
            document2.put ("año", 2012);//("año", new Date());
            document2.put("estilo", "Pop");
            document2.put("numeroCanciones", 12);

            //Insertar tablas
            table.insert(document1);
            table.insert(document2);
   //  ArrayList<disco> all = disco.find().into(new ArrayList<disco>()); ¿seria para meter todo el array de discos?
       
            System.out.println("Lista de discos: ");

            DBCursor cur = table.find();

            while (cur.hasNext()) {

            System.out.println(" -Titulo " + cur.next().get("nombre") 
                               + " Autor " + cur.curr().get("autor")
                               + " Año publicación " + cur.curr().get("año") 
                               + " Estilo "+ cur.next().get("estilo") 
                               + " Nº canciones " + cur.next().get("numeroCanciones"));
            }

            System.out.println();
 
            //Actualiza estilo"
            
            BasicDBObject updateEstilo = new BasicDBObject();
            updateEstilo.append("$set", new BasicDBObject().append("estilo", "Rock"));
 
            BasicDBObject searchById = new BasicDBObject();
            searchById.append("estilo", "pop");
 
            table.updateMulti(searchById, updateEstilo);
 
            //Listar de la tabla "discos" aquellos que se llamen "Lana del rey"
            System.out.println("Registros Lana del rey: ");
            BasicDBObject igual = new BasicDBObject();
            igual.put("autor", "Lana del rey");
 
            DBCursor cur2 = table.find(igual);
            while (cur2.hasNext()) {

                            System.out.println
                                (" -Titulo " + cur.next().get("nombre") 
                               + " Autor " + cur2.curr().get("autor")
                               + " Año publicación " + cur2.curr().get("año") 
                               + " Estilo "+ cur2.next().get("estilo") 
                               + " Nº canciones " + cur2.next().get("numeroCanciones"));
            }
            System.out.println();
 
            //Eliminar autor Lana del rey
            table.remove(new BasicDBObject().append("autor", "Lana Del Rey"));

          //Borrar base de datos
            db.dropDatabase();
 
        } else {
            System.out.println("Error: Conexión no establecida");
        }
    }
}
