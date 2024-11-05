package Base;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class about_hashtable {
    public static void main(String[] args) {
    
    }
}
//ConcurrentHashMap 是 Java 中 java.util.concurrent 包下的线程安全集合类，
// 用来处理高并发环境中的键值对存储。它是 HashMap 的增强版，提供了在多线程场景下的高效性能。
// 相比于早期的 Hashtable，ConcurrentHashMap 通过分段锁（Segmented Locking）来减少锁的竞争，
// 提高并发访问的效率。

class hash_table{
    public static void main(String[] args) {
        Hashtable<Integer, String> ht = new Hashtable<Integer, String>();//创建Hashtable
    }
}

class ConcurrentHashMapOperations {
    private ConcurrentHashMap<String, Integer> concurrentMap;
    
    // 构造函数
    public ConcurrentHashMapOperations() {
        concurrentMap = new ConcurrentHashMap<>();
    }
    
    // 1. 添加元素
    public void addElement(String key, Integer value) {
        concurrentMap.put(key, value);
        System.out.println("Added: " + key + " = " + value);
    }
    
    // 2. 移除元素
    public void removeElement(String key) {
        Integer removedValue = concurrentMap.remove(key);
        System.out.println("Removed: " + key + " = " + removedValue);
    }
    
    // 3. 查找元素
    public void findElement(String key) {
        Integer value = concurrentMap.get(key);
        System.out.println("Value for key '" + key + "': " + value);
    }
    
    // 4. 检查键是否存在
    public void containsKey(String key) {
        System.out.println("Contains key '" + key + "': " + concurrentMap.containsKey(key));
    }
    
    // 5. 获取所有键值对
    public void displayAll() {
        System.out.println("All elements in ConcurrentHashMap: " + concurrentMap);
    }
    
    // 6. 获取大小
    public void getSize() {
        System.out.println("Size of ConcurrentHashMap: " + concurrentMap.size());
    }
    
    // 7. 清空 ConcurrentHashMap
    public void clearMap() {
        concurrentMap.clear();
        System.out.println("ConcurrentHashMap cleared. Current size: " + concurrentMap.size());
    }
    
    
    public static void main(String[] args) {
        ConcurrentHashMapOperations operations = new ConcurrentHashMapOperations();
        
        operations.addElement("Alice", 30);
        operations.addElement("Bob", 25);
        operations.findElement("Alice");
        operations.containsKey("Charlie");
        operations.displayAll();
        
        operations.removeElement("Bob");
        operations.getSize();
        operations.clearMap();
        operations.getSize();
    }
}


