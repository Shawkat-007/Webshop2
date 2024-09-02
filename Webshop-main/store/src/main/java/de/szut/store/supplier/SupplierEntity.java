package de.szut.store.supplier;


import de.szut.store.article.ArticleEntity;
import de.szut.store.contact.ContactEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "supplier")
public class SupplierEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @NotBlank
    @Size(max = 50, message = "Name mus not exceed 50 characters")
    private String name;

    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    ContactEntity contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ArticleEntity> articles;

}