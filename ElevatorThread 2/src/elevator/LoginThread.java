package elevator;

import java.util.ArrayList;
import java.util.Random;

public class LoginThread extends Thread {
    private Avm avm ; //avm nesnesini tutmak için değişkenimiz
    public LoginThread(Avm avm){
        this.avm=avm;
    }

    /*500 ms zaman aralıklarıyla [1-10] arasında rastgele sayıda müşterinin AVM’ye giriş yapmasını sağlamaktadır
    (Zemin Kat).
   Giren müşterileri rastgele bir kata (1-4) gitmek için asansör kuyruğuna alır.
    */

    @Override
    public void run() {
        while(true){
            try {
                Random rand= new Random();
                int girisMusteriSayisi=rand.nextInt(10)+1 ; // (0-9)+1 = 1-10 arasında sayı al
                System.out.println("Giren:"+girisMusteriSayisi);
                for(int i = 0 ; i< girisMusteriSayisi;i++){
                    int varisKati = rand.nextInt(4)+1; // rastgele kat bilgisi al
                    avm.addGirisKuyruk(new Person(varisKati));
                    // kat bilgisini hedef edinen person objesi olusturup giriş kuyruğuna ekliyorum
                }
                avm.girisKuyrukGoster();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
