package com.egurel.petClinic.Service;

import com.egurel.petClinic.Entity.PetType;
import com.egurel.petClinic.Repository.PetTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PetTypeService {

    @Autowired
    private PetTypeRepository petTypeRepository;

    public List<PetType> getPetTypes(){
        return petTypeRepository.findAll();
    }



}
