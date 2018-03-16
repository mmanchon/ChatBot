package model;

import java.util.HashMap;

public class KeywordMap {

    private HashMap<String,Context> hm;

    public KeywordMap() {
        hm = new HashMap<>();
        for (Context ctx : Context.values()) {
            for (String str : ctx.getKeywords()) {
                hm.put(str, ctx);
            }
        }
    }

    public Context getContextFor(String keyword) {
        return hm.get(keyword);
    }
}
