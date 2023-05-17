package generics.classes;

import java.util.*;

public class RunnerGenericType {
    public static void main(String[] args) {
      //  GenericClass<String> obj1=new GenericClass<String>();
        GenericClass<String> obj1=new GenericClass<>();  // java 7 ile sağdaki Stringi kullanmasakta olur
        obj1.setType("Generic Type");

        String str=obj1.getType(); // castinge gerek kalmadı


        GenericClass<Integer> obj2=new GenericClass<>();
        obj2.setType(12);

        Integer num=obj2.getType();

     // GenericClass<String> obj3=new GenericClass<>();
     // obj3.setType(12); // CTE ile uyarır. int kullandıgım için --> ClassCastExp. önlüyor


        // list olusturulurken herhangi bir data tipi yazmadan kullanmaya --> raw kullanımı denir java 5 ten once.
        // data tipini object kabul ediyo
        //List list=new ArrayList<>();
        List<String > list=new ArrayList<>();
        list.add("Advanced");
        list.add("Java");
       // list.add(12) ; CTE , tür güvenliği sağlanır. ClassCastExp. önlüyor

        Map<String,Integer> map=new HashMap<>();
        map.put("generic",2);
     //   map.put(1,1);CTE , tür güvenliği sağlanır. ClassCastExp. önlüyor


        //=============== ÇOKLU PARAMETRELİ Class=========

        GenericClassTwoParametre<String ,Integer> mymap=new GenericClassTwoParametre<>();
        mymap.setField("java");
        mymap.setType(12);

        System.out.println( mymap.getField() + "------" + mymap.getType());

    }
}
