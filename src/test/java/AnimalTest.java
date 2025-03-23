import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    @Test
    public void shouldReturnFoodForHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Трава", "Различные растения");
        assertEquals(expectedFood, animal.getFood("Травоядное"));
    }

    @Test
    public void shouldReturnFoodForPredator() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, animal.getFood("Хищник"));
    }

    @Test
    public void shouldThrowExceptionForUnknownAnimalType() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> animal.getFood("Неизвестный вид"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void shouldReturnAnimalFamilyDescription() {
        Animal animal = new Animal();
        String expectedDescription = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedDescription, animal.getFamily());
    }
}
