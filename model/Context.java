package model;

import static model.Response.*;

public enum Context {

    FAREWELL(null, BYE, new KeywordSet("bye", "farewell", "goodbye","Thank", "thank", "Thanks", "thanks")),
    KEYBOARD_PROBLEMS(FAREWELL, KEYBOARD_SOLUTIONS, new KeywordSet("keyboard", "Keyboard")),
    MOUSE_PROBLEMS(FAREWELL, MOUSE_SOLUTIONS, new KeywordSet("Mouse", "mouse")),
    BATTERY_SOLUTION(FAREWELL, BATTERY_SOLUTIONS , new KeywordSet("battery","turn","on","off")),
    RAM_PROBLEMS(FAREWELL,RAM_SOLUTIONS,new KeywordSet("RAM", "ram")),
    ACCPET(FAREWELL,ACCEPTANCE,new KeywordSet("Okey", "okey","Perfect", "perfect")),
    P_RESPONSE(FAREWELL, PRESPONSE, new KeywordSet("yes","Yes")),
    N_RESPONSE(FAREWELL,NRESPONSE, new KeywordSet("no","No")),
    GRATIUDE(FAREWELL, THANKS, new KeywordSet("thanks", "thank")),
    SCREEN_PROBLEMS(FAREWELL, SCREEN_SOLUTIONS, new KeywordSet("screen", "Screen")),
    MEMORY_PROBLEMS(FAREWELL, MEMORY_SOLUTIONS, new KeywordSet("HDD", "SDD","disc","memory")),
    INTERNAL_COMPUTER(BATTERY_SOLUTION,null,new KeywordSet()),
    MAC(INTERNAL_COMPUTER, APPLE, new KeywordSet("mac", "iphone", "apple")),
    WINDOWS(INTERNAL_COMPUTER, WINDOWS_RESPONSE, new KeywordSet("windows","acer","dell")),
    LINUX(INTERNAL_COMPUTER, FREE_SOFTWARE, new KeywordSet("linux","server","connection")),
    IMPATIENT(INTERNAL_COMPUTER, PATIENT, new KeywordSet("done","ready")),
    PROBLEM(INTERNAL_COMPUTER, PROBLEM_ASSIST, new KeywordSet("problem","problems", "software", "fails","fail", "crash","crashes", "not", "work", "help")),
    GREET(PROBLEM, SALUTE, new KeywordSet("hello", "hi", "welcome", "greetings"));

    private KeywordSet keywords;
    private Response response;
    private Context next;

    Context(Context next, Response response, KeywordSet keywords) {
        this.response = response;
        this.next = next;
        this.keywords = keywords;
    }

    public Context getNext() {
        return next;
    }

    public boolean hasKeyword(String word) {
        return keywords.contains(word);
    }

    public KeywordSet getKeywords() {
        return keywords;
    }

    public String getResponse() {
        return response.random();
    }
}
