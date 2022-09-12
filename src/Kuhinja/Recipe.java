package Kuhinja;

import java.util.ArrayList;

public class Recipe  implements Priceable
{
    private String name;

    public enum Difficulty {BEGINNER, EASY, MEDIUM, HARD, PRO}
    Difficulty difficulty;
    private ArrayList<WeightedIngredient> weightedIngredients = new ArrayList<WeightedIngredient>();

    public Recipe() {}

    public Recipe(String name_,Difficulty difficulty_)
    {
        name = name_;
        difficulty = difficulty_;
    }

    public void addIngredient(WeightedIngredient w)
    {
        if(!weightedIngredients.contains(w))
        {
            weightedIngredients.add(w);
        }
    }
    public void removeIngredient(WeightedIngredient w)
    {
            weightedIngredients.remove(w);
    }
    @Override
    public double getPrice()
    {
        double Price = 0;
        for (WeightedIngredient ingredient : weightedIngredients)
        {
            Price += ingredient.getPrice();
        }
        return  Price;
    }
    public Recipe getScaledRecipe(double percentage)
    {
        Recipe recipe = new Recipe();
        recipe.name = this.name;
        recipe.difficulty = this.difficulty;
        for (WeightedIngredient ingredient : weightedIngredients)
        {
            recipe.weightedIngredients.add(ingredient.clone(percentage));
        }
        return recipe;
    }
    public ArrayList<WeightedIngredient> getWeightedIngredients()
    {
        return weightedIngredients;
    }

    void print()
    {
        System.out.println("Ime recepta " + name);
        System.out.println("Tezina recepta: " + difficulty);
    }

    public char getDifficulty() {
        if(difficulty == Difficulty.BEGINNER) return 'b';
        if(difficulty == Difficulty.EASY) return 'e';
        if(difficulty == Difficulty.MEDIUM) return 'm';
        if(difficulty == Difficulty.HARD) return 'h';
        if(difficulty == Difficulty.PRO) return 'p';
        return '0';
    }
}