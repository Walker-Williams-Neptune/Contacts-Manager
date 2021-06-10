package util;

public class InputTest {


    public static void main(String[] args) {
        Input in = new Input();

//        System.out.println(in.getString());
//        System.out.println(in.yesNo());
//        System.out.println(in.getInt());
//        System.out.println(in.getInt(1, 10));
//        System.out.println(in.getDouble());
//        System.out.println(in.getDouble(1.5, 9.5));


        // Exception handling
        System.out.println(in.getIntStr());
        System.out.println(in.getDoubleStr());

    }
}
