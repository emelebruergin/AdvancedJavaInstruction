package enumTypes;

public enum TransactionTypeEnum {
    DEPOSIT(10), // 0   her bir elemanın indexi sırası vardır
    WITHDRAW(20),// 1
    TRANSFER(30),// 2
    PAYMENT(40), // 3
    OTHER(50);   // 4 bu değerler ordinal değerlerdir

    private final int code;
    //private final String name; istediginiz kadar field eklenebilir

    public int getCode() {
        return code;
    }

    TransactionTypeEnum(int code) { // default değeri private tır.
        this.code = code;
    }
}
