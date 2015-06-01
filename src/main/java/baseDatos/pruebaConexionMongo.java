package baseDatos;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import com.mongodb.ServerAddress;
import java.util.Date;
import java.util.List;
/**
/**
 *
 * @author juanjo
 */
public class pruebaConexionMongo {
public static void main(String[] args) {
        System.out.println("Prueba conexión MongoDB");
        MongoClient mongo = crearConexion();
 
        if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
            printDatabases(mongo);
 
        } else {
            System.out.println("Error: Conexión no establecida");
        }
    }
 
    /* Conexión a MongoDB.*/
    
    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        mongo = new MongoClient("localhost", 27017);
        return mongo;
    }
 
    /**
     * Bases de datos de mongo.
     */
    private static void printDatabases(MongoClient mongo) {
        List dbs = mongo.getDatabaseNames();
        for (Object db : dbs) {
            System.out.println(" - " + db);
        }
    }
}
 

    
