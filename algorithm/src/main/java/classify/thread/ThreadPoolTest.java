package classify.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: yushuang
 * @email: yushuang@qiyi.com
 * @date: 2021/2/4
 * @description:
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newScheduledThreadPool(10);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "aa";
            }
        });

        List<FutureTask> futureTasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futureTasks.add(new FutureTask(new Callable() {
                @Override
                public String call() throws Exception {
                    return "aa";
                }
            }));
        }

//        executor.submit()
////        for (int i = 0; i < 10; i++) {
////            executor.submit(new Callable<String>() {
////                @Override
////                public String call() throws Exception {
////                    return "aa";
////                }
////            });
////        }



    }
}
