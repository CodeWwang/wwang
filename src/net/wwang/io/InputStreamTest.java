package net.wwang.io;

import java.io.*;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.io
 * @Author: WangWei
 * @CreateTime: 2020-05-06 09:41
 * @Description:
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream input = null;
        try {
            input = new FileInputStream("E:\\Project\\斗破苍穹.txt");
            byte[] buffer = new byte[1024];
            int n;
            while ((n = input.read(buffer)) != -1){
                System.out.println("read"+n+"bytes");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            input.close();
        }

    }
}
