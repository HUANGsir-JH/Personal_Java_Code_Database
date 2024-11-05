package Base;

import java.util.ArrayList;
import java.util.LinkedList;

public class about_collection {
    public static void main(String[] args) {
    
    }
}

class about_arraylist{
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //不允许使用基本元（int，double，boolean，char）来作为泛型
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(0,-10);
        list.addFirst(-20);
        list.addLast(70);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
//        list.removeIf(i->i%2==0);
        System.out.println(list);
        System.out.println(list.indexOf(30));//返回第一个满足条件的元素的索引
        System.out.println(list.lastIndexOf(30));//返回最后一个满足条件的元素的索引
        
    }
}

class about_linkedlist{
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        //所有基本操作基本和ArrayList一样
        //arraylist适合数据的随机访问
        //linkedlist适合数据的插入和删除
        //不考虑性能的前提下，二者可以认为没有差异
    }
}
