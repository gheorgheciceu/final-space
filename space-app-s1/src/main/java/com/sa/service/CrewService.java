package com.sa.service;

import com.sa.entity.Crew;
import com.sa.exception.ResourceNotFoundException;
import com.sa.repo.CrewRepo;
import com.sa.to.CrewTO;
import com.sa.to.CrewTOLight;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrewService {

    @Autowired
    private CrewRepo crewRepo;

    @Autowired
    private ModelMapper modelMapper;

    public List<CrewTO> findAll() {
        return crewRepo.findAll().stream().map(crew -> modelMapper.map(crew, CrewTO.class)).collect(Collectors.toList());
    }

    public CrewTO findById(Integer id) {
        Crew crew = crewRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Crew with Id {0} does not exist", id));
        return modelMapper.map(crew, CrewTO.class);
    }

    public CrewTOLight create(CrewTOLight crewTO) {
        Crew crew = new Crew();
        crew.setShuttleName(crewTO.getShuttleName());
        return modelMapper.map(crewRepo.save(crew), CrewTOLight.class);
    }
}
