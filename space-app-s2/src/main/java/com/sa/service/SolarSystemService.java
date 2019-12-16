package com.sa.service;

import com.sa.entity.SolarSystem;
import com.sa.exception.ResourceNotFoundException;
import com.sa.repo.SolarSystemRepo;
import com.sa.to.SolarSystemTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolarSystemService {
    @Autowired
    private SolarSystemRepo solarSystemRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<SolarSystemTO> findAll() {
        return solarSystemRepo.findAll().stream().map(solarSystem -> modelMapper.map(solarSystem, SolarSystemTO.class)).collect(Collectors.toList());
    }

    public SolarSystemTO findOne(Integer id) {
        SolarSystem solarSystem = solarSystemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Solar System with id {0} not found", id));
        return modelMapper.map(solarSystem, SolarSystemTO.class);
    }

    public SolarSystemTO update(Integer id, SolarSystemTO solarSystemTO) {
        SolarSystem solarSystem = solarSystemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Solar System with id {0} not found", id));
        solarSystem.setName(solarSystemTO.getName());
        solarSystemRepo.save(solarSystem);
        return modelMapper.map(solarSystem, SolarSystemTO.class);
    }

    public SolarSystemTO create(SolarSystemTO solarSystemTO) {
        SolarSystem solarSystem = new SolarSystem();
        solarSystem.setName(solarSystemTO.getName());
        solarSystemRepo.save(solarSystem);
        return modelMapper.map(solarSystem, SolarSystemTO.class);
    }

    public SolarSystemTO delete(Integer id) {
        SolarSystem solarSystem = solarSystemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Solar System with id {0} not found", id));
        SolarSystemTO solarSystemTO = modelMapper.map(solarSystem, SolarSystemTO.class);
        solarSystemRepo.delete(solarSystem);
        return solarSystemTO;
    }
}
