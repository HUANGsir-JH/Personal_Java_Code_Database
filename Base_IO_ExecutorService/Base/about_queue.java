package Base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class about_queue {
    public static void main(String[] args) {
        // 双向队列
        Deque<String> deque = new ArrayDeque<>(); //<String>

        // 1. 添加元素
        deque.add("Alice");
        deque.add("Bob");
        deque.add("Charlie");
        deque.addFirst("Dave");
        deque.addLast("Eve");
        System.out.println("Deque: " + deque);

        // 2. 添加多个元素
        deque.addFirst("Dave");
        deque.addLast("Eve");
        System.out.println("Deque: " + deque);
        
        // 3. 移除元素
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque: " + deque);
        
        // 4. 查看元素
        System.out.println("First element: " + deque.peekFirst());
        System.out.println("Last element: " + deque.peekLast());
        
        // 5. 获取元素的数量
        System.out.println("Size: " + deque.size());
        
        // 6. 检查元素是否为空
        System.out.println("Is empty? " + deque.isEmpty());
        
        // 7. 清空队列
        deque.clear();
        System.out.println("Deque cleared. Current deque: " + deque);
    }
}


// 队列操作
class QueueOperations {
    private Queue<String> queue;
    
    // 构造函数
    // 是个单向队列
    public QueueOperations() {
        queue = new ArrayDeque<>();
    }
    
    // 1. 添加元素
    public void addElement(String element) {
        queue.add(element);
        System.out.println("Added element: " + element);
    }
    
    // 2. 添加多个元素
    public void addMultipleElements(String... elements) {
        //String... elements 表示一个字符串参数列表，
        // 可以传入一个或多个字符串参数
        for (String element : elements) {
            queue.add(element);
        }
        System.out.println("Added multiple elements: " + queue);
    }
    
    // 3. 移除队首元素
    public void removeHead() {
        String removed = queue.poll();  // 移除并返回队首元素
        System.out.println("Removed: " + removed);
        System.out.println("Current queue: " + queue);
    }
    
    // 4. 查看队首元素
    public void peekHead() {
        String head = queue.peek();  // 不移除，返回队首元素
        System.out.println("Head of queue: " + head);
    }
    
    // 5. 获取队列的大小
    public void getSize() {
        System.out.println("Queue size: " + queue.size());
    }
    
    // 6. 检查队列是否为空
    public void checkIfEmpty() {
        System.out.println("Is the queue empty? " + queue.isEmpty());
    }
    
    // 7. 清空队列
    public void clearQueue() {
        queue.clear();
        System.out.println("Queue cleared. Current queue: " + queue);
    }
    
    // 8. 转换为数组
    public void convertToArray() {
        String[] array = queue.toArray(new String[0]);
        System.out.println("Converted to array: " + String.join(", ", array));
    }
    
    // 9. 查看所有元素
    public void displayAllElements() {
        System.out.println("All elements in queue: " + queue);
    }
    
    // 10. 检查元素是否存在
    public void checkElement(String element) {
        System.out.println("Does the queue contain '" + element + "'? " + queue.contains(element));
    }
    
    // 11. 移除特定元素
    public void removeSpecificElement(String element) {
        boolean removed = queue.remove(element);
        System.out.println("Removed '" + element + "': " + removed);
        System.out.println("Current queue: " + queue);
    }
    
    // 12. 清空并添加元素
    public void clearAndAdd(String... elements) {
        queue.clear();
        addMultipleElements(elements);
    }
    
    public static void main(String[] args) {
        QueueOperations operations = new QueueOperations();
        
        operations.addMultipleElements("Alice", "Bob", "Charlie");
        operations.peekHead();
        operations.getSize();
        operations.checkIfEmpty();
        operations.displayAllElements();
        
        operations.removeHead();
        operations.checkElement("Bob");
        operations.removeSpecificElement("Bob");
        
        operations.clearAndAdd("Dave", "Eve");
        operations.convertToArray();
        operations.clearQueue();
        operations.checkIfEmpty();
    }
}

