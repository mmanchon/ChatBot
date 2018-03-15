package model;

import java.util.Random;

public enum  Response {

    SALUTE("Hello! How are you?", "Hi, how may I assist you?"),
    //PROBLEM_ASSIST("", ""),
    UNKNOWN("Sorry, I didn't understand what you said.", "I can't understand this.", "I don't know what you mean."),
    BYE("See you later!", "Bye bye!");

    private String[] responses;
    private Random rnd;

    Response(String... responses) {
        this.responses = responses;
        rnd = new Random();
    }

    public String random() {
        return responses[rnd.nextInt(responses.length)];
    }
}
