package codewars;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

//https://www.codewars.com/kata/525c65e51bf619685c000059/train/java
public class PeteBaker {

    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {

        if (!available.keySet().containsAll(recipe.keySet())) {
            return 0;
        }

        return recipe.entrySet()
                .stream()
                .mapToInt(entry -> available.get(entry.getKey()) / entry.getValue())
                .min()
                .orElse(0);
    }
}

class PeteBakerTest {
    @Test
    void basicTest() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(2, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }

    @Test
    void missingIngredient() {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1,
                "cinnamon", 300);
        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);
        assertEquals(0, PeteBaker.cakes(recipe, available), "For recipe " + recipe + " and ingredients " + available);
    }
}

