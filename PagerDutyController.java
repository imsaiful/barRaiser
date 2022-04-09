package com.example.bar.bar.controller;


import com.example.bar.bar.dto.TeamMap;
import com.example.bar.bar.service.OnCallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.TreeMap;

@RestController
@RequestMapping("/alert")
public class PagerDutyController {

    @Autowired
    private OnCallService onCallService;

    @PostMapping("/add")
    public ResponseEntity<?> addTeam(@RequestBody TeamMap teamMap){
        onCallService.addTeam(teamMap);
        return ResponseEntity.ok("Data Save");
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendNotification(){
        onCallService.sendAlert(1L,"5XX on /feed api");
        return ResponseEntity.ok("Data Save");
    }



}
