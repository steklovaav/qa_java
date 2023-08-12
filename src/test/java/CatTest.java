import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;


    @Test
    public void getSound(){
        Cat cat = new Cat(feline);
        Assert.assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void getFoodSuccess() throws Exception {
        Cat cat = new Cat(feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(food);
        Assert.assertEquals(food, cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    @Test
    public void getFoodException() throws Exception {
        Cat cat = new Cat(feline);
        String message = "Тестовый эксепшн";
        exception.expect(Exception.class);
        exception.expectMessage(message);
        Exception e = new Exception(message);
        Mockito.when(feline.eatMeat()).thenThrow(e);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }


}
