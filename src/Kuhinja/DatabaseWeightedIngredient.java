package Kuhinja;

import java.util.HashMap;

public class DatabaseWeightedIngredient {
    private static DatabaseWeightedIngredient dbObject;

    private HashMap<String,WeightedIngredient> WeightedIngredients;



    private DatabaseWeightedIngredient()
    {
        WeightedIngredients = new HashMap<String,WeightedIngredient>();

        WeightedIngredient w1 = new WeightedIngredient(1,"jaje",1,5);
        WeightedIngredient w2 = new WeightedIngredient(2,"brasno",10,3);
        WeightedIngredient w3 = new WeightedIngredient(3,"mleko",7,10);
        WeightedIngredient w4 = new WeightedIngredient(4,"paprika",3,5);
        WeightedIngredient w5 = new WeightedIngredient(5, "meso",15,20);
        WeightedIngredient w6 = new WeightedIngredient(6, "pirinac",7,10);
        WeightedIngredient w7 = new WeightedIngredient(7, "krompir",5,12);
        WeightedIngredient w8 = new WeightedIngredient(8, "tikvice",5,14);
        WeightedIngredient w9 = new WeightedIngredient(9, "paradajz",5,8);
        WeightedIngredient w10 = new WeightedIngredient(10, "luk",14,4);
        WeightedIngredient w11 = new WeightedIngredient(11, "sir",8,15);
        WeightedIngredient w12= new WeightedIngredient(12, "ulje",7,6);
        WeightedIngredient w13= new WeightedIngredient(13, "so",2,5);
        WeightedIngredient w14= new WeightedIngredient(14, "biber",2,5);
        WeightedIngredient w15= new WeightedIngredient(15, "kore",7,9);
        WeightedIngredients.put("jaje",w1);
        WeightedIngredients.put("brasno",w2);
        WeightedIngredients.put("mleko",w3);
        WeightedIngredients.put("paprika",w4);
        WeightedIngredients.put("meso",w5);
        WeightedIngredients.put("pirinac",w6);
        WeightedIngredients.put("krompir",w7);
        WeightedIngredients.put("tikvice",w8);
        WeightedIngredients.put("paradajz",w9);
        WeightedIngredients.put("luk",w10);
        WeightedIngredients.put("sir",w11);
        WeightedIngredients.put("ulje",w12);
        WeightedIngredients.put("so",w13);
        WeightedIngredients.put("biber",w14);
        WeightedIngredients.put("kore",w15);
    }
    public HashMap<String,WeightedIngredient> getWeightedIngredients()
    {
        var WeightedIngredientsCopiedList = new HashMap<String,WeightedIngredient>();

        for (HashMap.Entry<String,WeightedIngredient> entry : WeightedIngredients.entrySet())
        {
            WeightedIngredientsCopiedList.put(entry.getKey(),entry.getValue().clone(100));
        }
        return WeightedIngredientsCopiedList;
    };
    public static DatabaseWeightedIngredient getInstance() {


        if(dbObject == null) {
            dbObject = new DatabaseWeightedIngredient();
        }


        return dbObject;
    }

    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}