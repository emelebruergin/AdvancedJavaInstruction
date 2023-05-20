package threads;

import java.util.concurrent.CountDownLatch;

/*
Latch=menteşe.kapının biraz acılmasını sağlayıp oradan istedigimiz kadar geçiş sağlamak
iki threadden birine öncelik vermek.
countdown=geriye sayma
3 threadim var diyelim birine öncelik verdik. öncelik verdiğimiz calısınca sayac 2 ye düşer diğer thread calısır 1  düşer sonra 0 a
 */
/*
bazı threadlerin önce çalışmasını ve
bu arada diğer threadlerin ve main threadin beklemesini
istediğimizde COuntDownLatch ile bir sayaç oluşturulur. Öncelike verdiğimiz
threadler işini tamamladıkça sayaç 0 olana kadar azaltılır.
0 olduğunda ise diğer threadlerin çalışmaya devam etmesine izin verilir.

*/

/*ozetle;
        1- ilk olarak CountDawnLatch objesi olusturulur
        2- önce calismasini istedigimiz thread'lere countDown() methodu cagrilir, bu method sayesinde her bir isini bitiren thread icin sayac geriye saymaya baslar
        3- beklemesini istedigim thread'ler icin ise await() methodunu cagrilir, bu sayede oncelikli olan threadlerin isini bitirmesi beklenir
        4- son olarak cuntDown() methodu 0'a ulastiginda await() methodu bloke olur ve
        bekleyen thread'ler de calismaya baslar.*/
public class CountDownLatch01 {
    public static void main(String[] args) {
        //öncelik vermek istediğin thread e worker thread denir. bunun için ayrı class olusturulur

        CountDownLatch latch=new CountDownLatch(4); // sayac bu. 4 worker isini yapamaya baslayınca 4 ten geri sayar

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await(); //thread 1 worker threadleri beklesin diyorum
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread1 çalışıyor.");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();//thread 2 worker threadleri beklesin diyorum
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread2 çalışıyor.");
            }
        });

        WorkersThreads worker1=new WorkersThreads("worker-1",latch,7000);
        WorkersThreads worker2=new WorkersThreads("worker-2",latch,8000);
        WorkersThreads worker3=new WorkersThreads("worker-3",latch,5000);
        WorkersThreads worker4=new WorkersThreads("worker-4",latch,9000);

        thread1.start();
        thread2.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        try {
            latch.await();//main threadde beklesin diyorum workerların calısması
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread calsıyor");
    }

}

class WorkersThreads extends Thread{

    private int duration;
    private CountDownLatch latch; // countDownLatch in methodlarını kullanabilmek için değişken yaptk sayac için

    public WorkersThreads(String name, CountDownLatch latch, int duration) {  // constructor olusturduk
       super(name);
        this.latch = latch;
        this.duration=duration;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" çalışmaya başladı");

        try {
            Thread.sleep(duration); // duration değişkeni olusturduk her threadin bekleme süresi farklı olsun
                                    // istenebilir thread olustururken sureyide belirlemek için
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" çalışmayı bitirdi");
        latch.countDown(); // sayacı düşürüyo


    }
}
