package generics.interfaces;
// interface'in data tipine karar verilirse class generic olmak zorunda değil. yani T değilde ben String olarak belirleyecem diyebiliyosun
public class GenericInterfaceStringImpl implements GenericInterface <String> {

    @Override
    public void printValue(String value) {

    }

    @Override
    public String getValue() {
        return null;
    }
}
