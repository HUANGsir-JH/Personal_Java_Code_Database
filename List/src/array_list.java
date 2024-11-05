import java.util.ArrayList;
import java.util.List;

/**
 * 1.元素有序
 * 2.元素可重复
 * 3.线程不安全（vector线程安全）
 * 4.有索引
 * 5.底层是数组
 */
public class array_list {
    public static void main(String[] args) {
        List<Integer> arraylist=new ArrayList<>();
        // 动态的数组，适合查询频繁的场景

        arraylist.add(1);
        arraylist.add(2);
        arraylist.add(3);
        arraylist.add(4);
        arraylist.add(5);
        System.out.println(arraylist);
        arraylist.addFirst(0);
        arraylist.addLast(6);
        System.out.println(arraylist);
        /**
         * 1.add(E e):在列表的尾部添加一个元素
         * 2.add(int index, E element):在列表的指定位置插入一个元素
         * 3.addFirst(E e):在列表的头部添加一个元素
         * 4.addLast(E e):在列表的尾部添加一个元素
         * 5.get(int index):获取列表中的元素
         * 6.set(int index, E element):设置列表中的元素
         * 7.remove(int index):删除列表中的元素
         * 8.removeFirst():删除列表中的第一个元素
         * 9.removeLast():删除列表中的最后一个元素
         * 10.remove(E e):删除列表中的元素
         * 11.indexOf(E e):返回列表中第一个满足条件的元素的索引
         * 12.lastIndexOf(E e):返回列表中最后一个满足条件的元素的索引
         * 13.clear():清空列表
         * 14.isEmpty():判断列表是否为空
         * 15.size():返回列表的长度
         * 16.equals(Object obj):判断两个列表是否相等
         */
    }
}
