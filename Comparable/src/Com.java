import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Com {
    public static void main(String[] args) {
        student s1 = new student("zhangsan", 90);
        student s2= new student("lisi", 80);
        student s3= new student("wangwu", 70);
        student s4= new student("zhaoliu", 60);
        student s5= new student("tianqi", 50);
        student s6= new student("xiaoli", 40);
        student[] students = {s1, s2, s3, s4, s5, s6};
        ArrayList<student> stu_list= new ArrayList<>();
        stu_list.addAll(Arrays.asList(students));
        for (student i : stu_list) {
            System.out.print(i.getName() + ":" + i.getScore()+" ");
        }
        System.out.println();
        Collections.sort(stu_list);//Collections工具类的排序方法
        /**
         * 如果类实现了comparable接口，可以使用Collections.sort方法，按照student类实现的compareTo方法排序
         * 如果类中没有compareTo方法，可以使用匿名内部类，如：
         *      Collections.sort(stu_list,new comparator<student>(){
         *          @override
         *          public int compare(student s1,student s2){
         *              return (int) (s1.getScore()-s2.getScore());
         *              // s1-s2 ->升序
         *              // s2-s1 ->降序
         *      }
         */
        for (student i : stu_list) {
            System.out.print(i.getName() + ":" + i.getScore()+" ");
        }
    }
}

class student implements Comparable<student>{
    private String name;
    private float score;
    
    public student(String name, float score) {
        this.name = name;
        this.score = score;
    }
    
    public String getName() {
        return name;
    }
    
    public float getScore() {
        return score;
    }
    @Override
    public int compareTo(student other){
        return (int) (this.getScore()-other.getScore());
    }
}
