package com.example.joketeller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {


    //Array that holds the Jokes
    private static List<String> jokes = Arrays.asList(
            "Why did the chicken cross the road?\nTo get to the other side.",
            "My dog use to chase people on a bike alot,\nit got so bad I had to take " +
                    "the bike away.",
            "Why are frogs so happy? \nThey eat whatever bugs them.",
            "Why was the baby ant confused?\nBecause all his uncles where ants.",
            "What is smarter than a talking cat? \nA spelling bee.",
            "What did the grape say when the buffalo stand on it?\nNothing it just let out a" +
                    "little wine.");

    //Displays a random joke.
    public static void main(String[] args){


        String joke = jokes.get(getRandom());

        System.out.println(joke);
    }

    public String getJoke(){
        return jokes.get(getRandom());
    }
    private static int getRandom(){
        Random random = new Random();
        return random.nextInt(jokes.size()) + 1;
    }

}
