package com.sa.controller;


import com.sa.service.CaptainService;
import com.sa.service.CrewService;
import com.sa.to.CaptainTO;
import com.sa.to.CrewTO;
import com.sa.to.CrewTOLight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/crews")
public class CrewController {

    @Autowired
    private CrewService crewService;

    @Autowired
    private CaptainService captainService;

    @GetMapping("/")
    public ResponseEntity<List<CrewTO>> getCrews() {
        return new ResponseEntity<>(crewService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{crewId}")
    public ResponseEntity<CrewTO> getCrew(@PathVariable("crewId") Integer id) {
        return new ResponseEntity<>(crewService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CrewTOLight> createCrew(@RequestBody CrewTOLight crew) {
        return new ResponseEntity<>(crewService.create(crew), HttpStatus.CREATED);
    }

    @PostMapping("/{crewId}/captain")
    public ResponseEntity<CaptainTO> ceateCaptain(@RequestBody CaptainTO captain, @PathVariable("crewId") Integer crewId) {
        return new ResponseEntity<>(captainService.createCaptian(captain, crewId), HttpStatus.CREATED);
    }


}
