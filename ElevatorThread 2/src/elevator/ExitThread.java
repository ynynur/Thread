package elevator;

import java.util.ArrayList;
import java.util.Random;

public class ExitThread extends Thread {

    private Avm avm;

    public ExitThread(Avm avm) {
        this.avm = avm;
    }

     /* 1000 ms zaman aralıklarıyla [1-5] arasında rastgele sayıda müşterinin AVM’den çıkış yapmasını sağlamaktadır
    (Zemin Kat).
    Çıkmak isteyen müşterileri rastgele bir kattan (1-4), zemin kata gitmek için asansör kuyruğuna alır.
   */

    @Override
    public void run() {

        while(true){
            try {
                Random rand= new Random();
                int cikisMusteriSayisi=rand.nextInt(5)+1;
                for(int i = 0 ; i< cikisMusteriSayisi;i++){
                    int cikacakKisiKat = rand.nextInt(4)+1;
                    avm.addKuyruk((cikacakKisiKat-1),(new Person(cikacakKisiKat,0)));
                    //cıkacak kisinin oldugu kattan kuyruğa bir person nesnesi ekle
                    //kat bilgisi ve varıs noktası=0 contructorunu cağırdım
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
