import java.io.File;

public class about_file {
    public static void main(String[] args) {
    
    }
}

// 获取文件信息
class file_get_operation{
    File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\test1_none.txt");
    //获取文件的直接路径
    public String getAbsolutePath(){
        return filepath.getAbsolutePath();
    }
    // 获取封装路径->文件对象创建时所用的路径
    public String getPath(){
        return filepath.getPath();
    }
    // 获取文件名或者文件夹名
    public String getName(){
        return filepath.getName();
    }
    // 获取父路径
    public String getParent(){
        return filepath.getParent();
    }
    // 获取文件大小
    public long length(){
        System.out.println("文件大小: " + filepath.length() + " bytes");
        return filepath.length();
    }
    
    public static void main(String[] args) {
        file_get_operation file_operation=new file_get_operation();
        System.out.println(file_operation.getAbsolutePath());
        System.out.println(file_operation.getPath());
        System.out.println(file_operation.getName());
        System.out.println(file_operation.getParent());
        file_operation.length();
    }
}

// 创建文件
class file_create_operation{
    
    File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\" +
            "test_none");
    
    // 创建文件，如果该文件存在，则返回false，否则返回创成功，返回true
    public boolean createNewFile() {
        try {
            if (filepath.exists()) {
                System.out.println("文件已存在");
                return true;
            }
            if (filepath.createNewFile()) {
                System.out.println("创建文件成功");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("创建文件失败");
            return false;
        }
    }
    
    // mkdirs创建文件夹，如果文件夹存在，则返回false，否则返回创成功，返回true
    public boolean mkdirs() {
        try {
            if (filepath.exists()) {
                System.out.println("文件夹已存在");
                return true;
            }
            if (filepath.mkdirs()) {
                System.out.println("创建文件夹成功");
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("创建文件夹失败");
            return false;
        }
    }
    
    public static void main(String[] args) {
        file_create_operation file_operation=new file_create_operation();
        file_operation.createNewFile();
        file_operation.mkdirs();
    }
}

// 删除文件
class file_delete_operation{
    
    File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\test1_none.txt");
    
    // 删除文件
    // 如果删除文件，不会放到回收站中
    public boolean deleteFile() {
        if (!filepath.exists()) {
            System.out.println("文件不存在");
            return false;
        }
        if (filepath.delete()) {
            System.out.println("文件删除成功");
            return true;
        }
        return false;
    }
    
    // 删除文件夹
    // 如果删除文件夹，必须得是空文件夹，同样不会放到回收站中
    public boolean deleteDirectory() {
        if (!filepath.exists()) {
            System.out.println("文件夹不存在");
            return false;
        }
        if (filepath.delete()) {
            System.out.println("文件夹删除成功");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        file_delete_operation file_operation=new file_delete_operation();
        file_operation.deleteFile();
        file_operation.deleteDirectory();
    }
}

// 文件重命名
class file_rename_operation{
    File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\test1_none.txt");
    // 重命名文件
    public boolean renameFile(String newFileName) {
        if (!filepath.exists()) {
            System.out.println("文件不存在");
            return false;
        }
        if (filepath.renameTo(new File(newFileName))) {
            System.out.println("文件重命名成功");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        file_rename_operation file_operation=new file_rename_operation();
        file_operation.renameFile("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\test2_none.txt");
    }
}

// 文件判断
class file_judge_operation{
    File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText\\test_none");
    // 判断文件是否存在
    public boolean exists() {
        if (filepath.exists()) {
            System.out.println("文件存在");
            return true;
        }
        System.out.println("文件不存在");
        return false;
    }
    
    public boolean isDirectory() {
        if (filepath.isDirectory()) {
            System.out.println("文件是文件夹");
            return true;
        }
        System.out.println("文件不是文件夹");
        return false;
    }
    
    public boolean isFile() {
        if (filepath.isFile()) {
            System.out.println("是文件");
            return true;
        }
        System.out.println("不是文件");
        return false;
    }
    
    public static void main(String[] args) {
        file_judge_operation file_operation=new file_judge_operation();
        file_operation.exists();
        file_operation.isDirectory();
        file_operation.isFile();
    }
}

// 遍历文件夹
class file_traversal_operation{
    // 遍历文件夹
    public void listFiles() {
        File filepath=new File("D:\\IDEA_Java\\Java_Learning\\File\\TestText");
        if (!filepath.exists()) {
            System.out.println("文件不存在");
            return;
        }
        File[] files = filepath.listFiles();// 获取文件夹下所有文件
        // 只遍历一级文件夹
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
    
    public static void main(String[] args) {
        file_traversal_operation file_operation=new file_traversal_operation();
        file_operation.listFiles();
    }
}