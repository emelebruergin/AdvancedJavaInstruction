package enumTypes;

public class Runner {
    public static void main(String[] args) {

        useConstant("DEPOSIT");
        useConstant("TRANSFER");
        useConstant("EFT");//CTE vermez.olusturdugumuz değişken dışında baska sey kullanınca hata vermez

        //sadece sınırlı ve sabit değişkenler kullanabilmek için ENUM type kullanmalıyız...


        useEnumType(TransactionTypeEnum.OTHER);
        useEnumType(TransactionTypeEnum.DEPOSIT);
        useEnumType(TransactionTypeEnum.TRANSFER);
     //   useEnumType(TransactionTypeEnum.EFT); cte verir. enum type da EFT yok .  ENUM TYPE da olusturdugumuz değişken dışında baska sey kullanamzsın
        //final statik yerine enum type kullanmak daha faydalı


    }

    public static void useConstant(String secim){
        if(secim==TransactionTypeConstant.DEPOSIT){
            System.out.println("Para yatırma işlemi seçildi.");
        } else if (secim==TransactionTypeConstant.WITHDRAW) {
            System.out.println("Para çekme işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.TRANSFER) {
            System.out.println("Para transfer işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.PAYMENT) {
            System.out.println("Ödeme işlemi seçildi.");
        }else if (secim==TransactionTypeConstant.OTHER) {
            System.out.println("Diğer işlemler...");
        }
    }

    //aynı işlemi enum type kullanarak yapmak istersek
    public static void useEnumType(TransactionTypeEnum secim){
        if (secim==TransactionTypeEnum.DEPOSIT){
            System.out.println("Para yatırma işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.WITHDRAW) {
            System.out.println("Para çekme işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.PAYMENT) {
            System.out.println("Ödeme işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.TRANSFER) {
            System.out.println("Para transfer işlemi seçildi.");
        } else if (secim==TransactionTypeEnum.OTHER) {
            System.out.println("Diğer işlemler...");
        }
        if (secim.ordinal()==0){ // sıra numarasına göre çağırma
            System.out.println("Para yatırma işlemi seçildi.");// bu kullanım risklidir. yerleri değişir silinir karışır sıra
        }
        
        //code ları nasıl kullanırız
        
        if (secim.getCode()==10){
            System.out.println("Para yatırma işlemi seçildi.");
        }

        //secilen enum type in adını bulmak için
        System.out.println("Enum ismi: "+secim.name());


        //Enum type in hangi sırada oldugunu bulmak için
        System.out.println(secim.ordinal());


        }






}
