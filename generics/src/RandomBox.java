import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBox<T> {

    private List<T> items = new ArrayList<>();

    private Random rnd = new Random();

    public RandomBox() {
    }

    public void addItem(T newItem) {
        items.add(newItem);
    }

    public T drawWinner() {
        return items.get(rnd.nextInt(items.size()));
    }

    public void displayEntries() {

        boolean first = true;
        System.out.print("RandomBox: ");
        for (T item : items) {
            if (!first) {
                System.out.print(",");
            } else {
                first = false;
            }
            System.out.print(item);
        }
        System.out.println("");

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RandomBox{");
        sb.append("items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
