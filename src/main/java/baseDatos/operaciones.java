package baseDatos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author juanjo
 */
public class operaciones {

    public static void main(String[] args) {

        System.out.println("Prueba conexión MongoDB");
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("discoteca");
        MongoCollection<Document> collection = database.getCollection("discos");

        Document miDisco = new Document();

        miDisco.put("nombre", "Viento de Cara");
        miDisco.put("autor", "Supersubmarina");
        miDisco.put("anyo", 2015);//("año", new Date());
        miDisco.put("estilo", "pop");
        miDisco.put("numeroCanciones", 12);

        //Insertar tablas
        collection.insertOne(miDisco);

        System.out.println("Lista de discos: ");

        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document cur = cursor.next();

                System.out.println(" -Titulo: " + cur.get("nombre")
                        + ", Autor: " + cur.get("autor")
                        + ", Año publicación: " + cur.get("año")
                        + ", Estilo: " + cur.get("estilo")
                        + ", Nº canciones: " + cur.get("numeroCanciones"));
            }
        } finally {
            cursor.close();
        }

        /*
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

         System.out.println(" -Titulo " + cur.next().get("nombre")
         + " Autor " + cur2.curr().get("autor")
         + " Año publicación " + cur2.curr().get("año")
         + " Estilo " + cur2.next().get("estilo")
         + " Nº canciones " + cur2.next().get("numeroCanciones"));
         }
         System.out.println();

         //Eliminar autor Lana del rey
         table.remove(new BasicDBObject().append("autor", "Lana Del Rey"));

         /*Borrar base de datos
         db.dropDatabase();*/
    }
}
