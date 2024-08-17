import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import java.util.Date;
import static java.lang.System.out;

    public class RedisStorage {

        // Объект для работы с Redis
        private RedissonClient redisson;

        // Объект для работы с ключами
        private RKeys rKeys;

        // Объект для работы с Sorted Set'ом
        private RScoredSortedSet<String> onlineUsers;

        private final static String KEY = "ONLINE_USERS";
        private final int USERSCOUNT = 20;

        private double getTs() {
            return new Date().getTime() / 1000;
        }

        void init() {
            Config config = new Config();
            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
            try {
                redisson = Redisson.create(config);
            } catch (RedisConnectionException Exc) {
                out.println("Не удалось подключиться к Redis");
                out.println(Exc.getMessage());
            }
            rKeys = redisson.getKeys();
            onlineUsers = redisson.getScoredSortedSet(KEY);
            rKeys.delete(KEY);
        }

        void shutdown() {
            redisson.shutdown();
        }

        // Регистрация на сайте 20 пользователей
        void registerUsers() throws InterruptedException {
            for (int i = 1; i <= USERSCOUNT; i++) {
                onlineUsers.add(getTs(), "Пользователь " + i);
                Thread.sleep(500);
            }
        }

        // Получаем список пользователей
        public RScoredSortedSet<String> getOnlineUsers() {
            return onlineUsers;
        }
    }
