import com.sun.tools.javac.util.List;

import java.util.stream.Stream;

/**
 * Streams demo.
 */
public class StreamsDemo {

    public static void main(String[] args) {

        List<String> threadLabels = List.of("B1", "B2", "B3");

        // 1. Example of using method reference
        //    Stream<Thread> threadStream = threadLabels.stream().map(Thread::new);

        // 2. Example of using lambda, equivalent to method reference
        Stream<Thread> threadStream = threadLabels.stream().map(threadLabel -> {
            return new Thread(threadLabel);
        });

        threadStream.forEach(t -> {
            System.out.println("Start thread " + t.getName());
            t.start();
        });

    }
}
