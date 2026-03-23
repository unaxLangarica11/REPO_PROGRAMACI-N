package Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cuentas_corrientes")
public class CuentaCorriente {
    @Id

    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Double saldo;


    // RELACIÓN 1 A N

    @OneToMany(mappedBy = "iban", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Titular> titulares = new LinkedHashSet<>();


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


    //GETTER Y SETTER DE LA RELACION

    public Set<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Titular> titulares) {
        this.titulares = titulares;
    }

    //generar el to string
    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", titulares=" + titulares +
                '}';
    }
}