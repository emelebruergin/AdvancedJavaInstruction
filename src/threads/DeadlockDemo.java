package threads;
/*
deadlockdemo==> ölümcül kilitlenme.
en az 2 veya daha fazla thread işlemlerini tamamlamak için birbirinin monitör(kilitlemiş) oldugu objeyi kullanmak
istemesi gibi durumlarda meydana gelir.
Buda uygulamayı olumsuz etkiler hatta uygulamayıcevap veremez hale getirebilir.
genellikle iç iç synchronized blok kullanıldıgında yasanır

 */
public class DeadlockDemo {
    //tom kahveyi kullanırken jeryy kahve istiyor program kilitlenir.
    //
    public static void main(String[] args) {
        String kahve = "kahve";
        String seker = "şeker";

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (kahve) {
                    System.out.println(Thread.currentThread().getName() + " " + kahve + " yi kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + seker + " i istiyor.");
                    synchronized (seker) {
                        System.out.println(Thread.currentThread().getName() + " " + seker + " yi kullanıyor.");
                    }//seker serbest
                }//kahve serbest
                System.out.println(Thread.currentThread().getName() + " sıcak suyu da ekledi, kahvesini içiyor...");
            }
        }, "Tom");
        //thread1.setName();
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (seker) {
                    System.out.println(Thread.currentThread().getName() + " " + seker + " i kullanıyor.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " " + kahve + " i istiyor.");
                    synchronized (kahve) {
                        System.out.println(Thread.currentThread().getName() + " " + kahve + " yi kullanıyor.");
                    }//kahve serbest
                }//seker serbest
                System.out.println(Thread.currentThread().getName() + " sıcak suyu da ekledi, kahvesini içiyor...");

            }
        });
        thread2.setName("Jerry");
        thread2.start();
    }
}

