package net.wwang.collections;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.collections
 * @Author: WangWei
 * @CreateTime: 2020-04-30 10:01
 * @Description:
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        String file ="# test"+"\n"+"username=wwang"+"\n"+"password=wwaneeg@";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(file.getBytes("UTF-8"));
        Properties properties = new Properties();
        properties.load(inputStream);
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }
}
