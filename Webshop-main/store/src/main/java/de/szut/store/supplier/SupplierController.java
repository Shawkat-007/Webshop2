package de.szut.store.supplier;

import de.szut.store.Mapping.MappingService;
import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("store/supplier")
public class SupplierController {
    private final SupplierService service;
    private final MappingService mappingService;

    @Autowired
    public SupplierController(SupplierService supplierService, MappingService mappingService){
        this.mappingService = mappingService;
        this.service = supplierService;
    }

    @PostMapping
    public ResponseEntity<GetSupplierDto> createSupplier (@Valid @RequestBody final AddSupplierDTO dto){
        SupplierEntity newSupplier = this.mappingService.mapAddSupplierDtoToSupplier(dto);
        newSupplier = this.service.create(newSupplier);
        final GetSupplierDto request = this.mappingService.mapSupplierToGetSupplierDto(newSupplier);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetSupplierDto>> findAllSuppliers(){
        List<SupplierEntity> all = this.service.readAll();
        List<GetSupplierDto> dtoList = new LinkedList<>();
        for (SupplierEntity supplier : all){
            dtoList.add(this.mappingService.mapSupplierToGetSupplierDto(supplier));
        }
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetSupplierDto> getSupplierById(@PathVariable final Long id){
        final var entity = this.service.readById(id);
        final GetSupplierDto dto = this.mappingService.mapSupplierToGetSupplierDto(entity);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathVariable final Long id){
        this.service.deleteSupplierById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<SupplierEntity> updateSupplier(@RequestBody SupplierEntity newSupplier){
        SupplierEntity response = this.service.update(newSupplier);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
