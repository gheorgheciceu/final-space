package com.sa.controller;

import com.sa.service.CaptainService;
import com.sa.to.CaptainTO;
import com.sa.to.CrewTO;
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
@RequestMapping("/captains")
public class CaptainController {

    @Autowired
    private CaptainService captainService;

    @GetMapping("/")
    public ResponseEntity<List<CaptainTO>> getCaptains() {
        return new ResponseEntity<>(captainService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{captainId}")
    public ResponseEntity<CaptainTO> getCaptain(@PathVariable("captainId") Integer id) {
        return new ResponseEntity<>(captainService.findById(id), HttpStatus.OK);
    }

}
