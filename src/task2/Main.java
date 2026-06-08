package task2;

public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        String[]array={"Shavla","Norin","Maxsus","Kabob"};

        for (int i = 0; i < array.length; i++){
            final int index= 1;
            new Thread(()->{

                restaurant.product(array[index]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < 4; i++) {
            new  Thread(()-> {

                restaurant.consumer();
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
            }).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
