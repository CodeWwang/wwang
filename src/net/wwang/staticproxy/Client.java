package net.wwang.staticproxy;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.proxydemo
 * @Author: WangWei
 * @CreateTime: 2020-04-22 19:32
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
   UserServiceImpl userService = new UserServiceImpl();
    UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(userService);
        userServiceProxy.select();
}
}
