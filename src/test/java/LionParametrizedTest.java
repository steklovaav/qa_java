import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    static final String ANIMAL_KIND = "Хищник";
    static final List<String> FOOD = List.of("Еда");
    private String sex;
    private boolean hasMane;
    private int kittensCount;

    public LionParametrizedTest(String sex, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getParemeters() {
        return new Object[][]{
                {"Самец", true, 1},
                {"Самка", false, 1},
                {"Самка", false, 2},
                {"Самец", true, -11},
        };
    }

    @Test
    public void getKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(kittensCount, lion.getKittens());
        Mockito.verify(feline, Mockito.atLeastOnce()).getKittens();
    }
    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        Mockito.when(feline.getFood(ANIMAL_KIND)).thenReturn(FOOD);
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(FOOD, lion.getFood());
        Mockito.verify(feline, Mockito.atLeastOnce()).getFood(ANIMAL_KIND);
    }
}
