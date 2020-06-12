package net.wwang.collections;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.collections
 * @Author: WangWei
 * @CreateTime: 2020-04-30 14:45
 * @Description:
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Queue<User> queue = new PriorityQueue<>(new UserComparater());
        queue.offer(new User("mimi","A1031"));
        queue.offer(new User("wwang","V001"));
        queue.offer(new User("wangwei","A1231"));
        System.out.println(queue.poll());
    }
}
class UserComparater implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        char priority1= user1.getNumber().charAt(0);
        char priority2 = user2.getName().charAt(0);
        if (priority1==priority2)
        {
            return user1.getNumber().compareTo(user2.getNumber());
        }else{
            if(priority1=='V'){
                return -1;
            }else {
                return 1;
            }
        }
    }
}
class User{
    private String name;
    private String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
