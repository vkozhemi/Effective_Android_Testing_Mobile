package com.sqisland.tutorial.recipes.injection;

import com.sqisland.tutorial.recipes.RecipeApplication;
import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;

public class TestRecipeApplication extends RecipeApplication {
    private final Favorites favorites = new InMemoryFavorites();
    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
