package task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.*;

public class Restaurant {

    private Lock lock =new ReentrantLock();

    private Condition condition =lock.newCondition();

    private  String  dish;

    public  void  product(String cook){
        try {
            lock.lock();

            while (dish != null){
                condition.await();
            }

            dish=cook;

            System.out.println("Ovqat tayor");
            condition.signalAll();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public  void  consumer(){
        try {
            lock.lock();
            while (dish==null){
                condition.await();
            }
            System.out.println("Ovqat olindi");
            dish=null;
            condition.signalAll();
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
