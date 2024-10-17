package com.example.brinquedos.service;

import com.example.brinquedos.model.Brinquedo;
import com.example.brinquedos.repository.BrinquedoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BrinquedoService {
	  @Autowired
	    private BrinquedoRepository repository;

	    public List<Brinquedo> getAllBrinquedos() {
	        return repository.findAll();
	    }

	    public Brinquedo getBrinquedoById(Long id) {
	        return repository.findById(id).orElse(null);
	    }

	    public Brinquedo saveBrinquedo(Brinquedo brinquedo) {
	        return repository.save(brinquedo);
	    }

	    public Brinquedo updateBrinquedo(Brinquedo brinquedo) {
	        return repository.save(brinquedo);
	    }

	    public void deleteBrinquedo(Long id) {
	        repository.deleteById(id);
	    }
}
