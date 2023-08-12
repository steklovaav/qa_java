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
public class LionTest {

    static final String ANIMAL_KIND = "Хищник";
    static final List<String> FOOD = List.of("Еда");
    private String sex;
    private boolean expectException;
    private boolean hasMane;
    private int kittensCount;

    public LionTest(String sex, boolean expectException, boolean hasMane, int kittensCount) {
        this.sex = sex;
        this.expectException = expectException;
        this.hasMane = hasMane;
        this.kittensCount = kittensCount;
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCounts() {
        return new Object[][]{
                {"Самец", false, true, 1},
                {"Самка", false, false, 1},
                {"Некорректное значение", true,false,0}
        };
    }

    @Test
    public void getKittens() throws Exception {
        if (expectException) {
            exception.expect(Exception.class);
            exception.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        }else{
            Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        }
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(kittensCount, lion.getKittens());
        Mockito.verify(feline, Mockito.atLeastOnce()).getKittens();
    }
    @Test
    public void doesHaveMane() throws Exception {
        if (expectException) {
            exception.expect(Exception.class);
            exception.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        }
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFood() throws Exception {
        if (expectException) {
            exception.expect(Exception.class);
            exception.expectMessage("Используйте допустимые значения пола животного - самей или самка");
        }else{
            Mockito.when(feline.getFood(ANIMAL_KIND)).thenReturn(FOOD);
        }
        Lion lion = new Lion(feline, sex);
        Assert.assertEquals(FOOD, lion.getFood());
        Mockito.verify(feline, Mockito.atLeastOnce()).getFood(ANIMAL_KIND);
    }
}
