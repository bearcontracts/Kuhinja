package Kuhinja;

public abstract class Ingredient implements Priceable
{
    protected int id;
    protected String articleName;

    public String getArticleName() { return this.articleName; }
    public void setName(String name) { this.articleName = name; }



}
