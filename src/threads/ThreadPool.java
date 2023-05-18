package threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Threadler oldukca maaliyetli. olusturdugumuz her thread için cpu(memoryde) da kaynak ayrılır.
bu sebeple aynı anda aktif olarak kullanmak istediğimiz threadlerin sayısını sınırlandırabiliriz.

10 tane işim var ama ben 5 threade yaptırmak istiyorum.thread havuzu olustururum havuza bütün threadleri koyarım
aktif olanları calısması gerekenleri calıstırırım.

Thread havuzu maliyeti azaltır, CPU ya aşırı yüklenmeyi önler.
Yeni bir thread oluşturmak yerine belirtilen sayıdaki threadin bir kere başlatılarak
tekrar tekrar kullanılmasını sağlar.
 */
public class ThreadPool {
    public static void main(String[] args) {

       ExecutorService service= Executors.newFixedThreadPool(2);  // aynı anda havuzumda kac threadın calısmasını istiyoruz

        ThreadCreator thread1=new ThreadCreator("A");
        ThreadCreator thread2=new ThreadCreator("B");
        ThreadCreator thread3=new ThreadCreator("C");
        ThreadCreator thread4=new ThreadCreator("D");
        ThreadCreator thread5=new ThreadCreator("E");
        ThreadCreator thread6=new ThreadCreator("F");

   //  thread1.start();
   //  thread2.start();
   //  thread3.start();
   //  thread4.start();
   //  thread5.start();
   //  thread6.start();

        service.execute(thread1); // 6 iş var burda bu 6 işi sadece 2 thread yapar.
        service.execute(thread2);
        service.execute(thread3);
        service.execute(thread4);
        service.execute(thread5);
        service.execute(thread6);  // havuzun içinde 6 tane threadım var ama belirlediğim kadar threadı calıstır

        service.shutdown(); // tüm threaadler calısmayı tamamladıgında havuzu kapatıyoruz.aksi takdirde threadler havuzda beklemeye devam eder.
                            //buda yine cpu nun gereksiz yere calısmasına sebep olur kapatmaz isek.

    }

}

class ThreadCreator extends Thread{
    private String name;

    public ThreadCreator(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+" çalışmaya başladı.");
        System.out.println(threadName+" "+name+" işi yapıyor.");
        //thread bir süre çalışıyor.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(threadName+" işini bitirdi.");

    }
}
