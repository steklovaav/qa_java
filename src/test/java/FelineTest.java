import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void eatMeat() throws Exception {
        List<String> result = null;
        result = feline.eatMeat();
        Mockito.verify(feline, Mockito.atLeastOnce()).getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"),result);
    }
    @Test
    public void getFamily() {
        Assert.assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgs() {
        Assert.assertEquals(1,feline.getKittens());
        Mockito.verify(feline, Mockito.atLeastOnce()).getKittens(1);
    }

}
