# Kuhinja
Project that allows user to select various ingredients and make their favourite meals.
In this project I used everything that I learned about Object Oriented Programming.
Overview of classes and desired functionality of the application
Any additional classes or functionality are allowed and preferred
0. Priceable interface
double getPrice
1. Ingredient (abstract) implements Priceable
id
The name of the ingredient
2. WeightedIngredient extends Ingredient
double weight
double pricePerUnit
getPrice() -> weight * pricePerUnit
3. Recipe implements Priceable
The name of the recipe
Recipe difficulty (Enum: BEGINNER, EASY, MEDIUM, HARD, PRO)
WeightedIngredient collection
getPrice() - Total price of the recipe
Methods for adding and deleting ingredients
A method that creates a new recipe with X% ingredients
If we want half the recipe: getScaledRecipe(50.0)
Returns a new recipe where the weight of each ingredient is scaled by 50%
If we want a third of the recipe: getScaledRecipe(33.333)
For example, if we had 6 eggs in the recipe, there will be 2 in the new one (2.xxxx)
4. Fridge
WeightedIngredient collection
Methods that add and delete items
Hint: If the food item exists, add the quantity
A method that checks whether a dish can be made
Hint: Take into account the amount of food
The method that "makes" the dish, ie reduces the amount of ingredients
Hint: Check if it is even possible to make a dish
IT Bootcamp 9/2/2022
5. Make a "base" of all possible ingredients
At least 15 starters
6. Create a "base" of all recipes
At least 10 starters
The application below should be as interactive as possible, and offer the user options based on a "menu", where the user selects option 1,2,3,... and
can go back to the beginning
Note: Both the menu and its items can be created through classes (they don't have to)
7. Create an application that allows the user the following:
1. Adding food to the fridge (if it already exists, the quantity changes)
2. Deleting food from the refrigerator
Reduction in quantity
Complete deletion
3. Checking that she can make all the dishes with the food from the refrigerator
4. Checking what all scaled dishes can make (scaling by 50%)
5. Cooking (as above)
6. Checking that all dishes can be made for X dinars
7. Checking that all dishes are of X recipe weight
8. Combination of conditions 6 and 7
9. User can sort recipes by weight
10. The user can sort recipes by price
8. Add the possibility for the user to choose "favorite" recipes
User can view favorite recipes
User can add or delete favorite recipes
The user can view favorite recipes up to X dinars
