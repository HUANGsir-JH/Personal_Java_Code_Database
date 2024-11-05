package Base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class about_hashset {
    public static void main(String[] args) {
    
    }
}

class hashset{
    public static void main(String[] args) {
        HashSet<String> fruits = new HashSet<>();
        
        // 添加元素
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");  // 重复元素，不会添加
        
        // 遍历 HashSet
        System.out.println("Fruits in the set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // 检查是否包含某个元素
        if (fruits.contains("Banana")) {
            System.out.println("Banana is in the set.");
        }
        
        // 获取大小
        System.out.println("Number of fruits: " + fruits.size());
        
        // 删除元素
        fruits.remove("Cherry");
        System.out.println("After removing Cherry, number of fruits: " + fruits.size());
        
        // 清空 HashSet
        fruits.clear();
        System.out.println("After clearing, number of fruits: " + fruits.size());
    }
}


class HashSetOperations {
    private HashSet<String> set;
    
    // 构造函数
    public HashSetOperations() {
        set = new HashSet<>();
    }
    
    // 1. 添加元素
    public void addElements() {
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Apple");  // 重复元素，不会添加
        System.out.println("Added elements: " + set);
    }
    
    // 2. 判断是否为空
    public void checkIfEmpty() {
        System.out.println("Is the HashSet empty? " + set.isEmpty());
    }
    
    // 3. 集合的交集
    public void intersection() {
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("Banana");
        anotherSet.add("Mango");
        
        set.retainAll(anotherSet);
        System.out.println("After intersection: " + set);
    }
    
    // 4. 集合的并集
    public void union() {
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("Cherry");
        anotherSet.add("Mango");
        
        set.addAll(anotherSet);
        System.out.println("After union: " + set);
    }
    
    // 5. 集合的差集
    public void difference() {
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("Banana");
        anotherSet.add("Mango");
        
        set.removeAll(anotherSet);
        System.out.println("After difference: " + set);
    }
    
    // 6. 转换为数组
    public void convertToArray() {
        String[] array = set.toArray(new String[0]);
        System.out.println("Converted to array: " + String.join(", ", array));
    }
    
    // 7. 克隆 HashSet
    public void cloneHashSet() {
        HashSet<String> cloneSet = (HashSet<String>) set.clone();
        System.out.println("Cloned HashSet: " + cloneSet);
    }
    
    // 8. 排序 HashSet
    public void sortHashSet() {
        List<String> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);// 用Collections的sort方法对集合进行排序
        System.out.println("Sorted HashSet: " + sortedList);
    }
    
    public static void main(String[] args) {
        HashSetOperations operations = new HashSetOperations();
        operations.addElements();
        operations.checkIfEmpty();
        operations.intersection();
        operations.union();
        operations.difference();
        operations.convertToArray();
        operations.cloneHashSet();
        operations.sortHashSet();
    }
}

