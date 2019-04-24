import java.util.*;
import java.util.concurrent.*;

public class FoodTester {

	public static final Food POISON_PILL = new Food("asldkjfasldkfjasdf", Integer.MAX_VALUE, Integer.MAX_VALUE);

	public static void main(String[] args) {
		List<Food> foodList = new ArrayList<>();
		foodList.add(new Food("Spinach Dip", 2, 1));
		foodList.add(new Food("Burger", 5, 1));
		foodList.add(new Food("Pasta", 4, 3));
		foodList.add(new Food("Baked Alaska", 6, 20));
		foodList.add(new Food("Salad", 1, 1));
		foodList.add(new Food("Bruchetta", 3, 1));
		foodList.add(new Food("Bread", 1, 1));
		foodList.add(new Food("Fried Green Tomatoes", 2, 1));
		BlockingQueue <Food> queue = new LinkedBlockingQueue<>(3);
		CountDownLatch countDownLatch = new CountDownLatch(foodList.size());
		Thread cookThread = new Thread((new CookThread(queue, foodList)));
		Thread serveThread = new Thread(new ServeThread(queue, countDownLatch, foodList.size()));
		long startTime = System.currentTimeMillis();
		cookThread.start();
		serveThread.start();
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
		    Thread.interrupted();
		}
		long totalDuration = System.currentTimeMillis() - startTime;

		// USE STREAMS HERE ON THE INITIAL LIST!
		// NOTE: THIS PART HAS NOTHING TO DO WITH THE THREADS- JUST MORE STREAM PRACTICE! :)
		// USE METHOD REFERENCES!
		int totalCookTime = foodList.stream().mapToInt(Food::getCookTime).sum();
		int totalServeTime = foodList.stream().mapToInt(Food::getServeTime).sum();
		System.out.println("Total Cook Time = " + totalCookTime);
		System.out.println("Total Serve Time = " + totalServeTime);
		System.out.println("Program Time = " + totalDuration);

	}

}
