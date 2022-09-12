package Kuhinja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int selectedItem = 10;
        Fridge fridge = new Fridge();
        ArrayList<Recipe> favouriteRecipes = new ArrayList<Recipe>();
        while (selectedItem != 0) {
            Scanner scInt = new Scanner(System.in);
            Scanner scString = new Scanner(System.in);
            Scanner scDouble = new Scanner(System.in);
            Scanner scChar = new Scanner(System.in);
            System.out.print("1: Dodajte namirnicu u frizider \n");
            System.out.print("2: Smanjite kolicinu namirnice u frizideru \n");
            System.out.print("3: Izbrisite namirnicu iz frizidera \n");
            System.out.print("4: Koja sve jela mogu da se naprave sa namirnicama iz frizidera \n");
            System.out.print("5: Koja sve jela mogu da se naprave(Skalirana za 50%) \n");
            System.out.print("6: Napravi sva moguca jela \n");
            System.out.print("7: Napravi sva moguca jela skalirana za 50% \n");
            System.out.print("8: Koja sve jela mogu da se naprave za X dinara \n");
            System.out.print("9: Provera koja su sve jela X tezine \n");
            System.out.print("10: Kombinacija uslova 8 i 9 \n");
            System.out.print("11: Sortiraj recepte po tezini \n");
            System.out.print("12: Sortiraj recepte po ceni \n");

            System.out.print("13: Omiljeni recepti meni \n");

            System.out.print("0: Za kraj aplikacije \n");


            selectedItem = scInt.nextInt();
            if (selectedItem == 1) {
                var ingredients = DatabaseWeightedIngredient.getInstance().getWeightedIngredients();
                System.out.print("Unesite ime namirnice \n");
                String s = scString.nextLine();
                System.out.print("Unesite koliko hocete kolicina namirnice \n");
                double percentage = scDouble.nextDouble() * 100;
                if (ingredients.containsKey(s)) {
                    fridge.addIngredient(ingredients.get(s).clone(percentage));
                    System.out.println("Namirnica " + s + " je uspesno dodata");
                }
            }
            if (selectedItem == 2) {
                var ingredients = DatabaseWeightedIngredient.getInstance().getWeightedIngredients();
                System.out.print("Unesite ime namirnice ciju kolicinu hocete da smanjite \n");
                String s = scString.nextLine();
                System.out.print("Unesite tezinu za koliko hocete da smanjite namirnicu \n");
                double weight = scDouble.nextDouble();
                if (ingredients.containsKey(s) && fridge.getWeightedIngredients().containsKey(s)) {
                    fridge.lowerWeightOfIngredient(weight, s);
                    System.out.println("Namirnica " + s + " je uspesno smanjila tezinu");
                }
            }
            if (selectedItem == 3) {
                var ingredients = DatabaseWeightedIngredient.getInstance().getWeightedIngredients();
                System.out.print("Unesite ime namirnice koje hocete da obrisete iz frizidera \n");
                String s = scString.nextLine();
                if (ingredients.containsKey(s) && fridge.getWeightedIngredients().containsKey(s)) {
                    fridge.removeIngredient(ingredients.get(s));
                    System.out.println("Namirnica " + s + " je uspesno obrisana iz frizidera");
                }
            }
            if (selectedItem == 4) {
                ArrayList<Recipe> possibleRecipes = new ArrayList<Recipe>();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                for (Recipe recipe : recipes.values()) {
                    if (fridge.canYouMakeAMeal(recipe)) {
                        possibleRecipes.add(recipe);
                    }
                }
                if (possibleRecipes.size() > 0) {
                    System.out.println("Lista svih mogucih recepta je: ");
                    for (Recipe recipe : possibleRecipes) {
                        recipe.print();
                    }
                } else {
                    System.out.println("Nema dovoljno sastojaka za nijedan recept");
                }
            }
            if (selectedItem == 5) {
                ArrayList<Recipe> possibleRecipes = new ArrayList<Recipe>();
                ArrayList<Recipe> scaledRecipes = new ArrayList<Recipe>();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                for (Recipe recipe : recipes.values()) {
                    scaledRecipes.add(recipe.getScaledRecipe(50));
                }
                for (Recipe recipe : scaledRecipes) {
                    if (fridge.canYouMakeAMeal(recipe)) {
                        possibleRecipes.add(recipe);
                    }
                }
                if (possibleRecipes.size() > 0) {
                    System.out.println("Lista svih mogucih recepata je: ");
                    for (Recipe recipe : possibleRecipes) {
                        recipe.print();
                    }
                } else {
                    System.out.println("Nema dovoljno sastojaka za nijedan recept");
                }
            }
            if (selectedItem == 6) {
                ArrayList<Recipe> madeMeals = new ArrayList<Recipe>();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                for (Recipe recipe : recipes.values()) {
                    if (fridge.makeAMeal(recipe)) {
                        madeMeals.add(recipe);
                    }
                }
                if (madeMeals.size() > 0) {
                    System.out.println("Napravljena jela su: ");
                    for (Recipe recipe : madeMeals) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 7) {
                ArrayList<Recipe> madeMeals = new ArrayList<Recipe>();
                ArrayList<Recipe> scaledRecipes = new ArrayList<Recipe>();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                for (Recipe recipe : recipes.values()) {
                    scaledRecipes.add(recipe.getScaledRecipe(50));
                }
                for (Recipe recipe : scaledRecipes) {
                    if (fridge.makeAMeal(recipe)) {
                        madeMeals.add(recipe);
                    }
                }
                if (madeMeals.size() > 0) {
                    System.out.println("Napravljena jela su: ");
                    for (Recipe recipe : madeMeals) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 8) {
                System.out.println("Unesite cenu dinara izdvojeno za jela: ");
                double price = scDouble.nextDouble();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                System.out.println("Moguca jela za cenu od " + price + " din");
                for (Recipe recipe : recipes.values()) {
                    if (recipe.getPrice() < price) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 9) {
                System.out.println("Unesite tezinu jela(kao jedan karakter) : b(Beginner) e(Easy) m(Medium) h(Hard) p(Pro) ");
                char c = scChar.next().charAt(0);
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                System.out.println("Jela sa datom tezinom su ");
                for (Recipe recipe : recipes.values()) {
                    if (recipe.getDifficulty() == c) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 10) {
                System.out.println("Unesite tezinu jela(kao jedan karakter) : b(Beginner) e(Easy) m(Medium) h(Hard) p(Pro) ");
                char c = scChar.next().charAt(0);
                System.out.println("Unesite cenu dinara izdvojeno za jela: ");
                double price = scDouble.nextDouble();
                var recipes = DatabaseRecipe.getInstance().getRecipes();
                System.out.println("Jela sa ispunjenim uslovima su ");
                for (Recipe recipe : recipes.values()) {
                    if (recipe.getDifficulty() == c && recipe.getPrice() < price) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 11) {
                System.out.print("Sortiraj recepte po tezini rastuce(r) ili opadajuce(o)? \n");
                char c = scChar.next().charAt(0);
                if (c == 'r') {
                    for (var recipe : DatabaseRecipe.getInstance().AscendingDifficulty()) {
                        recipe.print();
                    }
                }
                if (c == 'o') {
                    for (var recipe : DatabaseRecipe.getInstance().DescendingDifficulty()) {
                        recipe.print();
                    }
                }
            }
            if (selectedItem == 12) {
                System.out.print("Sortiraj recepte po ceni rastuce(r) ili opadajuce(o)? \n");
                char c = scChar.next().charAt(0);
                if (c == 'r') {
                    for (var recipe : DatabaseRecipe.getInstance().AscendingPrice()) {
                        recipe.print();
                    }
                }
                if (c == 'o') {
                    for (var recipe : DatabaseRecipe.getInstance().DescendingPrice()) {
                        recipe.print();
                    }
                }
            }



        if (selectedItem <= 3 || selectedItem == 6 || selectedItem == 7) {
            System.out.println("Namirnice u frizideru ");
            for (var ingredient : fridge.getWeightedIngredients().values()) {
                ingredient.print();
            }
            System.out.println();
        }

        if (selectedItem == 13) {
            System.out.print("\n\n\n\n\n");
            System.out.print("14: Dodajte recept u omiljeni recept \n");
            System.out.print("15: Sklonite recept iz omiljenih recept \n");
            selectedItem = scInt.nextInt();
            if(selectedItem == 14)
            {
                var allRecepies = DatabaseRecipe.getInstance().getRecipes();
                String s = scString.next();
                if (allRecepies.containsKey(s)) {
                    favouriteRecipes.add(allRecepies.get(s));
                    for (var recipe : favouriteRecipes)
                    {
                        recipe.print();
                    }
                }
            }
            if(selectedItem == 15)
            {
                var allRecepies = DatabaseRecipe.getInstance().getRecipes();
                String s = scString.next();
                if (allRecepies.containsKey(s)) {
                    favouriteRecipes.remove(allRecepies.get(s));
                    for (var recipe : favouriteRecipes)
                    {
                        recipe.print();
                    }
                }
            }


        }
            if(selectedItem==0)
            {
                break;
            }
        }
    }

}











