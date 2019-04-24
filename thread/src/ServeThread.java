
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ServeThread implements Runnable {

    private final BlockingQueue<Food> queue;
    private final CountDownLatch countDownLatch;
    private final int foodToServe;

    public ServeThread(BlockingQueue<Food> queue,  CountDownLatch countDownLatch, int foodToServe) {
        this.queue = queue;
        this.countDownLatch = countDownLatch;
        this.foodToServe = foodToServe;
    }

    public void serve(Food food) throws InterruptedException {
        System.out.println("SERVER\tSTARTING: " + food);
        Thread.sleep(TimeUnit.SECONDS.toMillis(food.getServeTime()));
        System.out.println("SERVER\tENDING: " + food);
    }

    public void run() {
        System.out.println("SERVER\tREADY");
        for (int i = 0; i < foodToServe; i++) {
            try {
                serve(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.interrupted();
            } finally {
                countDownLatch.countDown();
            }
        }
    }
}
