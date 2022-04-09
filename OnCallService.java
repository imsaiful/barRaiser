package com.example.bar.bar.service;

import com.example.bar.bar.dto.NotificationDto;
import com.example.bar.bar.dto.NotificationType;
import com.example.bar.bar.dto.TeamMap;
import com.example.bar.bar.model.Developer;
import com.example.bar.bar.model.Team;
import com.example.bar.bar.repository.DeveloperRepository;
import com.example.bar.bar.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OnCallService {

    @Autowired
    private TeamRepository teamRepo;

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private NotificationService notificationService;

    public void addTeam(TeamMap teamMap){

        if(Objects.isNull(teamMap) || Objects.isNull(teamMap.getTeam())){
            return;
        }
        Team team=teamMap.getTeam();
        teamRepo.save(team);
        for(Developer dev:teamMap.getDeveloper()){
            dev.setTeamId(team.getId());
        }
        developerRepository.saveAll(teamMap.getDeveloper());
    }

    public boolean sendAlert(Long id,String message){
        List<Developer> developers=developerRepository.findByTeamId(id);
        Optional<Developer> dev = developers.stream().filter(developer->developer.isOnCall()).findFirst();
        if(dev.isPresent()){
            NotificationDto notificationDto=NotificationDto
                    .builder()
                    .notificationType(NotificationType.MOBILE)
                    .content(message)
                    .mobile(dev.get().getPhoneNumber())
                    .build();
                    notificationService.send(notificationDto);
            return true;
        }
        return false;
    }
}
