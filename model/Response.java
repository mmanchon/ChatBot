package model;

import java.util.Random;

public enum  Response {

    SALUTE("Hello! What is the problem?", "Hi, how may I assist you?"),
    PROBLEM_ASSIST("Okey, can you describe which problem do you have?", "You have come to the right place! Tell me what happens.","Which computer brand do you have?"),
    BYE("See you later!", "Bye bye!", "Let me know if you need anything else"),
    UNKNOWN("Sorry, I didn't understand what you said.", "I can't understand this.", "I don't know what you mean.", "Try explaining it with other words please."),
    APPLE("What is the problem with your Mac?","You can't play videogames?","Is too expensive?"),
    FREE_SOFTWARE("Let me check what StackOverflow says.","Maybe you need a tutorial to learn how to use it :)"),
    WINDOWS_RESPONSE("Have you tried restarting it?"),
    PATIENT("Yes, please give me a moment!", "Please wait patiently!", "I'm working on it!", "One second please!"),
    RAM_SOLUTIONS("Sometimes RAMs can be messy, check if it isn't burned.","If you put it to the limit"),
    SCREEN_SOLUTIONS("Try opening the keyboard and make sure all the connections are fine.", "Have it changed if it's broken."),
    BATTERY_SOLUTIONS("Try to plug it until it's charged", "Change the charger adapter.", "Try using GNU/Linux instead."),
    MEMORY_SOLUTIONS("Extract it and try to connect it via adapter."),
    KEYBOARD_SOLUTIONS("Probably the connection with the motherboard isn't well."),
    ACCEPTANCE("Okey, let me know if it works!"),
    PRESPONSE("Great! Im good at my job :)"),
    NRESPONSE("Humm... tell me again what is the problem and let me see if something comes to my mind"),
    THANKS("You're Welcome!","I am here to help!"),
    MOUSE_SOLUTIONS("If it works via USB try to plug it in other port, if not, change the batteries.");

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
