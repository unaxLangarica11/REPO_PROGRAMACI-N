package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_corrientes")
public class CuentaCorriente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(Integer id, String iban, Double saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public CuentaCorriente() {

    }
}