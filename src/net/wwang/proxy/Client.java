package net.wwang.proxy;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.proxy
 * @Author: WangWei
 * @CreateTime: 2020-04-22 20:42
 * @Description:
 */
public class Client {
    public static void main(String[] args) {

        //确定要为哪个房东代理
        Host_2 host_2 = new Host_2();
        //创建代理角色
        Proxy proxy = new Proxy();
        proxy.setRent(host_2);
        Rent rent = (Rent)proxy.getProxy();
        rent.rent();
    }


}
