package baseDatos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import com.mongodb.ServerAddress;
import java.util.Date;
/**
 *
 * @author juanjo
 */
public class mongoprueba {

    public static void main(String[] args) throws UnknownHostException {

        System.out.println("Creada base Discoteca");

        MongoClient mongo = null;

        mongo = new MongoClient("localhost", 27017);

        if (mongo != null) {

            //Si no existe la base de datos la crea

            DB db = mongo.getDB("discoteca");
            //Crea una tabla si no existe y agrega datos
            DBCollection table = db.getCollection("disco");

            //Crea documentos

            BasicDBObject document2 = new BasicDBObject();

            document2.put("nombre", "Viento de Cara");
            document2.put("autor", "Supersubmarina");
            document2.put ("año", 2015);//("año", new Date());
            document2.put("estilo", "pop");
            document2.put("numeroCanciones", 12);
            //Insertar tablas

            table.insert(document2);
            
            BasicDBObject document3 = new BasicDBObject();  
            document3.put("nombre", "Born to Die");
            document3.put("autor", "Lana Del Rey");
            document3.put ("año", 2012);//("año", new Date());
            document3.put("estilo", "Pop");
            document3.put("numeroCanciones", 12);
           
            table.insert(document3);
       
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

        } else {

            System.out.println("Error: Conexión no establecida");

        }

    }

}
    
    

