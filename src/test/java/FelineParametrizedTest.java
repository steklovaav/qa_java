import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int kittensCount;

    public FelineParametrizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCounts() {
        return new Object[][]{
                {1}, {2}, {0}, {-1}
        };
    }

    @Test
    public void getKittensWithArgs() {
        Feline feline = new Feline();
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
