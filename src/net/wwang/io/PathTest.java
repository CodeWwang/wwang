package net.wwang.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.io
 * @Author: WangWei
 * @CreateTime: 2020-05-06 09:19
 * @Description:
 */
public class PathTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\Project\\", "斗罗大陆.txt");
        System.out.println(path.toAbsolutePath());
        System.out.println(path.toFile());
        File file=path.toFile();
        file.createNewFile();
        file.delete();{
            
        }
    }
}
