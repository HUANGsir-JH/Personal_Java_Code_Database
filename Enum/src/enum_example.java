/**
 * <h1>Java中常用的枚举类</h1>
 * <ul>
 *
 * </ul>
 */
public class enum_example {
    public static void main(String[] args) {
        State state = State.UP;
        System.out.println(state);
        
        System.out.println("========================");
        
        String down = State.DOWN.toString();
        System.out.println(down);
        
        System.out.println("========================");
        
        State[] values = State.values();
        for (State value : values) {
            System.out.println(value);
        }
        
        System.out.println("========================");
        
        State up = State.valueOf("UP");
        System.out.println(up);
    }
}
