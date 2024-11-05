package Base;

import java.util.HashMap;
import java.util.Map;

public class about_hashmap {
    public static void main(String[] args) {
        System.out.println("xue_ge_mao!");
    }
}


class _hashmap{
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
    }
}

// 建议用concurrentHashMap，见文件：ConcurrentHashMapOperations
class ComprehensiveHashMapOperations {
    private Map<String, Integer> map;
    
    // 构造函数
    public ComprehensiveHashMapOperations() {
        map = new HashMap<>();
    }
    
    // 1. 添加元素
    public void addElement(String key, Integer value) {
        map.put(key, value);// key-value，不再是add了
        System.out.println("Added: " + key + " - " + value);
    }
    
    // 2. 移除元素
    public void removeElement_by_key(String key) {
        Integer removedValue = map.remove(key);
        System.out.println("Removed: " + key + " = " + removedValue);
    }
    
    // 3. 查找元素
    public void findElement(String key) {
        Integer value = map.get(key);
        System.out.println("Value for key '" + key + "': " + value);
    }
    
    // 4. 检查键是否存在
    public void containsKey(String key) {
        System.out.println("Contains key '" + key + "': " + map.containsKey(key));
    }
    
    // 5. 检查值是否存在
    public void containsValue(Integer value) {
        System.out.println("Contains value '" + value + "': " + map.containsValue(value));
    }
    
    // 6. 获取所有键值对
    public void displayAll() {
        System.out.println("All elements in HashMap: " + map);
    }
    
    // 7. 获取大小
    public void getSize() {
        System.out.println("Size of HashMap: " + map.size());
    }
    
    // 8. 清空 HashMap
    public void clearMap() {
        map.clear();
        System.out.println("HashMap cleared. Current size: " + map.size());
    }
    
    // 9. 更新元素
    public void updateElement(String key, Integer newValue) {
        map.put(key, newValue);
        System.out.println("Updated: " + key + " = " + newValue);
    }
    
    // 10. 获取所有键
    public void getAllKeys() {
        System.out.println("All keys: " + map.keySet());// 获取所有键
    }
    
    // 11. 获取所有值
    public void getAllValues() {
        System.out.println("All values: " + map.values());// 获取所有值
    }
    
    // 12. 复制 HashMap
    public void copyMap() {
        Map<String, Integer> copy = new HashMap<>(map);
        System.out.println("Copied HashMap: " + copy);
    }
    
    // 13. 合并 HashMap
    public void mergeMaps(Map<String, Integer> otherMap) {
        map.putAll(otherMap);// 合并
        System.out.println("Merged with: " + otherMap);
        displayAll();
    }
    
    public static void main(String[] args) {
        ComprehensiveHashMapOperations operations = new ComprehensiveHashMapOperations();
        
        operations.addElement("Alice", 30);
        operations.addElement("Bob", 25);
        operations.findElement("Alice");
        operations.containsKey("Charlie");
        operations.containsValue(25);
        operations.displayAll();
        
        operations.updateElement("Bob", 26);
        operations.removeElement_by_key("Alice");
        operations.getSize();
        
        operations.getAllKeys();
        operations.getAllValues();
        
        // 复制和合并示例
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("Charlie", 20);
        newMap.put("David", 22);
        operations.mergeMaps(newMap);
        
        operations.clearMap();
        operations.getSize();
    }
}
