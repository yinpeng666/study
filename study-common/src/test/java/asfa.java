import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class asfa {
    @Test
    public void sddd(){
        List list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,3));
                System.out.println(list);
            },String.valueOf(i)).start();

        }

    }

    @Test
    public void sdd(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,3));
                System.out.println(list);
            },String.valueOf(i)).start();

//            list.add(i);
        }
//        System.out.println(list);
    }


}
