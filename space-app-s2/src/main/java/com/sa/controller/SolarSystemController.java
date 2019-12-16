package com.sa.controller;

import com.sa.service.SolarSystemService;
import com.sa.to.SolarSystemTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("solar-systems")
public class SolarSystemController {


    @Autowired
    private SolarSystemService solarSystemService;

    @GetMapping("/")
    public List<SolarSystemTO> getAll() {
        return solarSystemService.findAll();
    }

    @GetMapping("/{solarSystemId}")
    public ResponseEntity<SolarSystemTO> getOne(@PathVariable("solarSystemId") Integer id) {
        return new ResponseEntity<>(solarSystemService.findOne(id), HttpStatus.OK);
    }

    @PutMapping("/{solarSystemId}")
    public ResponseEntity<SolarSystemTO> update(@PathVariable("solarSystemId") Integer id, @RequestBody SolarSystemTO solarSystemTO) {
        return new ResponseEntity<>(solarSystemService.update(id, solarSystemTO), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<SolarSystemTO> create(@RequestBody SolarSystemTO solarSystemTO) {
        return new ResponseEntity<>(solarSystemService.create(solarSystemTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{solarSystemId}")
    public ResponseEntity delete(@PathVariable("solarSystemId") Integer id) {
        solarSystemService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
