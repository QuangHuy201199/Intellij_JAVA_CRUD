package com.example.ason_deadline2.controller;

import com.example.ason_deadline2.model.inUser.InUser;
import com.example.ason_deadline2.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
@CrossOrigin("*")
public class ControllerUser {
    @Autowired
    private ServiceUser serviceUser;
    @GetMapping("")
    public ResponseEntity<?> pagination(@RequestParam Integer page, @RequestParam Integer limit){
        return new ResponseEntity(serviceUser.pagination(page, limit), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody InUser inUser){
        return new ResponseEntity<>(serviceUser.create(inUser), HttpStatus.CREATED);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<?> delete(@PathVariable Integer Id){
        return new ResponseEntity<>(serviceUser.delete(Id), HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<?> put(@PathVariable Integer Id, @RequestBody InUser inUser){
        return new ResponseEntity<>(serviceUser.update(Id, inUser), HttpStatus.OK);
    }
    @PutMapping("/status/{Id}")
    public ResponseEntity<?> updateStatus(@PathVariable Integer Id, @RequestBody InUser inUser){
        return new ResponseEntity<>(serviceUser.updateStatus(Id, inUser), HttpStatus.OK);
    }
}
