import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertThrows;

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

    @Test
    public void getFoodException() throws Exception {
        Cat cat = new Cat(feline);
        String message = "Тестовый эксепшн";
        Exception e = new Exception(message);
        Mockito.when(feline.eatMeat()).thenThrow(e);
        assertThrows(message,Exception.class, cat::getFood);
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }


}
