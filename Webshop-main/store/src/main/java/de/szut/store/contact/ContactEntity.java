package de.szut.store.contact;

import de.szut.store.supplier.SupplierEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "supplier_contact")
public class ContactEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    @NotBlank(message = "Street is mandatory")
    @Size(max = 50, message = "Street mus not exceed 50 characters")
    private String street;

    @Column(name = "zip")
    @NotBlank(message = "Postcode is mandatory")
    @Size(min = 5, max = 5, message = "Postcode mus have 5 characters")
    private String postcode;

    @NotBlank(message = "City is mandatory")
    @Size(max = 50, message = "City must not exceed 50 characters")
    private String city;

    private String phone;

    @OneToOne (mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private SupplierEntity supplier;
}
