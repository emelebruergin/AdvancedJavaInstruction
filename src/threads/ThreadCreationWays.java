package threads;

public class ThreadCreationWays {
    public static void main(String[] args) {
        System.out.println("Mevcut thread: "+ Thread.currentThread().getName()); // suanda calısan mevcut threadin ismi

        //Thread extend ederek
        MyThread thread1=new MyThread(); // Thread i extend eden class olusturdum ve ordan obje olusturdum
        thread1.start();//override edilen run metodunu cagırır ve threadi baslatır
       // thread1.run();//sadece run method içinde ki kodlar calsıır. main içinde yazdıgımız herhangi kod gibi calsıır.coklu işlem baslamaz.thread olusturulmaz
                      // ben yeni bir thread baslasın istiyosam start() kullanmalıyım. start() ın 1.görevi thread i baslatmak





        //Runnable i implement ederek olustrduk
        MyRunnable myRunnable=new MyRunnable();
        Thread thread2=new Thread(myRunnable);
        thread2.start();
        thread2.setName("yeni thread"); // thread e kendimiz isim vermek istiyorsak

        // Runnable i implement ederek olustrduk daha pratik hali var
        //annonymous (isimsiz) class ile Thread olusturma
        //2.yöntemin pratik hali
        Thread thread3=new Thread(new Runnable() { // MyRunnable classını olusturmadan yapabilirisn Thread(new Runnable içine yazarak
            @Override
            public void run() {
                try {
                    Thread.sleep(5000); // thread3 basladıktan sonra işlemle için 5 saniye beklesin
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bu Thread isimsiz class ile olusturuldu");
            }
        },"threadcik"); //virgül koyup isimde verebiliyosun thread e
        thread3.start();

        try {
            Thread.sleep(10000);//main thread 10 sn bekler.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main threadin işlemi burada bitti");
        System.out.println("main threadin işlemi burada bitti");


//2.yöntemin pratik hali
// new Runnable() lambda ile yazabilirsinn
    Thread thread4=new Thread(()-> { // birden fazla satır yazdırcaksak {} kullanırız
            System.out.println("Bu thread lambda expression ile oluturuldu") ;
        System.out.println("Mevcut thread: "+ Thread.currentThread().getName());
                                    // içinde implemente edilmesii gerekn sadece bir method varsa functional dir
} );
thread4.start();

}







}
//thread olusturmak için
//1.yöntem: Thread classını extend ederek

class MyThread extends Thread{ // class içinde baska class olusturduk
    @Override//threade yaptırmak istediğimiz işlemi
    public void run() {
        System.out.println("Mevcut thread: "+ Thread.currentThread().getName());// thread 0 baslar burda main değil
        System.out.println("MyThread threadi çalışıyor.");
    }
}

//2.yöntem: Runnable interface ini implement etmek
//daha cok tercih edilir. coklu kalıtım oldugu için
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Mevcut thread: "+ Thread.currentThread().getName());// thread 0 baslar burda main değil
        System.out.println("MyRunnable ile oluşturdugumuz  thread çalışıyor.");
    }
}

