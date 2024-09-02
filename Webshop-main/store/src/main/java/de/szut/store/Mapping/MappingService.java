package de.szut.store.Mapping;

import de.szut.store.contact.ContactEntity;
import de.szut.store.supplier.AddSupplierDTO;
import de.szut.store.supplier.GetSupplierDto;
import de.szut.store.supplier.SupplierEntity;
import org.springframework.stereotype.Service;

@Service
public class MappingService {
    public SupplierEntity mapAddSupplierDtoToSupplier(AddSupplierDTO dto){
        SupplierEntity newSupplier = new SupplierEntity();
        newSupplier.setName(dto.getName());
        ContactEntity newContact = new ContactEntity();
        newContact.setStreet(dto.getStreet());
        newContact.setPostcode(dto.getPostcode());
        newContact.setCity(dto.getCity());
        newContact.setPhone(dto.getPhone());

        newSupplier.setContact(newContact);
        newContact.setSupplier(newSupplier);
        return newSupplier;
    }

    public GetSupplierDto mapSupplierToGetSupplierDto(SupplierEntity supplier) {
        GetSupplierDto dto = new GetSupplierDto();
        dto.setSid(supplier.getSid());
        dto.setName(supplier.getName());
        dto.setStreet(supplier.getContact().getStreet());
        dto.setPostcode(supplier.getContact().getPostcode());
        dto.setCity(supplier.getContact().getCity());
        dto.setPhone(supplier.getContact().getPhone());
        return dto;
    }

}
