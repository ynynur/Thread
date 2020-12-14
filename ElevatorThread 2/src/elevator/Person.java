package elevator;

public class Person { //insanları tutmak icin
    private int guncelPozisyon; // güncel kat
    private int varisNoktasi;// varmak istenilen kat


    public Person(int varisNoktasi) {
        this.guncelPozisyon=0;
        this.varisNoktasi = varisNoktasi;
    }

    public Person(int guncelPozisyon, int varisNoktasi) {
        this.guncelPozisyon = guncelPozisyon;
        this.varisNoktasi = varisNoktasi;
    }

    public void showMeYourInformation(){
        System.out.println("Guncel Pozisyon: "+ guncelPozisyon+
                "\nVaris Kati: "+ varisNoktasi);
    }


    public int getGuncelPozisyon() {
        return guncelPozisyon;
    }

    public void setGuncelPozisyon(int guncelPozisyon) {
        this.guncelPozisyon = guncelPozisyon;
    }

    public int getVarisNoktasi() {
        return varisNoktasi;
    }

    public void setVarisNoktasi(int varisNoktasi) {
        this.varisNoktasi = varisNoktasi;
    }
}
