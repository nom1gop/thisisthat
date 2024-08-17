import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

import static java.lang.System.out;

public class RedisTest {
    private static final int SLEEP = 1000;
    public static void main(String[] args) throws InterruptedException {

            RedisStorage redis = new RedisStorage();
            redis.init();
            redis.registerUsers();

            int i = 0;
            while (true) {
                if (i == 10) {
                        String donater = redis.getOnlineUsers().stream().collect(Collectors.toList()).get(new Random().nextInt(20));
                        out.println("> " + donater + " оплатил услугу");
                        out.println("- На главной странице показан " + donater);
                        redis.getOnlineUsers().add(new Date().getTime()/100, donater);
                        i = 0;
                        Thread.sleep(SLEEP);
                        }
                String user = redis.getOnlineUsers().first();
                out.println(user);
                redis.getOnlineUsers().add(new Date().getTime() / 100, user);
                Thread.sleep(SLEEP);
                i++;
//                int i = 1;
//                for (String user : redis.getOnlineUsers()) {
//                    out.println("- На главной странице показан " + user);
//                    redis.getOnlineUsers().add(new Date().getTime() / 1000, user);
//                    Thread.sleep(SLEEP);
//                    if (i == 10) {
//                        String donater = redis.getOnlineUsers().stream().collect(Collectors.toList()).get(new Random().nextInt(20));
//                        out.println("> " + donater + " оплатил услугу");
//                        out.println("- На главной странице показан " + donater);
//                        redis.getOnlineUsers().add(new Date().getTime()/1000, donater);
//                        i = 0;
//                        Thread.sleep(SLEEP);
//                    }
//                    i++;
            }
    }
}
