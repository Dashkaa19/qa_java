import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {
    private Feline feline;
    private Cat cat;

    @Before
    public void init() {
        feline = Mockito.mock(Feline.class);
        cat = new Cat(feline);
    }

    @Test
    public void shouldReturnMeowAsSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void shouldReturnMeatAsFood() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Мясо"));
        assertEquals(List.of("Мясо"), cat.getFood());
        Mockito.verify(feline).eatMeat();
    }
}
