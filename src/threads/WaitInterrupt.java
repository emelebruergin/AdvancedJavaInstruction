package threads;
/*
Bir öğrencinin banka hesabı için para yatırma(deposit) ve çekme işlemleri(withdraw) için uygulama
Hesapta para yoksa para yatırılması(bakiyenin artması) beklensin.
Bakiye artınca(yeterli olunca) para çekme gerçekleşsin.

wait ve notify: bir yada daha fazla threadin işlemini tamamlayabilmesi için
diğer threadin yapacağı işlemin tamamlanmasının gerektiği durumlarda kullanılır.
 */
public class WaitInterrupt {
    int balance=0;
    public static void main(String[] args) {
     WaitInterrupt object=new WaitInterrupt();
     Thread thread1=new Thread(new Runnable() {
         @Override
         public void run() {
             object.withdraw(1000);
         }
     });
     thread1.setName("tüketici");
     thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                object.deposit(2000);
                thread1.interrupt(); // zorla thread1 i durdurur
                                    // wait(bekeleme) işlemi durduruldu. yani wait e diyorki bekleme boş yere bdevam et
                                    //waitin beklemesini durduruyo. notify 'a destek olan bişey yani.normalden uzun sürüyosa waitin beklemesi zorla devam ettiriyo
            }
        });
        thread2.setName("üretici");
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
                System.out.println("tüketici thread in çalışması zorla kesildi"); // buraya e.getmesaage demeyiz.yoksa hata msjı verir
                System.out.println("Bakiyenizi tekrar kontrol edin");        // waitin kırılmasını ben sağladım o yuzden hata msjı verme benm istediğim msjı ver dedim
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

    }


}

