package modelo;

public class Autor {
    private int autorid;
    private String nombre;
    private String nacionalidad;

    public Autor() {}

    public Autor(int autorid, String nombre, String nacionalidad) {
        this.autorid = autorid;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public int getAutorid() { return autorid; }
    public void setAutorid(int autorid) { this.autorid = autorid; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNacionalidad() { return nacionalidad; }
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    @Override
    public String toString() {
        return "Autor{" +
                "autorid=" + autorid +
                ", nombre='" + nombre + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}
