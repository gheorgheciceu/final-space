package com.sa.controller;

import com.sa.service.PlanetService;
import com.sa.to.PlanetTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetService planetService;

    @GetMapping("/{solarSystemId}")
    public ResponseEntity<List<PlanetTO>> getPlanetBySolarSystemId(@PathVariable("solarSystemId") int solarSystemId) {
        return new ResponseEntity<>(planetService.findPlanetsBySolarSystemId(solarSystemId), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<PlanetTO>> getPlanetBySolarSystemId() {
        return new ResponseEntity<>(planetService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{planetId}")
    public ResponseEntity<PlanetTO> getPlanetById(@PathVariable("planetId") Integer planetId) {
        return new ResponseEntity<>(planetService.findOne(planetId), HttpStatus.OK);
    }

    @PostMapping("/updateStatus/{planetId}")
    public ResponseEntity updatePlanetStatus(@PathVariable("planetId") int id, @RequestBody String status) {
        planetService.updatePlanetStatus(status, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/assignCrew/{planetId}")
    public ResponseEntity assignCrew(@PathVariable("planetId") int id, @RequestBody Integer crewId) {
        planetService.assignCrewToPlanet(crewId, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<PlanetTO> createPlanet(@RequestBody PlanetTO planetTO) {
        return new ResponseEntity<>(planetService.createPlanet(planetTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{planetId}")
    public ResponseEntity deletePlanet(@PathVariable("planetId") Integer planetId) {
        planetService.delete(planetId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
