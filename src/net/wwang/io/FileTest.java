package net.wwang.io;

import java.io.File;
import java.io.IOException;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.io
 * @Author: WangWei
 * @CreateTime: 2020-05-06 08:46
 * @Description:
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File dir = new File("E:\\Project");
        File file = new File("E:\\Project\\Hello.txt");
        File book = new File("E:\\Project\\斗破苍穹.txt");
        book.createNewFile();
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(File.separator);//根据当前平台打印"\"或"/"
        System.out.println(book.canExecute());
        System.out.println(book.canRead());
        System.out.println(book.canWrite());

        File[] files = dir.listFiles();//打印所有文件目录和文件
        for (File a:files
             ) {
            System.out.println(a);

        }
    }
}
