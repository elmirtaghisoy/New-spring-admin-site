package com.cb.colorbrain.service;

import com.cb.colorbrain.model.Response;
import com.cb.colorbrain.model.Team;
import com.cb.colorbrain.model.dto.TeamView;
import com.cb.colorbrain.repository.TeamRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Response addTeam(@NotNull Team team, MultipartFile file) {
        try {
            team.setImgName(FileService.saveSingle(file));
            teamRepository.save(team);
            return new Response("Yeni koordinatorluq uğurla yaradıldı", 1);
        } catch (IOException ex) {
            ex.printStackTrace();
            return new Response("Fayl xətası", 0);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }
    }

    public List<TeamView> getAllTeamWithInfo() {
        List<TeamView> teamStatistics = new ArrayList<TeamView>();
        List<Team> teams = teamRepository.findAllByActiveTrue();
        for (Team team : teams) {
            TeamView teamStatistic = new TeamView();
            teamStatistic.setId(team.getId());
            teamStatistic.setTeamName(team.getTeamName());
            teamStatistic.setUserCount(team.getUsersById().size());
            teamStatistic.setPostCount(team.getPostsById().size());
            teamStatistic.setProjectCount(team.getProjectsById().size());
            teamStatistics.add(teamStatistic);
        }
        return teamStatistics;
    }

    public List<Team> getAllTeam() {
        return teamRepository.findAllByActiveTrue();
    }

    public Team getTeamById(Long teamId) {
        return teamRepository.getOne(teamId);
    }

    public Response updateTeam(@NotNull Team team, Long teamId, MultipartFile file) {
        try {
            Team newTeam = teamRepository.getOne(teamId);
            newTeam.setTeamName(team.getTeamName());
            newTeam.setTeamDesc(team.getTeamDesc());
            newTeam.setImgName(FileService.saveSingle(file));
            teamRepository.save(newTeam);
            return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
        } catch (IOException ex) {
            return new Response("Xəta", 0);
        } catch (Exception ex) {
            return new Response("Xəta", 0);
        }

    }

    public Response updateTeam(@NotNull Team team, Long teamId, String file) {
        try {
            Team newTeam = teamRepository.getOne(teamId);
            newTeam.setTeamName(team.getTeamName());
            newTeam.setTeamDesc(team.getTeamDesc());
            newTeam.setImgName(file);
            teamRepository.save(newTeam);
            return new Response("Dəyişiklik uğurla yerinə yetirildi", 1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new Response("Xəta", 0);
        }

    }
}
