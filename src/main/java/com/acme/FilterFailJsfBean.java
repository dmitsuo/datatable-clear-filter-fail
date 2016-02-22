/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 * @author 002824992500
 */
@ManagedBean
@ViewScoped
public class FilterFailJsfBean implements Serializable {
    private List<Player> players;
    private List<Player> filteredPlayers;
    private int timesFired;

    public FilterFailJsfBean() {
    }
    
    @PostConstruct
    public void init() {
        timesFired = 0;
        players = new ArrayList<Player>();
        players.add(new Player(1, "Zico", "Brazil"));
        players.add(new Player(2, "Pelé", "Brazil"));
        players.add(new Player(3, "Garrincha", "Brazil"));
        players.add(new Player(4, "Romário", "Brazil"));
        players.add(new Player(5, "Ronaldo", "Brazil"));
        players.add(new Player(6, "Alex", "Brazil"));
        players.add(new Player(7, "Ronaldinho", "Brazil"));        
        players.add(new Player(8, "Maradona", "Argentina"));
        players.add(new Player(9, "Zidane", "France"));
        players.add(new Player(10, "Messi", "Argentina"));
    }

    public List<Player> getFilteredPlayers() {
        return filteredPlayers;
    }

    public void setFilteredPlayers(List<Player> filteredPlayers) {
        this.filteredPlayers = filteredPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public void clearFilters() {
        timesFired = timesFired + 1;
        
        // Try to clear the datatable filters
        this.filteredPlayers = null;
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(String.format("Clear filters button fired %s time(s)!", timesFired)));
    }    
}
