package concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiangjing
 * @version : FairAndUnfairTest, v 0.1 2020-08-04 10:20 xiangjing Exp$
 */
public class FairAndUnfairTest {
    /**
     * public ReentrantLock(boolean fair) { sync = fair ? new FairSync() : new NonfairSync(); }
     */
    private static Lock fairLock = new ReentrantLockTest(true);
    private static Lock unfairLock = new ReentrantLockTest(false);

    public static void main(String[] args) {
        testLock(unfairLock);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("==================");

        testLock(fairLock);
    }

    public static void testLock(Lock lock) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Job(lock), i + "").start();
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        public void run() {
            lock.lock();
            try {
                // 连续多次打印当前Tread和队列中的Thread
                System.out.println(
                    "Lock by ['" + Thread.currentThread().getName() + "'],and waiting " + ((ReentrantLockTest)lock)
                        .getQueuedTheads());
            } finally {
                lock.unlock();
            }
        }

    }

    @SuppressWarnings("serial")
    private static class ReentrantLockTest extends ReentrantLock {
        public ReentrantLockTest(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedTheads() {
            List<Thread> list = new ArrayList<Thread>(super.getQueuedThreads());
            // 翻转集合顺序
            Collections.reverse(list);
            return list;
        }
    }
}
