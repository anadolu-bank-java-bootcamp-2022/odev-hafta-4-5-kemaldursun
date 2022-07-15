package com.gokhantamkoc.javabootcamp.odevhafta45.service;

import com.gokhantamkoc.javabootcamp.odevhafta45.model.Owner;
import com.gokhantamkoc.javabootcamp.odevhafta45.model.Product;
import com.gokhantamkoc.javabootcamp.odevhafta45.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    OwnerRepository ownerRepository;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }


    public void createOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner getOwner(long id) {
        return ownerRepository.get(id);
    }

    public void updateOwner(Owner owner) {
        ownerRepository.update(owner);
    }

    public List<Owner> listOwner() {
        return ownerRepository.getAll();
    }
}
