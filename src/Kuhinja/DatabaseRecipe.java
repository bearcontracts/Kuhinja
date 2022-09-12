package Kuhinja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DatabaseRecipe {
    private static DatabaseRecipe dbObject;
    private HashMap<String,Recipe> recipes;
    private DatabaseRecipe() {
        var ingredients = DatabaseWeightedIngredient.getInstance().getWeightedIngredients();
        recipes = new HashMap<String,Recipe>();

        Recipe recipe1 = new Recipe("kajgana", Recipe.Difficulty.EASY);
        recipe1.addIngredient(ingredients.get("jaje").clone(200));
        recipes.put("kajgana",recipe1);

        Recipe recipe2 = new Recipe("palacinke", Recipe.Difficulty.MEDIUM);
        recipe2.addIngredient(ingredients.get("jaje").clone(300));
        recipe2.addIngredient(ingredients.get("brasno"));
        recipe2.addIngredient(ingredients.get("mleko").clone(300));
        recipes.put("palacinke", recipe2);

        Recipe recipe3 = new Recipe("punjene paprike", Recipe.Difficulty.HARD);
        recipe3.addIngredient(ingredients.get("paprika").clone(800));
        recipe3.addIngredient(ingredients.get("meso"));
        recipes.put("punjene paprike", recipe3);

        Recipe recipe4 = new Recipe("sopska salata", Recipe.Difficulty.EASY);
        recipe4.addIngredient(ingredients.get("paradajz").clone(500));
        recipe4.addIngredient(ingredients.get("luk").clone(300));
        recipe4.addIngredient(ingredients.get("sir"));
        recipe4.addIngredient(ingredients.get("ulje"));
        recipes.put("sopska salata", recipe4);

        Recipe recipe5 = new Recipe("punjene tikvice", Recipe.Difficulty.HARD);
        recipe5.addIngredient(ingredients.get("tikvice").clone(800));
        recipe5.addIngredient(ingredients.get("meso"));
        recipes.put("punjene tikvice", recipe5);

        Recipe recipe6 = new Recipe("pilav", Recipe.Difficulty.HARD);
        recipe6.addIngredient(ingredients.get("pirinac"));
        recipe6.addIngredient(ingredients.get("meso"));
        recipe6.addIngredient(ingredients.get("luk").clone(500));
        recipe6.addIngredient(ingredients.get("ulje"));
        recipes.put("pilav", recipe6);

        Recipe recipe7 = new Recipe("becarac", Recipe.Difficulty.PRO);
        recipe7.addIngredient(ingredients.get("paprika").clone(200));
        recipe7.addIngredient(ingredients.get("paradajz").clone(500));
        recipe7.addIngredient(ingredients.get("luk").clone(500));
        recipe7.addIngredient(ingredients.get("ulje").clone(500));
        recipes.put("becarac", recipe7);

        Recipe recipe8 = new Recipe("pita sa sirom", Recipe.Difficulty.MEDIUM);
        recipe8.addIngredient(ingredients.get("kore"));
        recipe8.addIngredient(ingredients.get("sir"));
        recipes.put("pita sa sirom", recipe8);

        Recipe recipe9 = new Recipe("pita sa mesom", Recipe.Difficulty.MEDIUM);
        recipe9.addIngredient(ingredients.get("kore"));
        recipe9.addIngredient(ingredients.get("meso"));
        recipes.put("pita sa mesom", recipe9);

        Recipe recipe10 = new Recipe("musaka", Recipe.Difficulty.HARD);
        recipe10.addIngredient(ingredients.get("krompir").clone(800));
        recipe10.addIngredient(ingredients.get("meso"));
        recipes.put("musaka", recipe10);

    }
    public ArrayList<Recipe> AccendingDifficulty()
    {
        var list = new ArrayList<Recipe>();
        for(var recipe : recipes.values())
        {
            if(recipe.difficulty == Recipe.Difficulty.BEGINNER) list.add(recipe);
        }
        for(var recipe : recipes.values())
        {
            if(recipe.difficulty == Recipe.Difficulty.EASY) list.add(recipe);
        }
        for(var recipe : recipes.values())
        {
            if(recipe.difficulty == Recipe.Difficulty.MEDIUM) list.add(recipe);
        }
        for(var recipe : recipes.values())
        {
            if(recipe.difficulty == Recipe.Difficulty.HARD) list.add(recipe);
        }
        for(var recipe : recipes.values())
        {
            if(recipe.difficulty == Recipe.Difficulty.PRO) list.add(recipe);
        }
        return list;
    }
    public ArrayList<Recipe> DescendingDifficulty()
    {
        var list1 = AccendingDifficulty();
        Collections.reverse(list1);
        return list1;
    }

    public ArrayList<Recipe> DescendingPrice()
    {
        ArrayList<Recipe> list=new ArrayList<Recipe>();
        list.addAll(recipes.values());
        for(int i =0;i< list.size()-1;i++){
            for(int j =i+1;j< list.size();j++){
                if(list.get(j).getPrice()>list.get(i).getPrice()){
                    Collections.swap(list,i, j);
                }
            }
        }
        return list;
    }
    public ArrayList<Recipe> AccendingPrice()
    {
        ArrayList<Recipe> list=new ArrayList<Recipe>();
        list.addAll(recipes.values());
        for(int i =0;i< list.size()-1;i++){
            for(int j =i+1;j< list.size();j++){
                if(list.get(j).getPrice()<list.get(i).getPrice()){
                    Collections.swap(list,i, j);
                }
            }
        }
        return list;
    }

    public static DatabaseRecipe getInstance() {

        if(dbObject == null) {
            dbObject = new DatabaseRecipe();
        }

        return dbObject;
    }

    public HashMap<String,Recipe> getRecipes() {
        return recipes;
    }
}