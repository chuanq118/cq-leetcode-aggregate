package interview.design;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class 多人抢红包 {


    static class HongBao {
        private volatile BigDecimal totalNum;
        private volatile int leftPartition;
        private final ReentrantLock lock;

        public HongBao(double totalNum, int totalPartition) {
            this.totalNum = BigDecimal.valueOf(totalNum);
            this.leftPartition = totalPartition;
            this.lock = new ReentrantLock();
        }

        public double fetch(){
            if (leftPartition <= 0){
                return 0.0;
            }
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 线程开抢");
                if (leftPartition <= 0) {
                    return 0.0;
                }
                if (leftPartition == 1) {
                    leftPartition -= 1;
                    return totalNum.doubleValue();
                }
                // ThreadLocalRandom.current()
                BigDecimal MIN_DEC = BigDecimal.valueOf(0.01);
                BigDecimal reserveNum = MIN_DEC.multiply(BigDecimal.valueOf(leftPartition));
                BigDecimal maxNum = totalNum.subtract(reserveNum);
                BigDecimal fetched_dec = BigDecimal.valueOf(new Random().nextDouble()).multiply(maxNum);
                fetched_dec = fetched_dec.setScale(2, RoundingMode.HALF_UP);
                fetched_dec = fetched_dec.add(MIN_DEC);
                totalNum = totalNum.subtract(fetched_dec);
                leftPartition -= 1;
                return fetched_dec.doubleValue();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        HongBao hongBao = new HongBao(100, 3);
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                double fetched = hongBao.fetch();
                System.out.println(Thread.currentThread().getName() + " fetch " + fetched);
            }, "THREAD-" + i).start();
            latch.countDown();
        }
    }
}
