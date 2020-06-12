package net.wwang.rsa;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.rsa
 * @Author: WangWei
 * @CreateTime: 2020-05-13 15:27
 * @Description: RSA加密工具类：非对称加密，公钥可以直接放在H5，APP等前端程序中，
 * 即使被拿到，想要用公钥破解出私钥也是极难的。  先决定密钥长度后生成一套一对一关系的公私钥。
 * 公钥提供给前端，私钥放在服务端。
 * 通过RSA公钥加密明文，加密后的密文发到服务端，服务端用RSA私钥解密得出明文
 */
public class RsaUtils {
    /**
     * 密钥长度，长度越长速度越慢
     */
    private  final  static  int KEY_SIZE = 1024;

    /**
     * 封装随机产生的公钥和私钥
     */
    private static Map<Integer,String> keyMap = new HashMap();
    /**
     * 随机生成密钥对
     */
    public static Map<Integer,String> genKeyPair() throws NoSuchAlgorithmException{
        //基于RSA算法的公钥和私钥生成类
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        //初始化密钥生成对
        keyPairGen.initialize(KEY_SIZE, new SecureRandom());
        //生成一个密钥对保存在keypair当中
        KeyPair keyPair = keyPairGen.genKeyPair();
        //获取私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        //获取公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        /*得到公钥和私钥字符串*/
        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        //将公钥和私钥保存到Map
        /* 0：公钥； 1：私钥*/
        keyMap.put(0,publicKeyString);
        keyMap.put(1,privateKeyString);
        return  keyMap;
    }
    /**
     * RSA公钥加密
     *
     * @param str 加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     * NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,InvalidKeyException,
     * UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        byte[] strBytes = str.getBytes("UTF-8");
        //base64编码的公钥
        byte[] decode = Base64.getDecoder().decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        //RSA算法加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubKey);
        String s = Base64.getEncoder().encodeToString(cipher.doFinal(strBytes));
        return s;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 明文
     * @throws Exception 解密过程中的异常信息
     * BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException,
     * NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException
     */
    public static  String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.getDecoder().decode(str);
        //base64加密后的私钥
        byte[] decode = Base64.getDecoder().decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decode));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,priKey);
        String s = new String(cipher.doFinal(inputByte));
        return s;
    }
}
