package net.wwang.staticproxy;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.proxydemo
 * @Author: WangWei
 * @CreateTime: 2020-04-22 19:31
 * @Description:
 */
public class UserServiceImpl implements  UserService {


    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void select() {
        System.out.println("select");
    }
}
