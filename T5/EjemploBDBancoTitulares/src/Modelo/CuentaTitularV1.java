package Modelo;

public class CuentaTitularV1 {
    // En proyectos JDBC/DAO sencillos se pone ids en vez de objetos
    private int idCuenta;
    private int idTitular;

    public CuentaTitularV1() {}

    public CuentaTitularV1(int idCuenta, int idTitular) {
        this.idCuenta = idCuenta;
        this.idTitular = idTitular;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    @Override
    public String toString() {
        return "CuentaTitularV1{" +
                "idCuenta=" + idCuenta +
                ", idTitular=" + idTitular +
                '}';
    }
}

