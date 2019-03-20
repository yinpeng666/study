import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class tfyud {
    public static void main(String[] args) {

        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,4));
                System.out.println(map);
            },String.valueOf(i)).start();

        }

    }
}
