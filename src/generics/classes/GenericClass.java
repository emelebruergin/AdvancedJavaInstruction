package generics.classes;
///ONEMLİ: Generic ler primitive data tipleri ile kullanılamaz.
public class GenericClass <T>{
     /*
    E --> Element, collection gibi yapılarda kullanılır
    K --> Key
    V --> Value
    N --> Number
    T --> Type
    S,U,V , vb --> 2., 3. ve 4. tipler için
     */
     private T type;//her data tipini referans alabilen bir field

        //getter-setter


    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }
}
