package com.task.taskmanager.service;

import com.task.taskmanager.entity.Team;
import com.task.taskmanager.entity.User;
import com.task.taskmanager.repository.TeamRepository;
import com.task.taskmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Team joinTeam(Long teamId, Long userId) {

        Team team = teamRepository.findById(teamId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        team.getMembers().add(user);

        return teamRepository.save(team);
    }
}
