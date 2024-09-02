package de.szut.store.supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity create(SupplierEntity supplier){
        return this.supplierRepository.save(supplier);
    }

    public List<SupplierEntity> readAll(){
        return this.supplierRepository.findAll();
    }
    public SupplierEntity readById(long id){
        Optional<SupplierEntity> response = this.supplierRepository.findById(id);
        return response.orElse(null);
    }
    public SupplierEntity update (SupplierEntity supplier){
        SupplierEntity updateSupplier = readById(supplier.getSid());
        updateSupplier.setName(supplier.getName());
        updateSupplier.getContact().setStreet(supplier.contact.getStreet());
        updateSupplier.getContact().setPostcode(supplier.contact.getPostcode());
        updateSupplier.getContact().setCity(supplier.contact.getCity());
        updateSupplier.getContact().setPhone(supplier.getContact().getPhone());
        updateSupplier = this.supplierRepository.save(updateSupplier);
        return updateSupplier;
    }

    public void deleteSupplierById(Long id){
        this.supplierRepository.deleteById(id);

    }
}
