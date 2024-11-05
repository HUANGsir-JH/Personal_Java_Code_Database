package Base;

import java.io.*;

public class about_file {
    public static void main(String[] args) {
    
    }
}


class FileOperations {
    
    private String filePath;
    
    public FileOperations(String filePath) {
        this.filePath = filePath;
    }
    
    // 读取文件内容
    public void readFile() {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("文件内容:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 写入文件内容
    public void writeFile(String content) {
        File file = new File(filePath);
        // FileWriter方法中添加false表示（默认false）覆盖写入
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            System.out.println("已写入文件: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 追加内容到文件
    public void appendToFile(String content) {
        File file = new File(filePath);
        // 追加内容到文件末尾，FileWriter方法中添加true表示追加，不会覆盖原有内容
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(content);
            System.out.println("已追加内容到文件: " + content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 获取文件信息
    public void getFileInfo() {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("文件名: " + file.getName());
            System.out.println("绝对路径: " + file.getAbsolutePath());
            System.out.println("文件大小: " + file.length() + " bytes");
            System.out.println("可读: " + file.canRead());
            System.out.println("可写: " + file.canWrite());
        } else {
            System.out.println("文件不存在");
        }
    }
    
    // 删除文件
    public void deleteFile() {
        File file = new File(filePath);
        if (file.delete()) {
            System.out.println("文件已删除");
        } else {
            System.out.println("删除文件失败");
        }
    }
    
    // 重命名文件
    public void renameFile(String newFileName) {
        File file = new File(filePath);
        File newFile = new File(newFileName);
        if (file.renameTo(newFile)) {
            System.out.println("文件已重命名为: " + newFile.getName());
            this.filePath = newFileName;  // 更新文件路径
        } else {
            System.out.println("文件重命名失败");
        }
    }
    
    // 复制文件
    public void copyFile(String destinationPath) {
        File sourceFile = new File(filePath);
        File destFile = new File(destinationPath);
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            System.out.println("文件已复制到: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 创建新文件
    public void createNewFile(String newFilePath) {
        File file = new File(newFilePath);
        try {
            if (file.createNewFile()) {
                System.out.println("新文件已创建: " + file.getName());
            } else {
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // 创建新的文件夹
    public void createNewFolder(String newFolderPath) {
        File folder = new File(newFolderPath);
        if (folder.mkdir()) {
            System.out.println("新文件夹已创建: " + folder.getName());
        } else {
            System.out.println("文件夹已存在");
        }
    }
    
    public static void main(String[] args) {
        String file_path = "D:\\IDEA_Java\\Java_Learning\\src\\newFile1.txt";
        FileOperations fileOps = new FileOperations(file_path);
        
        // 读取文件
        fileOps.readFile();
        
        // 写入文件
        //fileOps.writeFile("Java I/O 操作示例");
        
        // 追加内容
        fileOps.appendToFile("\n something to add ");
        
        // 获取文件信息
        fileOps.getFileInfo();
        
        // 复制文件
        fileOps.copyFile("D:\\IDEA_Java\\Java_Learning\\src\\copyFile.txt");
        
        // 重命名文件
        //fileOps.renameFile("D:\\IDEA_Java\\Java_Learning\\src\\renamedFile.txt");
        
        // 删除文件
        //fileOps.deleteFile();
        
        // 创建新文件
        fileOps.createNewFile("D:\\IDEA_Java\\Java_Learning\\src\\newFile.txt");
        file_path="D:\\IDEA_Java\\Java_Learning\\src\\newFile.txt";
        
        // 创建新文件夹
        fileOps.createNewFolder("D:\\IDEA_Java\\Java_Learning\\src\\newFolder");
    }
}

