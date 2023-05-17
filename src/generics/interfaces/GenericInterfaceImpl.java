package generics.interfaces;
// generic interface'i implement eden class da generic olmak zorunda yani class isminden sonra <T> yazılmalı
public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    @Override
    public void printValue(T value) {
        System.out.println("Bu methodda istediğimiz data tipini parametre olarak alabiliriz");
    }

    @Override
    public T getValue() {
        return null;
    }
}
