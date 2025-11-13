package modelo;

public class Libro {
    private int libroid;
    private String titulo;
    private int autorid;
    private String genero;
    private int anioPublicacion;

    public Libro() {}

    public Libro(int libroid, String titulo, int autorid, String genero, int anioPublicacion) {
        this.libroid = libroid;
        this.titulo = titulo;
        this.autorid = autorid;
        this.genero = genero;
        this.anioPublicacion = anioPublicacion;
    }

    public int getLibroid() { return libroid; }
    public void setLibroid(int libroid) { this.libroid = libroid; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAutorid() { return autorid; }
    public void setAutorid(int autorid) { this.autorid = autorid; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public int getAnioPublicacion() { return anioPublicacion; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion = anioPublicacion; }

    @Override
    public String toString() {
        return "Libro{" +
                "libroid=" + libroid +
                ", titulo='" + titulo + '\'' +
                ", autorid=" + autorid +
                ", genero='" + genero + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                '}';
    }
}
