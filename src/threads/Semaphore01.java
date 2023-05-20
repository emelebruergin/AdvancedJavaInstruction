package threads;
/*
Semaphore , ortak kaynaga birden fazla thread ulasmaya calsıtıgında birden fazla bizim belirledigimiz sayıda thread
aynı anda ulasabilsin diye kullanılır. sychronizedden farkı bu. sychronize da tek bir thread ulasabiliyodu
 */
/*
Semaphore, birden fazla threadin ortak bir kaynağa erişmek istediği durumlarda
erişen threadlerin sayısının sınırlandırılmasını sağlar.

Synchronized aynı anda sadece 1 threadin erişimine izin verirken,
semaphore n tane threadin erişimine izin verir.
*/



import java.util.concurrent.Semaphore;

public class Semaphore01 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4); // işi aynı anda yapmak için kac threade izin vercen

        Car car1=new Car("Honda",5000,semaphore);
        Car car2=new Car("BMW",6000,semaphore);
        Car car3=new Car("Toyota",4000,semaphore);
        Car car4=new Car("Volvo",5000,semaphore);
        Car car5=new Car("Tofaş",3000,semaphore);
        Car car6=new Car("Audi",2000,semaphore);
        Car car7=new Car("Anadol",6000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();

    }


}

class Car extends Thread{
    private String carName;
    private int duration;
    private Semaphore semaphore;          //Semaphore classının methodlarını kullanabilmek için

    //parametreli const


    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(carName+" park etmek istiyor");
        try {
            semaphore.acquire();//park etmek için izin belgesi talep ediyoruz // izin verilecek thread sayısı dolmamıssa erişim için izin veriliyor
            Thread.sleep(2000);
            System.out.println(carName+"  park etti ");//eğer izin verilmişsse
            System.out.println(carName+" park yerinde bekliyor");
            Thread.sleep(duration);
            System.out.println(carName+" park yerini terk ediyor");
            semaphore.release(); //izin belgesini teslim etmek istiyor. alan boşaldı diye haber vermek gibi.erişim için bir threadlik alan var
                                 //daha sonra diğer thread için alanın kullanılması için teslim ediyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

