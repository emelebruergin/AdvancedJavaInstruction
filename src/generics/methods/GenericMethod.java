package generics.methods;
//generic methodlar bize nasıl bir kolaylık sağlıyor


import java.util.Arrays;

public class GenericMethod {
    public static void main(String[] args) {

        Integer [] intArr={5,23,68,99,45};
        String [] strArr={"Java","generics","hayatımızı","kolaylaştırır."};
        Double[] doubleArr={0.2,3.5,99.8,66.0};

        System.out.println("----------- generic olmayan metod---------");
        printArr(intArr);
        printArr(strArr);
        printArr(doubleArr);

        System.out.println("----------- generic metod---------");
        printAllArray(intArr);
        printAllArray(strArr);
        printAllArray(doubleArr);

        System.out.println("----------- sonuc donduren metod---------");
        System.out.println("getFirst(intArr) = " + getFirst(intArr));
        System.out.println("getFirst(strArr) = " + getFirst(strArr));
        System.out.println("getFirst(doubleArr) = " + getFirst(doubleArr));

        System.out.println("-----------------------");
        Integer number=88;
        printArrAndObject(strArr,number);

    }

    public static void printArr(Integer[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }

    public static void printArr(String[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }
    public static void printArr(Double[]arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }


    //generic metod

    public static <T> void printAllArray(T[] arr){
        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println();
    }


    // sonuc döndüren generic yapıda bir method olusturma

    public static <T> T getFirst(T[] arr){
       T first= arr[0];
       return first;

    }

    //birden fazla parametre ile generic metod
    public static <T,U> void printArrAndObject(T[] arr, U object){

       // arr[0]=object; t tipindeki arr'e u tipindeki objecti koyamazsın.farklı tipte datalar cte verir

        Arrays.stream(arr).forEach(t-> System.out.print(t+" "));
        System.out.println("-------"+object);
    }

}
