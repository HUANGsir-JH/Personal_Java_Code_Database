import java.lang.reflect.Field;

public class FieldsDemo {
    public static void main(String[] args) throws Exception{
        Class<PersonDemo> personDemoClass = PersonDemo.class;
        
        // 获取所有的public字段
        // getFields()
        Field[] fields = personDemoClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        
        System.out.println("=========================");
        
        // 获取所有的字段,包含private字段
        // getDeclaredFields()
        Field[] declaredFields = personDemoClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }
        
        System.out.println("=========================");
        
        // 获取指定的public字段
        // getField(String fieldName)
        Field salary = personDemoClass.getField("salary");
        System.out.println(salary);
        
        System.out.println("=========================");
        
        // 获取指定的字段，包括private
        // getDeclaredField(String fieldName)
        Field name = personDemoClass.getDeclaredField("name");
        System.out.println(name);
        
        System.out.println("=========================");
        
        // 获取和和修改字段的值
        // set(Object obj, Object value) -> 为属性赋值
        // get(Object obj) -> 获取属性的值
        // 同样的，私有的字段需要setAccessible(true)
        PersonDemo NoneIns = personDemoClass.getConstructor().newInstance();
        salary.set(NoneIns, 10000);
        System.out.println("salary: "+salary.get(NoneIns));
        name.setAccessible(true);
        name.set(NoneIns, "伍六七");
        System.out.println("name: "+name.get(NoneIns));
        
    }
}


