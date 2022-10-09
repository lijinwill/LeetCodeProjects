package A_Coding_Test.TongHuaShun;


import java.lang.reflect.*;
public class test1 {
    public static void main(String[] args) throws Exception {
        Class<?> classType = Class.forName("java.lang.String");
        Method[] methods = classType.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }
}