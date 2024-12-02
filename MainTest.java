package Test;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testProduct_withPositives() {
        int[] nums = {1, 2, 3, -4, 5};
        int expected = 1 * 2 * 3 * 5;
        Assert.assertEquals(expected, Main.productOfPositiveElements(nums)); // Виклик правильного методу
    }

    @Test
    public void testProduct_noPositives() {
        int[] nums = {-1, -2, -3};
        try {
            Main.productOfPositiveElements(nums); // Виклик правильного методу
            fail("Має бути помилка");
        } catch (IllegalArgumentException e) {
            assertEquals("У масиві немає додатних елементів", e.getMessage());
        }
    }

    @Test
    public void testSum_withPositives() {
        int[] nums = {1, -2, 3, -4, 5};
        int expected = 1 - 2 + 3 - 4;
        Assert.assertEquals(expected, Main.sumBeforeLastPositive(nums)); // Виклик правильного методу
    }

    @Test
    public void testSum_noPositives() {
        int[] nums = {-1, -2, -3};
        try {
            Main.sumBeforeLastPositive(nums); // Виклик правильного методу
            fail("Має бути помилка");
        } catch (IllegalArgumentException e) {
            assertEquals("У масиві немає додатних елементів", e.getMessage());
        }
    }
}
