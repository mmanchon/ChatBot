package model;

import java.util.Random;

public enum  Response {

    SALUTE("Hello! What is the problem?", "Hi, how may I assist you?"),
    PROBLEM_ASSIST("Okey, can you describe which problem do you have?", "You have come to the right place! Tell me what happens","Which computer brand do you have?"),
    BYE("See you later!", "Bye bye!", "Let me know if you need anything else"),
    UNKNOWN("Sorry, I didn't understand what you said.", "I can't understand this.", "I don't know what you mean.", "Try explaining it with other words please."),
    APPLE("What is the problem with your MAC?","You can't play videogames?","Is too expensive?"),
    FREE_SOFTWARE("Let me check what stackoverflow says","Maybe you need a tutorial to learn how to use it :)"),
    WINDOWS_RESPONSE("have you tried restarting it?"),
    PATIENT("Yes, please give me a moment!"),
    RAM_SOLUTIONS("Sometimes RAMS can be messy, check if it isn't burned","If you put it to the limit"),
    SCREEN_SOLUTIONS("Try opening the keyboard and make sure all the connections are fine"),
    BATTERY_SOLUTIONS("Try to unplug it until it's uncharged","Change the adapter"),
    MEMORY_SOLUTIONS("Extract it and try to connect it via adapter"),
    KEYBOARD_SOLUTIONS("Probabli the connection with the mother board isn't well"),
    MOUSE_SOLUTIONS("If it works via USB try to plug it in other port, if not change batteries");

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
