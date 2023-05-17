package generics.bounding;
//parametre olarak aldıgımız data tipini sınırlandıyabiliyoruz.
//T:Integer,Double,Float vs
//burada sadece number ve childları kullanılabilcek
public class GenericUpperBound <T extends Number> {  // bu classta sadece numeric dataların kullanılmasını istiyorum Number'ı extend ederiz

    private T[] numberArray;

    public GenericUpperBound(T[] numberArray) {
        this.numberArray = numberArray;
    }

    //array içindeki değerlerin ortalamasını bulan bir method olusturalım

    public double getAverage(){
        double sum=0;
        for (T w:numberArray){
            sum+=w.doubleValue(); // gelen T tipindeki hangi data tipinde olursa olsun  w 'yu double tipine döndürdük. sum double çünkü

        }
        double avg=sum/this.numberArray.length;
        return avg;
    }

    public static void main(String[] args) {
        Integer[] intArr={3,5,10,8,9};
        GenericUpperBound<Integer> obj1=new GenericUpperBound<>(intArr);
        System.out.println(obj1.getAverage());

        Double[] doubles={3.0,0.5,1.5,2.5};
        GenericUpperBound<Double> obj2=new GenericUpperBound<>(doubles);
        System.out.println(obj2.getAverage());

        String[] strings={"Java","generics","üstten","sınırlandırılabilir."};
      //  GenericUpperBound<String> obj3=new GenericUpperBound(strings); //T daat tipini number ile sınırlandırdık String olmaz


    }
}
