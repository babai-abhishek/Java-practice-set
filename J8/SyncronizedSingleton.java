package J8;

/*
* public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor to prevent instantiation
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

* */

/*
This method optimizes the synchronization by checking if the instance is null
before entering a synchronized block. This reduces the overhead of acquiring a lock each time the method is called.
*/

/*
* Double-Checked Locking: The first check for null is performed without synchronization for performance reasons.
*  If the instance is still null, it enters a synchronized block to check again and create the instance.
* */

public class SyncronizedSingleton {
    private static volatile SyncronizedSingleton instance;

    private SyncronizedSingleton() {
        // private constructor to prevent instantiation
    }

    public static SyncronizedSingleton getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (SyncronizedSingleton.class) {
                if (instance == null) { // Second check (with locking)
                    instance = new SyncronizedSingleton();
                }
            }
        }
        return instance;
    }
}
