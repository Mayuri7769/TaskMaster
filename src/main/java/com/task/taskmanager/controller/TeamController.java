package com.task.taskmanager.controller;

import com.task.taskmanager.entity.Team;
import com.task.taskmanager.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/{teamId}/join/{userId}")
    public Team joinTeam(@PathVariable Long teamId,
                         @PathVariable Long userId) {

        return teamService.joinTeam(teamId, userId);
    }
}