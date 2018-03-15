package model;

public class Bot {

    private Context ctx;
    private boolean wasFinal;

    public Bot() {
        ctx = Context.GREET;
        wasFinal = false;
    }

    public String getResponseFor(String input) {
        String[] words = input.split("\\W");
        for (String word : words) {
            for (String keyword : ctx.getKeywords()) {
                if (word.compareToIgnoreCase(keyword) == 0) {
                    return getAnswer(ctx);
                }
            }
        }

        for (Context ctx : Context.values()) {
            for (String word : words) {
                for (String keyword : ctx.getKeywords()) {
                    if (word.compareToIgnoreCase(keyword) == 0) {
                        return getAnswer(ctx);
                    }
                }
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