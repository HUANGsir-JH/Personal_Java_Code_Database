import java.util.LinkedList;

public class linked_list {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();//创建LinkedList
        // 主要用于频繁插入删除的场景
        
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        list.push(0);
        list.addLast(6);
        System.out.println(list);
        /**
         * 1.与arraylist的大多数方法基本相同
         * 2.peek():获取但不移除第一个元素；返回 null 表示空列表。
         * 3.poll():获取并移除第一个元素；空列表时返回 null。
         * 4.offer(E e):将元素添加到末尾，返回 true 表示成功。
         * 5.push(E e):将元素添加到首部，返回 true 表示成功。
         */
    }
}
