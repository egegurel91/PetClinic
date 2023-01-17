package com.egurel.petClinic.Controller;

import com.egurel.petClinic.Entity.Pet;
import com.egurel.petClinic.Entity.Owner;
import com.egurel.petClinic.Entity.PetType;
import com.egurel.petClinic.Entity.Visit;
import com.egurel.petClinic.Service.OwnerService;
import com.egurel.petClinic.Service.PetTypeService;
import com.egurel.petClinic.Service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class OwnerController {

    private final OwnerService ownerService;

    private final VisitService visitService;

    @Autowired
    private PetTypeService petTypeService;

    public OwnerController(OwnerService ownerService, VisitService visitService) {
        this.ownerService = ownerService;
        this.visitService = visitService;
    }

    @GetMapping(value = "/api/owners")
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping(value = "/api/owners")
    public void addNewOwner(@RequestBody Owner owner) {
        ownerService.addNewOwner(owner);
    }

    @GetMapping(value = "/api/owners/{id}")
    public Optional<Owner> getOwner (@PathVariable Long id ) {
        return ownerService.getOwner(id);
    }

    @GetMapping(value = "/api/owners/{id}/pets")
    public List<Pet> getPetsForOwner(@PathVariable Long id) {
        return ownerService.getPetsForOwner(id);
    }

    @PostMapping(value = "/api/owners/{id}/pets")
    public List<Pet> addPet (@PathVariable Long id, @RequestBody Pet pet) {
        return ownerService.addPet(id, pet);
    }

    @PutMapping(value = "/api/owners/{id}/pets")
    public void editPet (@PathVariable(required = true) Long ownerId, @RequestBody Pet pet) {
       ownerService.editPet(ownerId,pet);
    }

    @PostMapping(value="/api/owners/{id}/pets/{petId}")
    public List<Visit> addVisitForPet(@PathVariable Long id, @PathVariable Long petId, @RequestBody Visit visit) {
        return visitService.addVisit(id, petId, visit);
    }

    @GetMapping(value = "/api/petTypes")
    public List<PetType> getPetTypesDropdown() {
        return petTypeService.getPetTypes();
    }

    @PutMapping(value = "/api/owners")
    public void editOwner (@RequestBody Owner owner ) {
        ownerService.editOwner(owner);
    }




}
