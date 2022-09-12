package Kuhinja;

import java.util.HashMap;

public class Fridge {
    private HashMap<String,WeightedIngredient> weightedIngredients = new HashMap<String,WeightedIngredient>();
    public void addIngredient(WeightedIngredient w)
    {
        if(weightedIngredients.containsKey(w.articleName))
        {
            weightedIngredients.get(w.articleName).addWeight(w.getWeight());
        }
        else
        {
            weightedIngredients.put(w.articleName,w);
        }
    }

    public boolean canYouMakeAMeal(Recipe recipe)
    {
        for (WeightedIngredient ingredient : recipe.getWeightedIngredients())
        {
            if(!weightedIngredients.containsKey(ingredient.articleName)) { return false; }
            if(weightedIngredients.get(ingredient.articleName).getWeight() < ingredient.getWeight())
            {
                return false;
            }
        }

        return true;
    }
    public boolean makeAMeal(Recipe recipe)
    {
        if(!canYouMakeAMeal(recipe)) return false;
        for (WeightedIngredient ingredient : recipe.getWeightedIngredients())
        {
            weightedIngredients.get(ingredient.articleName).subtractWeight(ingredient.getWeight());
        }
        return true;
    }

    public HashMap<String, WeightedIngredient> getWeightedIngredients() {
        return weightedIngredients;
    }
    public void removeIngredient(WeightedIngredient w)
    {
        if(weightedIngredients.containsKey(w.articleName))
        {
            weightedIngredients.remove(w.articleName);
        }
    }
    public void lowerWeightOfIngredient(double weight,String articleName)
    {
        if(weightedIngredients.containsKey(articleName))
        {
            weightedIngredients.get(articleName).subtractWeight(weight);
        }
        if(weightedIngredients.get(articleName).getWeight() == 0)
        {
            weightedIngredients.remove(articleName);
        }
    }
}
