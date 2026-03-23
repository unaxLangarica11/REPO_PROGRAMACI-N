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

    // @OneToMany(mappedBy = "iban") Generada por defecto.


     @OneToMany(mappedBy = "iban",
               cascade = CascadeType.ALL,
               orphanRemoval = true)

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

    public Set<Titular> getTitulares() {
        return titulares;
    }

    public void setTitulares(Set<Titular> titulares) {
        this.titulares = titulares;
    }

    @Override
    public String toString() {
        // Devuelve el número de cuenta, el saldo y el dni y nombre de cada uno de los titulares
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{iban=").append(iban).append(", saldo=").append(saldo).append(", titulares=[");
        for (Titular titular : titulares) {
            sb.append("Titular{dni=").append(titular.getDni()).append(", nombre=").append(titular.getNombre()).append("}, ");
        }
        if (!titulares.isEmpty()) {
            sb.setLength(sb.length() - 2); // Remove last comma and space
        }
        sb.append("]}");
        return sb.toString();
    }
}