package threads;

public class Multithreading02 {
    public static int counter=0;

    public static void main(String[] args) {

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı");
                Counter.count();

            }
        });
        thread1.setName("Tom");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalışmaya başladı");
                Counter.count();
            }
        });
        thread2.setName("Jery");
        thread2.start();


    }
}

class Counter{
    //counter değişkeninin değerini 1000 kez arttırıp yazdıralım

    public synchronized static void count(){ //bu methoda birden fazla thread ulasmak istediğinde bu erişim sıralı olsun demek için synchronized eklenir
                                            //yani aynı  anda bu methoda sadece bir thread erişebilsin
        for (int i=1;i<=1000;i++){
            Multithreading02.counter++;
            System.out.println(Thread.currentThread().getName()+"Counter: "+Multithreading02.counter);//beklenen değer 1000+1000=2000
        }

    }
}
