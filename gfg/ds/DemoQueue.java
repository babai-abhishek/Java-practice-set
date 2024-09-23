package gfg.ds;

public class DemoQueue {

    int count=0;
    int front=0, rear=0;
    int len=0;
    int array[];

    public DemoQueue(int len) {
        this.len = len;
        this.array = new int[len];
    }

    public boolean isFull(){
        if(len == count){
            System.out.println("Queue is full!!");
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(count == 0){
            System.out.println("Queue is empty");
            return true;
        }
        return false;
    }

    public void push(int item){
        if(!isFull()){
            this.array[rear%len] = item;
            System.out.println("\n");
            System.out.println("pushed "+item);
            print();
            rear++;
            count++;
        }
        return;
    }

    public int pop(){
        if(isEmpty())
            return -1;
        System.out.println("\n");
        int temp = this.array[front%len];
        System.out.println("poped "+temp);
        this.array[front%len] = -1;
        print();
        front++;
        count--;
        return temp;
    }

    public int top(){
        if(isEmpty())
            return -1;
        return array[front];
    }

    public void print(){
        for(int i=0; i<len; i++){
            System.out.print(array[i]+" ");
        }
    }
}
