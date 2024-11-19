import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class example2 {
    @Test
    public void testAdd() {
        FuntionsToTest ft = new FuntionsToTest();
        ft.add(20,10);
    }
    
    @Test
    public void testSub() {
        FuntionsToTest ft = new FuntionsToTest();
        ft.sub(20,10);
    }
    
    @Before
    public void setUp() {
        System.out.println("beforeTest");
    }
    
    @After
    public void tearDown() {
        System.out.println("afterTest");
    }
}

class FuntionsToTest {
    
    public void add(int a, int b) {
        int c = a + b;
        System.out.println(c);
    }
    
    public void sub(int a, int b) {
        int c = a - b;
        System.out.println(c);
    }
}
