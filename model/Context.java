package model;

import static model.Response.*;

public enum Context {

    FAREWELL(null, BYE, new KeywordSet("bye", "farewell", "goodbye")),
    PROBLEM(FAREWELL, PROBLEM_ASSIST, new KeywordSet("problem", "doesn't", "fail", "crash", "not", "work", "")),
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
