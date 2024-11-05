package Base;

public class generics {
    public static void main(String[] args) {
        GenericClass<String> g = new GenericClass<String>("hello");
        System.out.println(g.data);
        GenericClass<Integer> g1 = new GenericClass<Integer>(100);
        System.out.println(g1.data);
        
        GenericImpl<String> g2 = new GenericImpl<String>("hello");
        System.out.println(g2.getData());
        g2.setData("world");
        System.out.println(g2.getData());
        GenericImpl<Integer> g3 = new GenericImpl<Integer>(100);
        System.out.println(g3.getData());
    }
}

//泛型类
class GenericClass<T> {
    T data;
    
    public GenericClass(T data) {
        this.data = data;
    }
}
//泛型接口
interface GenericInterface<T> {
    T getData();
    void setData(T data);
}

class GenericImpl<T> implements GenericInterface<T> {
    T data;
    
    public GenericImpl(T data) {
        this.data = data;
    }
    
    @Override
    //泛型方法
    public T getData() {
        return data;
    }
    
    @Override
    public void setData(T data) {
        this.data = data;
    }
}