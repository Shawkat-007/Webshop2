package de.szut.store.article;

import de.szut.store.supplier.SupplierEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "article")
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;

    @NotBlank(message = "Designation is mandatory")
    private String designation;

    @NotNull
    private double price;
    @Column(name = "create_data", nullable = false)
    private LocalDateTime createDate = LocalDateTime.now();

    @Column(name = "last_update_data", nullable = false)
    private LocalDateTime lastUpdateDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SupplierEntity supplier;
}
