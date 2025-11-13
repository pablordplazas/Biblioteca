package modelo;

import java.sql.Date;

public class Prestamo {
    private int prestamoid;
    private int libroid;
    private int usuarioid;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private boolean devuelto;

    public Prestamo() {}

    public Prestamo(int prestamoid, int libroid, int usuarioid, Date fechaPrestamo, Date fechaDevolucion, boolean devuelto) {
        this.prestamoid = prestamoid;
        this.libroid = libroid;
        this.usuarioid = usuarioid;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.devuelto = devuelto;
    }

    public int getPrestamoid() { return prestamoid; }
    public void setPrestamoid(int prestamoid) { this.prestamoid = prestamoid; }

    public int getLibroid() { return libroid; }
    public void setLibroid(int libroid) { this.libroid = libroid; }

    public int getUsuarioid() { return usuarioid; }
    public void setUsuarioid(int usuarioid) { this.usuarioid = usuarioid; }

    public Date getFechaPrestamo() { return fechaPrestamo; }
    public void setFechaPrestamo(Date fechaPrestamo) { this.fechaPrestamo = fechaPrestamo; }

    public Date getFechaDevolucion() { return fechaDevolucion; }
    public void setFechaDevolucion(Date fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }

    public boolean isDevuelto() { return devuelto; }
    public void setDevuelto(boolean devuelto) { this.devuelto = devuelto; }

    @Override
    public String toString() {
        return "Prestamo{" +
                "prestamoid=" + prestamoid +
                ", libroid=" + libroid +
                ", usuarioid=" + usuarioid +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                ", devuelto=" + devuelto +
                '}';
    }
}
