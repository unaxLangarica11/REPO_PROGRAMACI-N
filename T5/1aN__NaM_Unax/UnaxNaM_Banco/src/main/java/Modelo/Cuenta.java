package Modelo;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "iban"),
            inverseJoinColumns = @JoinColumn(name = "dni"))
    private Set<Modelo.Titulare> titulares = new LinkedHashSet<>();

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

    public Set<Modelo.Titulare> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Modelo.Titulare> titulares) {
        this.titulares = titulares;
    }

}