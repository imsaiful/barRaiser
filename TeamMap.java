package com.example.bar.bar.dto;


import com.example.bar.bar.model.Developer;
import com.example.bar.bar.model.Team;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamMap {

    @JsonProperty("team")
    private Team team;

    @JsonProperty("developers")
    List<Developer> developer;



}
