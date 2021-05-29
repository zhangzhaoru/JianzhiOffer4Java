import java.util.ArrayList;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: PACKAGE_NAME
 * @Author: ZhangZhaoru
 * @Date: 2021/4/29 4:53 下午
 * @Description:
 */
public class Test {

    Byte[] array = new Byte[1024 * 1024];//1MB

    public static void main(String[] args) {
        ArrayList<Test> list = new ArrayList<>();
        int count = 0;

        //Throwable
        //Exception
        //Error
        try {
            while (true) {
                list.add(new Test());
                count = count + 1;
            }
        } catch (Error e) {
            System.out.println(count);
            e.printStackTrace();
        }
    }
}

