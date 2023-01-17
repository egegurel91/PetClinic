package com.egurel.petClinic.Service;

import com.egurel.petClinic.Entity.Owner;
import com.egurel.petClinic.Entity.Pet;
import com.egurel.petClinic.Entity.Visit;
import com.egurel.petClinic.Repository.OwnerRepository;
import com.egurel.petClinic.Repository.PetRepository;
import com.egurel.petClinic.Repository.VisitRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class VisitService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VisitRepository visitRepository;

    public List<Visit> addVisit(Long id, Long petId, Visit visit) {

        Owner owner = ownerRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Not found"));
        Pet pet = petRepository.findById(petId).orElseThrow(
                () -> new NoSuchElementException("Not found"));

        visit.setPet(pet);
        visitRepository.save(visit);
        pet.setOwner(owner);
        petRepository.save(pet);
        return pet.getVisits();
    }

}
