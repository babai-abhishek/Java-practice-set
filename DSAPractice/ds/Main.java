package DSAPractice.ds;

public class Main {
    public static void main(String[] args) {
        DemoQueue demoQueue = new DemoQueue(5);
        demoQueue.push(5);
        demoQueue.push(1);
        demoQueue.push(52);
        demoQueue.push(35);
        demoQueue.push(55);
        demoQueue.pop();
        demoQueue.pop();
        demoQueue.push(500);
        demoQueue.push(501);
        demoQueue.print();

    }
}
