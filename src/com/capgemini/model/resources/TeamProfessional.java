package com.capgemini.model.resources;

import com.capgemini.model.resources.Team;

public class TeamProfessional extends Team {
    public TeamProfessional(String name, boolean isProfessional, String sponsorType) {

        //Override the constructor being called by Team
        super(name, true, sponsorType);
    }
}
