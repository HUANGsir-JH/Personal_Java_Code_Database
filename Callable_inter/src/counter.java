import java.util.concurrent.Callable;

public class counter implements Callable<Integer> {
    
    private static int count=0;
    @Override
    public Integer call() throws Exception {
        while (count < 9) {
            count++;
            System.out.println("Callable Thread: Count = " + count);
        }
        return count;
    }
}
