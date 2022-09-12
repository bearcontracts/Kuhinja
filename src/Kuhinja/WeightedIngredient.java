package Kuhinja;

public class WeightedIngredient extends Ingredient
{
    private double weight;
    private double pricePerUnit;

    public WeightedIngredient(int id_,String articleName_, double weight_, double pricePreUnit_ )
    {
        id = id_;
        articleName = articleName_;
        weight = weight_;
        pricePerUnit = pricePreUnit_;
    }
    public WeightedIngredient() { }
    @Override
    public double getPrice()
    {
        return weight*pricePerUnit;
    }
    public double getWeight()
    {
        return weight;
    }
    public void setWeight(double d)
    {
        weight = d;
    }
    public WeightedIngredient addWeight(double d)
    {
        weight += d;
        return this;
    }
    public WeightedIngredient subtractWeight(double d)
    {
        weight -= d;
        return this;
    }
    WeightedIngredient clone(double percentage)
    {
        WeightedIngredient w = new WeightedIngredient();
        w.weight = this.weight* percentage / 100;
        w.pricePerUnit = this.pricePerUnit;
        w.id = this.id;
        w.articleName = this.articleName;
        return w;
    }
    void print()
    {
        System.out.println("Ime namirnice " + articleName);
        System.out.println("Tezina namirnice: " +weight);
        System.out.println("Price per Unit: " + pricePerUnit);
    }
}
