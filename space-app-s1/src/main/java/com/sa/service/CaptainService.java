package com.sa.service;

import com.sa.entity.Captain;
import com.sa.entity.Crew;
import com.sa.exception.ResourceNotFoundException;
import com.sa.repo.CaptainRepo;
import com.sa.repo.CrewRepo;
import com.sa.to.CaptainTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaptainService {

    @Autowired
    private CaptainRepo captainRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CrewRepo crewRepo;

    public List<CaptainTO> findAll() {
        return captainRepo.findAll().stream().map(captain -> modelMapper.map(captain, CaptainTO.class)).collect(Collectors.toList());
    }

    public CaptainTO findById(Integer id) {
        Captain captain = captainRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Captain with Id {0} does not exist", id));
        return modelMapper.map(captain, CaptainTO.class);
    }

    public CaptainTO createCaptian(CaptainTO captainTO, Integer crewId) {
        Crew crew = crewRepo.findById(crewId).orElseThrow(() -> new ResourceNotFoundException("Crew with Id {0} does not exist", crewId));
        Captain captain = new Captain();
        captain.setLastName(captainTO.getLastName());
        captain.setFirstName(captainTO.getFirstName());
        captain.setCrew(crew);
        captainRepo.save(captain);
        return modelMapper.map(captain, CaptainTO.class);

    }
}
