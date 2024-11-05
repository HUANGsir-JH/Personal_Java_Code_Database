package Base;

public class parent_and_child {
    public static void main(String[] args) {
        child c = new child("zhangsan", 20, "male");
        c.show();
    }
}

class parent {
    protected String name;
    protected int age;

    public parent(String _name, int _age) {
        name = _name;
        age = _age;
    }

    public void show() {
        System.out.println(name + " " + age);
    }
}

class child extends parent {
    String sex;
    public child(String _name, int _age, String _sex) {
        super(_name, _age);//调用父类的构造函数,如果是无参构造，可以省略
        sex = _sex;
    }
    public void show()
    {
        System.out.println(name + " " + age + " " + sex);
    }
}

interface person1{
    void eat();
    public int age = 0;
    public String name = "";
}


