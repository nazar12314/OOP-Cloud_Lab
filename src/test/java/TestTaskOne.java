import org.example.Task1.Handler;
import org.example.Task1.Handler20;
import org.example.Task1.Handler5;
import org.example.Task1.Handler50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTaskOne {

    @Test
    public void testATM() throws Exception {
        Handler handler50 = new Handler50();
        Handler handler20 = new Handler20();
        Handler handler5 = new Handler5();

        handler50.setNext(handler20);
        handler20.setNext(handler5);
        Assertions.assertEquals(handler50.process(120), 3);
        Assertions.assertEquals(handler50.process(35), 4);
        Assertions.assertThrows(IllegalArgumentException.class, () -> handler50.process(37));
    }
}
