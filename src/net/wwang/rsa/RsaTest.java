package net.wwang.rsa;

import java.util.Map;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.rsa
 * @Author: WangWei
 * @CreateTime: 2020-05-13 16:17
 * @Description:
 */
public class RsaTest {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        //生成公钥和私钥
        Map<Integer,String> rsaKey = RsaUtils.genKeyPair();
        //加密字符串
        System.out.println("公钥："+rsaKey.get(0));
        System.out.println("私钥："+rsaKey.get(1));
        System.out.println("生成密钥消耗时间："+(System.currentTimeMillis() - startTime)+"ms");

        String message = "helloworld";
        System.out.println("原文："+message);

        startTime = System.currentTimeMillis();
        //公钥加密
        String encryptMessage = RsaUtils.encrypt(message, rsaKey.get(0));
        System.out.println("密文："+encryptMessage);
        System.out.println("加密密文消耗时间："+(System.currentTimeMillis() - startTime)+"ms");
        System.out.println("密文长度："+encryptMessage.length());
        startTime = System.currentTimeMillis();
        //私钥解密
        String decryptMessage = RsaUtils.decrypt(encryptMessage, rsaKey.get(1));
        System.out.println("解密原文："+decryptMessage);
        System.out.println("解密密文消耗时间："+(System.currentTimeMillis() - startTime)+"ms");
    }
}
