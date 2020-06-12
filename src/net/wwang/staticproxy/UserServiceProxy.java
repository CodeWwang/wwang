package net.wwang.staticproxy;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.proxydemo
 * @Author: WangWei
 * @CreateTime: 2020-04-22 19:34
 * @Description:
 */
public class UserServiceProxy implements  UserService {
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        userService.add();
    }

    @Override
    public void delete() {
        userService.delete();
    }

    @Override
    public void update() {
        userService.update();
    }

    @Override
    public void select() {

        userService.select();
    }
    //日志方法
    public  void  log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
