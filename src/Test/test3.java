package Test;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Will
 * @version 1.0
 * @description: TODO
 * @date 2022/10/17 15:01
 */
public class test3 {
    public static void main(String[] args) throws IOException {
        String str = "hello world";
        FileWriter fw = null;
        try{
            fw = new FileWriter("d:\\hello.txt");
            fw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fw.close();
        }
    }
}
