package ua.holotova.hw9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.security.SecureRandom;
import java.util.Random;

import static org.mockito.Mockito.withSettings;

class GetRandomNumberTest {
    private Random random;
    private GetRandomNumber getRandomNumber;
    public int num;

    @BeforeEach
    void setUp() {
        random = Mockito.mock(SecureRandom.class, withSettings().withoutAnnotations());
        Mockito.when(random.nextInt(100)).thenReturn(num);
    }

    @Test
    void get_Null() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 0;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(-1,getRandomNumber.get(random));

    }

    @Test
    void get_lessThen10() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 5;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(-10,getRandomNumber.get(random));

    }
    @Test
    void get_lessThen20() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 15;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(num/5,getRandomNumber.get(random));

    }
    @Test
    void get_lessThen50() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 40;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(null,getRandomNumber.get(random));

    }
    @Test
    void get_lessThen80() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 65;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(1000/num,getRandomNumber.get(random));

    }
    @Test
    void get_lessThen100() {
        GetRandomNumber getRandomNumber = new GetRandomNumber();
        num = 90;
        Mockito.when(random.nextInt(100)).thenReturn(num);
        Assertions.assertEquals(num,getRandomNumber.get(random));

    }

}