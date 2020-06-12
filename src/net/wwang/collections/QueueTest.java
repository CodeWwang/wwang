package net.wwang.collections;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.collections
 * @Author: WangWei
 * @CreateTime: 2020-04-30 14:01
 * @Description:
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Hello");
        queue.offer("World");
        queue.peek();
        queue.poll();
    }
}
