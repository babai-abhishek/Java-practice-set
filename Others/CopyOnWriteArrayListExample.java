package Others;

import java.util.concurrent.CopyOnWriteArrayList;

/*
*If you're working in a multithreaded environment and multiple threads need to modify the collection concurrently,
* consider using CopyOnWriteArrayList or CopyOnWriteArraySet. These collections allow concurrent modifications
* without throwing ConcurrentModificationException by making a copy of the underlying array whenever a write operation occurs.
*/
public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        for (String item : list) {
            if (item.equals("B")) {
                list.remove(item); // No ConcurrentModificationException
            }
        }

        System.out.println(list); // Output: [A, C]
    }
}

