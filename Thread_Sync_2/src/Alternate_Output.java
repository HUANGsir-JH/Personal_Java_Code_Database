
public class Alternate_Output {
    public static void main(String[] args) {
        control flag=new control();
        
        printNum pn=new printNum(flag);
        printMonth pm=new printMonth(flag);
        
        Thread tn=new Thread(pn);
        Thread tm=new Thread(pm);
        
        tn.start();
        tm.start();
        
    }
}

class printNum implements Runnable{
    private int count=1;
    private control flag;
    public printNum(control flag){
        this.flag=flag;
    }
    public void run(){
        while (count<=12){
            synchronized (flag){
                if (flag.isFlag()==true){
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(count+" ");
                count++;
                flag.setFlag(true);
                flag.notifyAll();
            }
        }
    }
}

class printMonth implements Runnable{
    private String[] nums={"One","Two","Three","Four","Five","Six",
            "Seven","Eight","Nine","Ten","Eleven","Twelve"};
    private String[] months={"January","February","March","April",
            "May","June","July","August","September","October",
            "November","December"};
    private int index=0;
    private control flag;
    public printMonth(control flag){
        this.flag=flag;
    }
    public void run(){
        while (index<12){
            synchronized (flag){
                if(flag.isFlag()==false){
                    try {
                        flag.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(nums[index]);
                System.out.println(months[index]);
                index++;
                flag.setFlag(false);
                flag.notifyAll();
            }
        }
    }
}

class control{
    private boolean flag=false;
    // flag为false表示数字还没输出，为true表示数字已经输出
    public boolean isFlag() {
        return flag;
    }
    // 设置flag
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}