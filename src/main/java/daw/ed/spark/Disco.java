package daw.ed.spark;
 
public class Disco {
        private String	titulo;
        private String	autor;
        private String	año;
        private String  estilo;
        private int  numeroCanciones;
 
        public Disco() {
        }
 
        public Disco(String titulo, String autor, String año, String estilo, int numeroCanciones) {
                this.titulo = titulo;
                this.autor = autor;
                this.año = año;
                this.estilo = estilo;
                this.numeroCanciones = numeroCanciones;
 
        }

        public String getTitulo() {
        	return titulo;
        }

        public String getAutor() {
        	return autor;
                
        }
        public String getAño() {
            return año;
        }

         public String getEstilo() {
            return estilo;
  }
         public int getNumeroCanciones() {
            return numeroCanciones;
        }
 
        public void setTitulo(String titulo) {
        	this.titulo = titulo;
        }

        public void setAutor(String autor) {
        	this.autor = autor;
        }
         public void setAño(String año) {
        	this.año = año;
        }
          public void setEstilo(String estilo) {
            this.estilo = estilo;
        }
          public void setNumeroCanciones(int numeroCanciones) {
            this.numeroCanciones = numeroCanciones;
        }

}

