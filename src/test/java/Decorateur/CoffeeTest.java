package Decorateur;

import Decorateur.Coffee.Coffee;
import Decorateur.Coffee.SimpleCoffee;
import Decorateur.Coffee.WithMilk;
import Decorateur.Coffee.WithSprinkles;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Decorateur.Repas.IIngredient;

public class CoffeeTest {
    public static void printInfo(Coffee c) {
        System.out.println("Cost: " + c.getCost() + "; Ingredients: " + c.getDescription());
    }

    @Test
    public void coffeeTest() {
        IIngredient c = (IIngredient) new SimpleCoffee(1.0, "Coffee");
        assertEquals(1.0,c.getCost(),0.001);
        assertEquals("Coffee",c.getDescription());

        c = (IIngredient) new WithMilk(c, 0.5,"Milk");
        assertEquals(1.5,c.getCost(),0.001);
        assertEquals("Coffee, Milk",c.getDescription());

        c = (IIngredient) new WithMilk(c, 0.5,"Milk");
        assertEquals(2,c.getCost(),0.001);
        assertEquals("Coffee, Milk, Milk",c.getDescription());

        c = new WithSprinkles(c, 0.2, "Sprinkles");
        assertEquals(2.2,c.getCost(),0.001);
        assertEquals("Coffee, Milk, Milk, Sprinkles",c.getDescription());
   

        c = new WithSprinkles(new WithMilk(new SimpleCoffee(1.0, "Coffee"),0.5, "Milk"), 0.2, "Sprinkles");
        assertEquals(1.7,c.getCost(),0.001);
        assertEquals("Coffee, Milk, Sprinkles",c.getDescription());

    }
}