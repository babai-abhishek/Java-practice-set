package Others.Mutithreading;

class SharedResource {
    private int item;
    private boolean available = false;

    // synchronized method to ensure only one thread accesses it at a time
    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            // If an item is already available, wait until it's consumed
            wait();
        }
        item = value;
        System.out.println("Produced: " + item);
        available = true;
        // Notify the consumer that a new item is available
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            // If no item is available, wait until one is produced
            wait();
        }
        System.out.println("Consumed: " + item);
        available = false;
        // Notify the producer that the item has been consumed
        notify();
        return item;
    }
}

