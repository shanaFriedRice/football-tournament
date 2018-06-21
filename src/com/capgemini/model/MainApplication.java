package com.capgemini.model;

import com.capgemini.model.resources.*;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException {

        //set up 8 teams and create a list for teams
        int teamNumber = 1;
        List<Team> teamListFirstRound = new ArrayList<>();

        //Set up 4 professional teams
        for(int i=1; i<5; i++){
            Team team = new TeamProfessional("Professional Team " + teamNumber,true,"sponsor" );
            teamNumber++;
            teamListFirstRound.add(team);
        }

        //Set up 4 amateur teams
        for(int i=1; i<5; i++){
            Team team = new TeamAmateur("Amateur Team " + teamNumber,false,"drinkbuddy" );
            teamNumber++;
            teamListFirstRound.add(team);
        }

        //Show the whole team list
        System.out.println("The following 8 teams have joined the match! ");
        for (Team item: teamListFirstRound){
            System.out.println(item.getName() + ", with the sponsor type " + item.getSponsorType());
        }

        //Interval for console application
        Thread.sleep(3000);

        //Print a message for starting the match
        System.out.println("The first round matches shall begin!!");
        System.out.println();

        //Interval for console application
        Thread.sleep(3000);

        //Calculate the matches results in the second round
        Competition competition = new Competition();
        for (int i=0; i<7; i += 2) {
            int k = i+1;
            System.out.println("The match between " + teamListFirstRound.get(i).getName() + " and " +
                    teamListFirstRound.get(k).getName() + " starts!!");
            competition.calculateMatchResult(teamListFirstRound.get(i), teamListFirstRound.get(k));
            System.out.println();
            if (i < 6) {
                //Interval for console application
                Thread.sleep(2000);
            }
        }

        //Add teams who won the first round to a teamListSecondRound list.
        List<Team> teamListSecondRound = new ArrayList<>();
        for (Team item: teamListFirstRound){
            boolean hasLost = item.isHasLost();
            if (hasLost == false){
                teamListSecondRound.add(item);
            }
        }

        //Second round starts
        System.out.println("The second round matches shall begin!!");
        System.out.println("These teams are joining the second round :");
        for (Team item: teamListSecondRound){
            System.out.println(item.getName());
        }
        System.out.println();

        //Calculate the matches results in the second round
        for (int i=0; i<4; i += 2) {
            int k = i+1;
            System.out.println("The match between " + teamListSecondRound.get(i).getName() + " and " +
                    teamListSecondRound.get(k).getName() + " starts!!");
            competition.calculateMatchResult(teamListSecondRound.get(i), teamListSecondRound.get(k));
            System.out.println();
            if (i < 3) {
                //Interval for console application
                Thread.sleep(2000);

            }
        }

        //Add teams who won the second round to teamListThirdRound List.
        List<Team> teamListThirdRound = new ArrayList<>();
        for (Team item: teamListSecondRound){
            boolean hasLost = item.isHasLost();
            if (hasLost == false){
                teamListThirdRound.add(item);
            }
        }

        //Second round starts
        System.out.println("The final round match shall begin!!");
        System.out.println("These teams are joining the final round :");
        for (Team item: teamListThirdRound){
            System.out.println(item.getName());
        }
        System.out.println();

        //Calculate the matches results in the first round
        for (int i=0; i<2; i += 2) {
            int k = i+1;
            System.out.println("The match between " + teamListThirdRound.get(i).getName() + " and "
                    + teamListThirdRound.get(k).getName() + " starts!!");
            competition.calculateMatchResult(teamListThirdRound.get(i), teamListThirdRound.get(k));
            System.out.println();

            if (teamListThirdRound.get(i).isHasLost() != true) {
                System.out.println(teamListThirdRound.get(i).getName() + " has won in the final round! They're " +
                        "now hosting a party sponsored by their " + teamListThirdRound.get(i).getSponsorType() + ". ");
            } else {
                System.out.println(teamListThirdRound.get(k).getName() + " has won in the final round! They're " +
                        "now hosting a party sponsored by their " + teamListThirdRound.get(k).getSponsorType() + ". ");
            }
        }

    }
}
