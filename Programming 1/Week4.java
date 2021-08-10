import java.util.Scanner;

public class Week4 {
    public static void main(String[] args) {
        Ingredients ing = new Ingredients("tomato", "kg");
        ing.display();

        Ingredients[] ingredients = input();
        displayIngredient(ingredients);

        Recipe[] recipes = listRecipe();
        displayRecipes(recipes);
    }

    // create a method to ask user for ingredient instance
    public static Ingredients[] input() {
        // ask user for name and measurement unit
        System.out.print("\nHow many ingredients: ");
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

        // create an array to store all the ingredients
        Ingredients[] ingredients = new Ingredients[num];

        // create a loop for the array to read the info
        for (int i = 0; i<num; i++) {
            System.out.print("Enter name: ");
            String name = sc.nextLine();


            System.out.print("Enter measurement: ");
            String unit = sc.nextLine();

            ingredients[i] = new Ingredients(name, unit);
        }
        // return array
        return ingredients;
    }

    // create a method to display the array of ingredients
    public static void displayIngredient(Ingredients[] arr) {
        for (Ingredients ingredients : arr) {
            System.out.printf("The name: %s, the measurement: %s\n", ingredients.name, ingredients.getMeasurementUnit());
        }
    }
    public static RecipeComponent createComponent() {
        Scanner input = new Scanner(System.in);
        String name, measurementUnit;
        double amount;
        Ingredients ingredients;
        RecipeComponent component;

        // Get the ingredients
        System.out.print("Enter ingredient name: ");
        name = input.nextLine();

        System.out.print("Enter measurement unit: ");
        measurementUnit = input.nextLine();

        ingredients = new Ingredients(name, measurementUnit);

        // Get the amount
        System.out.print("Enter amount: ");
        amount = Double.parseDouble(input.nextLine());

        component = new RecipeComponent(ingredients, amount);

        return component;
    }

    public static RecipeComponent[] listComponent() {
        // ask for the number of components that user wants to input
        Scanner input = new Scanner(System.in);
        int count;
        RecipeComponent[] components;

        System.out.print("Enter the number of components: ");
        count = Integer.parseInt(input.nextLine());
        components = new RecipeComponent[count];

        for (int i = 0; i<count; i++) {
            components[i] = createComponent();
        }System.out.println();

        return components;
    }

    public static Recipe createRecipes() {
        Scanner input = new Scanner(System.in);
        String name;
        RecipeComponent[] components;
        Recipe recipe;

        System.out.print("Enter the name of recipe: ");
        name = input.nextLine();

        components = listComponent();
        recipe = new Recipe(name, components);

        return recipe;
    }

    public static Recipe[] listRecipe() {
        Scanner input = new Scanner(System.in);
        int count;
        Recipe[] recipes;

        System.out.print("Enter the number of recipes: ");
        count = Integer.parseInt(input.nextLine());

        recipes = new Recipe[count];
        for (int i = 0; i<count; i++) {
            recipes[i] = createRecipes();
        }

        return recipes;
    }

    public static void displayRecipes(Recipe[] recipes) {
        int count = 1;

        for (Recipe r : recipes) {
            System.out.printf("\nRECIPE #%d: ", count);
            r.displayRecipe();
            count++;
        }
    }
}

class Ingredients {
    // data members
    public String name;
    private String measurementUnit;

    // constructor method
    public Ingredients(String name, String measurementUnit) {
       this.name = name;
       setMeasurementUnit(measurementUnit);
    }

    public void display() {
        System.out.printf("\nThe name: %s, the measurement: %s", name, measurementUnit);
    }

    // getter
    public String getMeasurementUnit() {
        return measurementUnit;
    }

    // setter
    public void setMeasurementUnit(String measurementUnit) {
        String[] invalidUnit = {"asdfgh", "tic-tac-toe"};
        for (String invalid:invalidUnit) {
            if (invalid.equals(measurementUnit)) {
                return;
            }
        }
        this.measurementUnit = measurementUnit;
    }
}

class RecipeComponent {
    // each recipe component contains an ingredient and an amount
    Ingredients ingredients;
    Double amount;

    public RecipeComponent(Ingredients ingredients, double amount) {
        this.ingredients = ingredients;
        this.amount = amount;
    }


    public void displayComponent() {
        System.out.printf("%s: %.2f %s\n", ingredients.name, amount, ingredients.getMeasurementUnit());
    }
}

class Recipe {
    String name;
    RecipeComponent[] component;

    public Recipe (String name, RecipeComponent[] component) {
        this.name = name;
        this.component = component;
    }

    public void displayRecipe() {
        int count = 1;
        for (RecipeComponent rc : component) {
            System.out.printf("%d/ ", count);
            rc.displayComponent();
            count++;
        }
    }
}