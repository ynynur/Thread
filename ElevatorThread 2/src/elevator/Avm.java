package elevator;

import java.util.ArrayList;

public class Avm {

    private ArrayList<Person>[] kuyruklar= new ArrayList[4]; // 4 katın kuyruğunu tutan
    private ArrayList<Person> girisKuyruk= new ArrayList<Person>(); // giriş kuyrugunu tutan liste
    private int[] kattakiler={100,100,100,100} ; // default olarak her katta 100 kişi olsun
    // synchronized ile her fonksiyona tek seferde bir threadin ulasmasını sağlıyor
    private int cikanKisi=0;

    public Avm() {
    }

    public int getCikanKisi() {
        return cikanKisi;
    }

    public void setCikanKisi(int cikanKisi) {
        this.cikanKisi=this.cikanKisi+cikanKisi;
    }

    public Avm(ArrayList<Person>[] kuyruklardakiInsan) {

        this.kuyruklar = kuyruklardakiInsan;
    }

    public void setKuyruklar(ArrayList<Person>[] kuyruklar) {
        this.kuyruklar = kuyruklar;
    }

    public synchronized ArrayList<Person>[] getKuyruklar() {
        return kuyruklar;
    }

    public void setKattakiler(int[] kattakiler) {
        this.kattakiler = kattakiler;
    }

    public synchronized void setKattakiler(int ekle,int kat) { // ISTENILEN KATA ISTENILEN SAYIDA INSAN EKLE
        this.kattakiler[kat]+=ekle;
    }

    public void setGirisKuyruk(ArrayList<Person> girisKuyruk) {
        this.girisKuyruk = girisKuyruk;
    }

    public synchronized ArrayList<Person> getGirisKuyruk() {
        return girisKuyruk;
    }




    public void kuyruklariGoster(){
        for(int i = 0;i<4;i++){
            System.out.println("Kat: "+ i);
            for(int j=0;j< kuyruklar[i].size();j++){

                System.out.print("-"+(kuyruklar[i].get(j).getVarisNoktasi()));
            }
        }
    } //kuyrukların bilgilerini kat ile kattaki kuyruklardaki insanların varıs noktalarını yazdıran fonksiyon,
    // kontrol amaçlı




    public void girisKuyrukGoster(){
        System.out.println("Giris kat kuyruk uzunlugu: "+girisKuyruk.size());
    }

    public int kuyrukTotalInsan(){
        int toplam=0;
        for(int i =0;i<kuyruklar.length;i++){
            toplam=toplam+kuyruklar[i].size();
            System.out.println(i+1+"."+"kat kuyruk:" +kuyruklar[i].size());

        }
        toplam=toplam+girisKuyruk.size();
        System.out.println("Tüm katlardaki toplam kuyruk:" +toplam);

        return toplam;
    } //tüm kuyruklardaki toplam insan sayısı


    public synchronized Person kuyrukIndir(int kat){

        return (kuyruklar[kat].remove(0));

    } //verilen kat kuyrugunda en öndeki kisiyi sil ve döndür

    public int[] getKattakiler() { // KATLARDAKI KISI SAYILARINI TUTAN DIZIYI DONDUR
        return kattakiler;
    }

    public synchronized Person girisBindir(){

        return girisKuyruk.remove(0);

    }//giriş kuyrugunun en önündeki kişiyi sil ve döndür

    public synchronized void addGirisKuyruk(Person person) {
        this.girisKuyruk.add(person);
    } //giriş kuyrugunun sonunda verilen person nesnesini ekle

    public synchronized void  addKuyruk(int kat, Person person){
        kuyruklar[kat].add(person); //verilen kattaki kuyruk sonuna verilen person nesnesini ekle
    }
}
