import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试堆内存溢出
 * 总结：其实发生OOM的线程一般情况下会死亡，也就是会被终结掉，该线程持有的对象占用的heap都会被gc了，释放内存。
 * 因为发生OOM之前要进行gc，就算其他线程能够正常工作，也会因为频繁gc产生较大的影响。
 * @author DragonSwimDiving
 * @program rewritespring
 * @Date 2019-06-26 17:38
 **/

public class TestThreadOOM {
    public static void main(String[] args) {
        new Thread(() -> {
            List<byte[]> list = new ArrayList<byte[]>();
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                byte[] b = new byte[1024 * 1024 * 1];
                for (int i=0;i<5;i++){
                    b[i]= (byte) i;
                }
                list.add(b);
                System.out.println(list.toString());
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 线程二
        new Thread(() -> {
            while (true) {
                System.out.println(new Date().toString() + Thread.currentThread() + "==");
                List<byte[]> list = new ArrayList<byte[]>();
                while (true) {
                    System.out.println(new Date().toString() + Thread.currentThread() + "==");
                    byte[] b = new byte[1024 * 2 * 1];
                    for (int i = 0; i < 5; i++) {
                        b[i] = (byte) i;
                    }
                    list.add(b);
                    System.out.println(list.toString());
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
