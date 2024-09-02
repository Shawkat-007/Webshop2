package de.szut.store.supplier;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddSupplierDTO {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 50, message = "Name mus not exceed 50 characters")
    private String name;

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
}
