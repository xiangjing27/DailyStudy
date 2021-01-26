package basic;

import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xiangjing
 * Creation Time: 2021/1/26 09:55
 */
public class RandomNum {

    public static void main(String[] args) {
        int count = 100;
        int min = 0, max = 10000;
        // Math.random
        new RandomImpl() {
            @Override
            protected void random() {
                int i = (int)((Math.random() * (max - min)) + min);
            }
        }.random("Math.random", count);
        // Random.nextInt
        new RandomImpl() {
            @Override
            protected void random() {
                int i = new Random().nextInt(max - min) + min;
            }
        }.random("Random.nextInt", count);
        // ThreadLocalRandom
        new RandomImpl() {
            @Override
            protected void random() {
                int i = ThreadLocalRandom.current().nextInt(min, max);
            }
        }.random("ThreadLocalRandom", count);
        //
        new RandomImpl() {
            @Override
            protected void random() {
                int i = new SplittableRandom().nextInt(max - min) + min;
            }
        }.random("SplittableRandom", count);
        //
        new RandomImpl() {
            @Override
            protected void random() {
                int i = new SecureRandom().nextInt(max - min) + min;
            }
        }.random("SecureRandom", count);
    }

    interface IRandom {
        void random(String key, int count);
    }

    abstract static class RandomImpl implements IRandom {
        @Override
        public void random(String key, int count) {
            long start = System.currentTimeMillis();
            for (int i = 0; i < count; i++) {
                random();
            }
            System.out.println(key + " cost " + (System.currentTimeMillis() - start) + " ms");
        }
        protected abstract void random();
    }
}
