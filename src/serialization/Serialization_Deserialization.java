package serialization;

import java.io.*;

// objectoutputstream objeleri serileştirerek, java objelerini kodlar ve byte akısına yazdırr.
public class Serialization_Deserialization {
    public static void main(String[] args) {
      //  writeObjects();
        readObjects();


    }
    public static void writeObjects(){
        System.out.println("Objeler olusturuluyor");
        User user1=new User(1,"Yavuz",32);
        User user2=new User(2,"Hakan",28);
        User user3=new User(3,"Yusuf",25);
        User user4=new User(4,"Bahadır",22);


        try {
            //javada dosyaya veri yazabilmemizi sağlar
            //nesnelerin yazdırıldıgı dosyayı olusturmak için
            FileOutputStream fos=new FileOutputStream("user.ser");



            //objeleri yazdırmak için ObjectOutputStream byte cevirir
            //objelerin yazılabilmesi için serileştirilmesi gerekir USer classın Serializable classından implement edilmeli
            ObjectOutputStream output =new ObjectOutputStream(fos);
            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);

            output.close();
            fos.close();




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void readObjects(){

        // javada dosyadakileri okuma işlemlerinde ise fileInputStream kullanılır

        try {
            FileInputStream fis=new FileInputStream("user.ser");
            // dosya içinde obje var ve onları okumak istiyorsak.serialization okuması için objectinput stream
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject(); // file dan gelenin datatipini bilmiyo ben biliyorum casting yapıyorum (User) yazarak
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);

            input.close();
            fis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
