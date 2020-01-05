package com.example.mymobileass.ui.quiz;

public class QuizVar {
    public static int yourScore;

    public static Integer getScore(){
        return yourScore;
    }

    public static void incYourScore(int i){
        yourScore +=i;
    }

    public static void setYourScore(int i){
        yourScore = i;
    }
}
