package net.wwang.utils;

import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.CPInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @BelongsProject: update
 * @BelongsPackage: PACKAGE_NAME
 * @Author: WangWei
 * @CreateTime: 2020-06-11 08:14
 * @Description:
 */
public class UpdateClass {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\Users\\WangWei\\Desktop\\1.class";
        FileInputStream fis = new FileInputStream(filePath);
        DataInput di = new DataInputStream(fis);
        ClassFile cf = new ClassFile();
        cf.read(di);
        CPInfo[] infos = cf.getConstantPool();
        int count = infos.length;
        for (int i = 0; i < count; i++) {
            if (infos[i] != null) {
                System.out.print(i);
                System.out.print(" = ");
                System.out.print(infos[i].getVerbose());
                System.out.print(" = ");
                System.out.println(infos[i].getTagVerbose());
                if (i == 472) {

                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("China No.1").getBytes());
                    infos[i] = utf8Info;
                }
                /*if (i == 1051) {
                   
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("-Baseline Assessment Tool").getBytes());
                    infos[i] = utf8Info;
                }*/
                /*if (i == 1051) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("-Baseline Assessment Tool").getBytes());
                    infos[i] = utf8Info;
                }*/
                /*if (i == 1321) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("     d88P  Y88b                       d88P                              ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 1067) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("     Y88b.                           d88P                               ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 1065) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("      Y888b.   .d88b.  .d8888b     d88P    .d88b. 88888b.  .d88b.       ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 1064) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("         Y88b.d8P  Y8bd88P        d88P    d88...88b888  88bd8P  Y8b     ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 1066) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("           88888888888888        d88P     888   888888  88888888888     ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 1268) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("     Y88b  d88PY8b.    Y88b.    d88P      Y88...88P888  888Y8b.         ").getBytes());
                    infos[i] = utf8Info;
                }
                if (i == 915) {
                    //911,1321,1067,1065,1064,1066,1268,915分别对应banner图从上到下每一行
                    ConstantUtf8Info utf8Info = (ConstantUtf8Info) infos[i];
                    utf8Info.setBytes(("       Y8888P    Y8888  Y8888Pd8888888888    Y88P  888  888 Y88888      ").getBytes());
                    infos[i] = utf8Info;
                }*/
            }
        }
        cf.setConstantPool(infos);
        fis.close();
        File f = new File(filePath);
        ClassFileWriter.writeToFile(f, cf);

    }
}
