package com.egurel.petClinic.Service;

import com.egurel.petClinic.Entity.Pet;
import com.egurel.petClinic.Entity.Owner;
import com.egurel.petClinic.Repository.OwnerRepository;
import com.egurel.petClinic.Repository.PetRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public void addNewOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public List<Pet> getPetsForOwner(Long id) {
        Owner owner = ownerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found"));
        return owner.getPets();
    }

    public Optional<Owner> getOwner(Long id) {
        return ownerRepository.findById(id);
    }

    public List<Pet> addPet(Long id, Pet pet) {
        Owner owner = ownerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found"));
        pet.setOwner(owner);
        petRepository.save(pet);
        return owner.getPets();
    }

    public void addOwner(Owner owner) {
        ownerRepository.saveAndFlush(owner);
    }

    public void editOwner(Owner owner) {
        ownerRepository.save(owner);

//        logger.info("Object has been changed and the new object is -> {}", test);
    }

    public void editPet (Long ownerId, Pet pet) {
        Owner owner = ownerRepository.findById(ownerId).orElseThrow(
                () -> new NoSuchElementException("Not found"));
        pet.setOwner(owner);
        petRepository.save(pet);
    }

}
