package com.capgemini.model.resources;

public class Competition {

    private int scoreForFirstTeam;
    private int scoreForSecondTeam;
    private double randomDoubleNumberFirstTeam;
    private double randomDoubleNumberSecondTeam;

    //Calculate match result of 2 teams and print the result.
    public void calculateMatchResult(Team firstTeam, Team secondTeam) throws InterruptedException {
        do {
            randomDoubleNumberFirstTeam = Math.random() * 5;
            scoreForFirstTeam = (int) Math.round(randomDoubleNumberFirstTeam);
            firstTeam.setScore(scoreForFirstTeam);

            randomDoubleNumberSecondTeam = Math.random() * 5;
            scoreForSecondTeam = (int) Math.round(randomDoubleNumberSecondTeam);
            secondTeam.setScore(scoreForSecondTeam);

            if(scoreForFirstTeam == scoreForSecondTeam) {
                System.out.println("Oops, " + firstTeam.getName() + " and "
                        + secondTeam.getName() +" have a draw and they both scored " + scoreForFirstTeam +
                        ". They are going to have another match...");

                Thread.sleep(3000);
            }else if (scoreForFirstTeam > scoreForSecondTeam) {
                secondTeam.setHasLost(true);
                System.out.println(firstTeam.getName() + " scored " + firstTeam.getScore() + " and "
                        + secondTeam.getName() + " scored " + secondTeam.getScore() +
                        ". " + firstTeam.getName() + " has won!");
            }else if (scoreForFirstTeam < scoreForSecondTeam) {
                firstTeam.setHasLost(true);
                System.out.println(firstTeam.getName() + " scored " + firstTeam.getScore() + " and "
                        + secondTeam.getName() + " scored " + secondTeam.getScore() +
                        ". " + secondTeam.getName() + " has won!");
            }
        } while (scoreForFirstTeam == scoreForSecondTeam);
    }
}
