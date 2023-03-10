package com.mvc.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AppelOffre",uniqueConstraints = {
@UniqueConstraint(columnNames = "ref")
})
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class AppelOffre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ref" , nullable = false,unique = true)
    private String ref;
    @Column(name = "refProduit")
    private String refProduit;
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    //@JsonManagedReference
    private Stock stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fournisseur_id")
    //@JsonManagedReference
    private Fournisseur fournisseur;


    public AppelOffre(String ref, String refProduit, Status status, int quantity) {
        this.ref = ref;
        this.refProduit = refProduit;
        this.status = status;
        this.quantity = quantity;
    }
}
