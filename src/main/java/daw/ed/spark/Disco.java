package daw.ed.spark;
 
public class Disco {
        private String	titulo;
        private String	autor;
        private double	año;
        private String  estilo;
        private double  numeroCanciones;
 
        public Disco() {
        }
 
        public Disco(String titulo, String autor, double año, String estilo, double numeroCanciones) {
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
        public double getAño() {
            return año;
        }

         public String getEstilo() {
            return estilo;
  }
         public double getNumeroCanciones() {
            return numeroCanciones;
        }
 
        public void setTitulo(String titulo) {
        	this.titulo = titulo;
        }

        public void setAutor(String autor) {
        	this.autor = autor;
        }
         public void setAño(double año) {
        	this.año = año;
        }
          public void setEstilo(String estilo) {
            this.estilo = estilo;
        }
          public void setNumeroCanciones(double numeroCanciones) {
            this.numeroCanciones = numeroCanciones;
        }

}

