package com.mvc.demo.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Product",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ref")
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Product implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_id")
    private Long id;
   @Column(name = "ref",nullable = false,unique = true)
    private String ref;
   @Column(name = "nom")
    private String nom;
   @Column(name = "category")
    private String category;
   @Column(name = "descreption")
    private String descreption;

   @Column(name = "price")
   private Double price;
   @Column(name = "quantity")
    private int quantity;
    @OneToMany(mappedBy ="product" ,cascade = CascadeType.ALL)
    //@JsonManagedReference
    private List<CommandeItem> commandeItems;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_id")
    //@JsonManagedReference
    private Stock stock;

    public Product(String ref, String nom, String category, String descreption, int quantity) {
        this.ref=ref;
        this.nom=nom;
        this.category=category;
        this.descreption=descreption;
        this.quantity=quantity;
    }


}
