package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.ui.main.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.ui.main.data.local.SharedPreferencesFavorites;
import com.sqisland.tutorial.recipes.ui.main.data.model.Recipe;

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        final SharedPreferencesFavorites favorites = new SharedPreferencesFavorites(this);
        boolean favorite = favorites.get(recipe.id);

        titleView.setText(recipe.title);
        titleView.setSelected(favorite);
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean result = favorites.toggle(recipe.id);
                titleView.setSelected(result);
            }
        });
        descriptionView.setText(recipe.description);

    }
}
