package model;

public class Bot {

    private Context ctx;
    private final KeywordMap map;
    private boolean wasFinal;

    public Bot() {
        ctx = Context.GREET;
        map = new KeywordMap();
        wasFinal = false;
    }

    public String getResponseFor(String input) {
        String[] words = input.split("\\W");
        for (String word : words) {
            if (ctx.hasKeyword(word.toLowerCase())) {
                return getAnswer(ctx);
            }
        }


        for (String word : words) {
            Context newContext = map.getContextFor(word);
            if (newContext != null) {
                return getAnswer(newContext);
            }
        }

        return Response.UNKNOWN.random();
    }

    private String getAnswer(Context ctx) {
        if (ctx.equals(Context.FAREWELL)) wasFinal = true;
        this.ctx = ctx.getNext();
        return ctx.getResponse();
    }

    public boolean wasFinal() {
        return wasFinal;
    }
}