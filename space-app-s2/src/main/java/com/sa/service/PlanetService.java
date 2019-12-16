package com.sa.service;

import com.sa.entity.Planet;
import com.sa.entity.SolarSystem;
import com.sa.enums.PlanetStatus;
import com.sa.exception.ResourceNotFoundException;
import com.sa.repo.PlanetRepo;
import com.sa.repo.SolarSystemRepo;
import com.sa.to.PlanetTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanetService {
    @Autowired
    private PlanetRepo planetRepo;

    @Autowired
    private SolarSystemRepo solarSystemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    public List<PlanetTO> findPlanetsBySolarSystemId(int solarSystemId) {
        Optional<SolarSystem> solarSystem = solarSystemRepo.findById(solarSystemId);
        if (solarSystem.isPresent()) {
            return solarSystem.get().getPlanets().stream().map(planet -> modelMapper.map(planet, PlanetTO.class)).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<PlanetTO> findAll() {
        return planetRepo.findAll().stream().map(planet -> modelMapper.map(planet, PlanetTO.class)).collect(Collectors.toList());
    }

    public void updatePlanetStatus(String status, int planetId) {
        Planet planet = planetRepo.findById(planetId).orElseThrow(() -> new ResourceNotFoundException("Planet with Id {0} does not exist", planetId));
        planet.setStatus(PlanetStatus.getStatus(status));
        planetRepo.save(planet);
    }


    public PlanetTO createPlanet(PlanetTO planetTO) {
        Planet planet = new Planet();
        planet.setName(planetTO.getName());
        planet.setDescription(planetTO.getDescription());
        planet.setVisitedBy(null);
        planet.setImage(planetTO.getPicture() != null ? planetTO.getPicture().getBytes(StandardCharsets.UTF_8) : null);
        planet.setSolarSystem(solarSystemRepo.findById(planetTO.getSolarSystemId()).orElseThrow(() -> new ResourceNotFoundException("SolarSystem with Id {0} does not exist", planetTO.getSolarSystemId())));
        planet.setStatus(PlanetStatus.TODO);
        planetRepo.save(planet);
        return modelMapper.map(planet, PlanetTO.class);
    }

    public void assignCrewToPlanet(Integer crewId, int planetId) {
        Planet planet = planetRepo.findById(planetId).orElseThrow(() -> new ResourceNotFoundException("Planet with Id {0} does not exist", planetId));
        //check if crew actually exists
        final String uri = "http://localhost:8081/crew-service/crews/" + crewId;
        ResponseEntity response = restTemplate.getForEntity(uri, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new ResourceNotFoundException("Crew with id {0} does not exist", crewId);
        }
        planet.setVisitedBy(crewId);
        planetRepo.save(planet);
    }

    public PlanetTO findOne(Integer planetId) {
        Planet planet = planetRepo.findById(planetId).orElseThrow(() -> new ResourceNotFoundException("Planet with Id {0} does not exist", planetId));
        return modelMapper.map(planet, PlanetTO.class);
    }

    public void delete(Integer planetId) {
        Planet planet = planetRepo.findById(planetId).orElseThrow(() -> new ResourceNotFoundException("Planet with Id {0} does not exist", planetId));
        planetRepo.delete(planet);
    }
}
