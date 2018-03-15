package model;

import static model.Response.*;

public enum Context {

    FAREWELL(null, BYE, "bye", "farewell", "goodbye"), //el siguiente contexto no existe
    //PROBLEM(FAREWELL, PROBLEM_ASSIST, "problem", "doesn't", "fail", "crash"),
    //GREET(PROBLEM, SALUTE, "hello", "hi", "welcome", "greetings");
    GREET(FAREWELL, SALUTE, "hello", "hi", "welcome", "greetings");

    private String[] keywords;
    private Response response;
    private Context next;

    Context(Context next, Response response, String... keywords) {
        this.response = response;
        this.next = next;
        this.keywords = keywords;
    }

    public Context getNext() {
        return next;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getResponse() {
        return response.random();
    }
}
