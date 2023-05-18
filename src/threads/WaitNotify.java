package threads;

import javax.swing.plaf.TableHeaderUI;

/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

wait ve notify: bir yada daha fazla threadin işlemini tamamlayabilmesi için
diğer threadin yapacağı işlemin tamamlanmasının gerektiği durumlarda kullanılır.
 */



/*
sonra calıssın istediğimiz bi müddet calısmasın istediğimiz methoda wait yapıyoruz.
calısmasını istediğimiz diğer thread calıstıktan sonra bekleyen thread calıssın diye notify ile haber verilir thread e
birden fazla bekleyen thread varsa notifyAll(); kullanılır



wait ve notify: bir yada daha fazla threadin işlemini tamamlayabilmesi için
diğer threadin yapacağı işlemin tamamlanmasının gerektiği durumlarda
monitör edilen obje için kullanılır.

wait ve notify: threadler arasındaki iletişimi sağlar

 */
public class WaitNotify {
    public static int balance=0; // her iki thread de bakiyeyi değiştirmeye calıstıgı için sıralı calısma için methodlar synchronized olmalı


    public static void main(String[] args) {
        WaitNotify obj=new WaitNotify();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                obj.withdraw(1000);
            }
        });
        thread1.setName("Ogrenci");
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                obj.deposit(2000);  // önce para yatırma thread i calısmalı . o yuzden para cekmeye wait dedik notify da
                                                // kullandık yatırma işlemi bitince diğerini calıstırsın diye
            }
        });
        thread2.setName("Veli");
        thread2.start();







    }



    //para cekem methodu
    public synchronized void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" para çekmek istiyor..");
        if (balance<=0 || balance<amount){
            System.out.println("Bakiye yetersiz! Mevcut bakiye: "+balance);
            System.out.println("Bakiyenin güncellenmesi bekleniyor");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        //....... bekliyor.notify cağrılınca bekleme sona erer.

        if (balance>=amount){
            balance-=amount;
            System.out.println("Para çekme işlemi gerçekleşti. Mevcut bakiye: "+balance);
        }else {
            System.out.println("Umudunu kaybetme, yarın yine gel...");
        }


}
    //para yatırma işlemi için method
        public synchronized void deposit(int amount){
            System.out.println(Thread.currentThread().getName()+" para yatırmak istiyor..");
            balance+=amount;
            System.out.println("Para yatırma işlemi gerçekleşti. Mevcut bakiye: "+balance);
            notify();//bekleyen thread e bildirim gönderir

            System.out.println("burası calısır");// notify uyarı gönderir ama method içi bitmeden objeyi serbst bırakmaz
        }



}
