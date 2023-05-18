package threads;
//synchronized ; metod veya bloklar için kullanılır
//bloğa erişen thread hangi obje ile erişirse bu objeyi monitör etmek için this kullanlır.


//ÖNEMLİ : Threadlerin 1-10 priorityleri(öncelik değeri) vardır . Default değeri:5 . değiştirilebilir. çalışma sırasını azda olsa etkileyebilir

public class SynchronizedKeyword02 {
    public static void main(String[] args) {
        Brackets2 brackets=new Brackets2();

        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }

            }
        });
        thread1.start();

        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=9;i++){
                    brackets.generateBrackets();
                }

            }
        });
        thread2.start();



    }
}


//[[[[[]]]]] şeklini yazdırma
//aynı anda ulasılan method içerisinde asenkron calısmasında problem olmayan kodlar varsa
class Brackets2{
    //synchronized ile metoda ulaşan threadin objeyi monitör(kilitlemek) etmesini sağladık
    public void generateBrackets(){
                              // methodu synchronized etseydik önce for calsıır sonra sout. ama işlemlerin birini synchronized edersek o kendi içinde calsıırken diğerleride calsıır
        synchronized (this){  // bu sekilde synchronized block yaptık bu for döngüsünü.yani thread bu fora ulastıgında calısırken alttaki sout da aynı anda calısır
            for (int i=1;i<=10;i++){   // bu yüzden bu yöntem daha hızlı . yani bir thread bu for'a ulastıgında diğeri bu bitmeden bu for a ulasamaz.. ama alttaki sout a ulasabilir sıra önemli değilse
                if(i<=5){
                    System.out.print("[ ");  // sadece bu kısma 1 thread ulasabilsin dedim işi bitince diğer thread ulassın
                }else{
                    System.out.print("] ");// daha hızlıdır for çalısırken bir yandan diğer kodlarda calsıır
                }
            }
            System.out.println("dvdsvsfd");
        }


        //baska kodlarımda var sıra önemli değil
        System.out.println("dfdgvdfgdf");
    }
}
