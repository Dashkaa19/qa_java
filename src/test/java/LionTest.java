import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private Feline feline;
    private Lion lion;

    @Before
    public void init() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion("Самец", feline);
    }

    @Test
    public void shouldHaveManeForMaleLion() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void shouldReturnCorrectKittenCount() {
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void shouldReturnCorrectFoodList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        assertEquals(List.of("Мясо"), lion.getFood());
    }

    @Test
    public void shouldThrowExceptionForInvalidGender() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Средний род", new Feline()));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
