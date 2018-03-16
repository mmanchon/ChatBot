package model;

import java.util.Arrays;
import java.util.HashSet;

public class KeywordSet extends HashSet<String> {

    public KeywordSet(String... keywords) {
        addAll(Arrays.asList(keywords));
    }
}
