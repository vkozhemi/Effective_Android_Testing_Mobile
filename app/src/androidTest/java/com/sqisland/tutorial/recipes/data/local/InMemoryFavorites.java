package com.sqisland.tutorial.recipes.data.local;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavorites implements Favorites {
    private final Map<String, Boolean> map = new HashMap<>();

    @Override
    public boolean get(String id) {
        Boolean value = map.get(id);
        return value != null;
    }

    @Override
    public boolean toggle(String id) {
        boolean value = get(id);
        map.put(id, !value);
        return !value;
    }

    public void put(String id, boolean value) {
        map.put(id, value);
    }

    public void clear() {
        map.clear();
    }
}
