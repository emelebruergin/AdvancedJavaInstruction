package generics.bounding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GenericLowerBoundAndWildcard {
    public static void main(String[] args) {

        System.out.println("------------wildcard ile alltan sınırlama-----------------");
        List<Integer> integerList=new ArrayList<>();
        List<Double> doubleList=new ArrayList<>();
        List<Number> numberList=new ArrayList<>();
        List<Object> objectList=new ArrayList<>();
        List<String> stringList=new ArrayList<>();


        addElements(integerList);
        System.out.println(integerList);

        // addElements(doubleList);
        addElements(numberList);
        addElements(objectList);

        System.out.println("------------wildcard ile üstten sınırlama-----------------");
        multiplyBy2(integerList);
        multiplyBy2(doubleList);
        multiplyBy2(numberList);
       // multiplyBy2(objectList);// listin data tipini üstten Number ile sınırlandırdık o yuzden obbject alamaz


        System.out.println("-----------------List<?--------------->");
        printElements(integerList);
        printElements(doubleList);
        printElements(stringList);

        System.out.println("----------------List<Object>----------------------");
      printObjectElements(objectList);
//        printObjectElements(integerList);
//        printObjectElements(stringList);//List<Object> List<String> in parentı değildir.






    }

        //alttan sınırlama
        //parameterede verilen listeye 1..10 a kadar eleman ekleme
        //Listin data tipi Integer,Number veya Object olsun

    //wildcard(joker):?:bilinmeyen data tipi
    public static void addElements(List<? super Integer> list){

        for (int i=1;i<=10;i++){
            list.add(i);
        }

    }

    //wildcard ile üstten sınırlama
    public static void multiplyBy2(List<? extends Number> list){
        list.stream().map(t->2*t.doubleValue()).forEach(t-> System.out.print(t+"  "));
    }




    //T: buradaki list yapısı herhangi bir data tipini alabilir
    //?: bilinmeyen data tipi  T'den farkı okunabilirliği daha iyi
    //?'nin bazı kısıtlamaları var. Listin data tipi belirginleşmeden add methoduna izin vermiyo.
    public static void printElements(List<?> unknownList){ // hertürlü data tipini kabul ediyo
       // unknownList.add(1); //listin data tipi suan belli değil o yuzden izin vermiyo.methodu cagırdıgımız zaman data tipine karar veriyoruz
        //unknownList.add("java");//listin data tipi suan belli değil o yuzden izin vermiyo. methodu cagırdıgımız zaman data tipine karar veriyoruz

        //****Not : ? okumaya izin verir. ancak değişiklik yapmaya izin vermiyo. mesela eleman ekleme. eleman değiştirme
        //data tipinden bağımsız methodlara izin verir. mesela listenin eleman sayısını bulma. get,remove,size

        unknownList.add(null); // null her data tipine uyar o yuzden kabul eder
        unknownList.forEach(t-> System.out.println(t+" "));

    }


    //List<?> vs List<Object>
    public static void printObjectElements(List<Object> objectList ){

        objectList.add("String");
        objectList.add(12);

        objectList.add(null);
        objectList.forEach(t-> System.out.print(t+" "));

    }





}
