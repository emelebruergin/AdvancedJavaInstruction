package generics.interfaces.example;

//Account ile ilgili database işlemlerini burda yapcam
public class AccountRepo implements Repository <Account>{

    @Override
    public void save(Account object) {

    }

    @Override
    public Account get() {
        return null;
    }
}
