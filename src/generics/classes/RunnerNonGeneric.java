package generics.classes;

public class RunnerNonGeneric {
    public static void main(String[] args) {
        // class tan 2 tane nesne oluşturalım

        NonGenericType nonGenericType1 = new NonGenericType();
        NonGenericType nonGenericType2 = new NonGenericType();
        // string ile set edildi
        nonGenericType1.setObject("Adcvanced Java");

        // int ile set edildi
        nonGenericType2.setObject(123);

        // aynı method farklı 2 data tip ile set edilebildi. method data tipini object yaptıgımız için


       // String str1=nonGenericType1.getObject();
        //her data tipini kullanıyo ama bunu kullanmak isrediğimizde hata veriyo.casting yapmamızı istiyo

        String str1= (String) nonGenericType1.getObject(); // casting yaptık
        System.out.println(str1);

    // String str2= (String) nonGenericType2.getObject(); // int i stringe cast etmeye calsıtık.kodu calıstırınca
    // System.out.println(str2);                          //RTE: ClassCastException hatası alcaz


        //olması gereken
        Integer num=(Integer) nonGenericType2.getObject();
        System.out.println(num);


        // object class ile rte alırız hatayı bulmak zor olur. bu yuzde cte hatası alabildiğimiz generic class cıkmıs.onu kullanmak daha iyi

    }
}
