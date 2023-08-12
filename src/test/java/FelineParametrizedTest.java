import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {
    private final int kittensCount;

    @Spy
    Feline feline;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

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
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
        Mockito.verify(feline, Mockito.atLeastOnce()).getKittens(kittensCount);
    }
}
