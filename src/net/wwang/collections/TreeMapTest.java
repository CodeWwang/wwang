package net.wwang.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.collections
 * @Author: WangWei
 * @CreateTime: 2020-04-30 09:24
 * @Description: TreeMap中的元素默认按照keys的自然排序排列。
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,Integer> map = new TreeMap<>();
        map.put("Hello",1);
        map.put("World",2);
        map.put("!",3);
        for (String key:map.keySet()
             ) {
            System.out.println(key);
        }
    }
}
