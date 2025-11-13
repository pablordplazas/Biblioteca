package modelo;

public class Multa {
    private int multaid;
    private int prestamoid;
    private double monto;
    private boolean pagada;

    public Multa() {}

    public Multa(int multaid, int prestamoid, double monto, boolean pagada) {
        this.multaid = multaid;
        this.prestamoid = prestamoid;
        this.monto = monto;
        this.pagada = pagada;
    }

    public int getMultaid() { return multaid; }
    public void setMultaid(int multaid) { this.multaid = multaid; }

    public int getPrestamoid() { return prestamoid; }
    public void setPrestamoid(int prestamoid) { this.prestamoid = prestamoid; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public boolean isPagada() { return pagada; }
    public void setPagada(boolean pagada) { this.pagada = pagada; }

    @Override
    public String toString() {
        return "Multa{" +
                "multaid=" + multaid +
                ", prestamoid=" + prestamoid +
                ", monto=" + monto +
                ", pagada=" + pagada +
                '}';
    }
}
