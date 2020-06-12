package net.wwang.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.proxy
 * @Author: WangWei
 * @CreateTime: 2020-04-22 20:43
 * @Description:
 */
public class Proxy implements InvocationHandler {
    //创建需要被代理的接口
    private Rent rent;
    //代理接口的set方法
    public void setRent(Rent rent) {
        this.rent = rent;
    }
    //获得动态代理对象
    public Object getProxy(){
        return java.lang.reflect.Proxy.newProxyInstance(this.getClass().getClassLoader(),rent.getClass().getInterfaces(),this);

    }
    //动态代理实例
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(rent, args);
        return  invoke;
    }
}
