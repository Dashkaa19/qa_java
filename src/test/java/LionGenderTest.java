import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionGenderTest {

    private final String gender;
    private final boolean expectedManePresence;

    public LionGenderTest(String gender, boolean expectedManePresence) {
        this.gender = gender;
        this.expectedManePresence = expectedManePresence;
    }

    @Parameterized.Parameters
    public static Object[][] lionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void shouldVerifyManePresenceBasedOnGender() throws Exception {
        Lion lion = new Lion(gender, new Feline());
        assertEquals(expectedManePresence, lion.doesHaveMane());
    }
}
