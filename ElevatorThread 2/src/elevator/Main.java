package elevator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

      
        ArrayList <Person> kuyruk1 = new ArrayList<Person>();
        ArrayList <Person> kuyruk2 = new ArrayList<Person>();
        ArrayList <Person> kuyruk3 = new ArrayList<Person>();
        ArrayList <Person> kuyruk4 = new ArrayList<Person>();
        for(int i = 0; i< 5 ;i++){ // her katın kuyruguna 5 kişi ekle
            kuyruk1.add(new Person(1,0));
            kuyruk2.add(new Person(2,0));
            kuyruk3.add(new Person(3,0));
            kuyruk4.add(new Person(4,0));

        }

        ArrayList[] kuyruklar={kuyruk1,kuyruk2,kuyruk3,kuyruk4}; // kuyrukları liste icine at
        Avm avm = new Avm(kuyruklar);

        ControlThread control= new ControlThread(avm);
        LoginThread loginThread = new LoginThread(avm);
        ExitThread exit = new ExitThread(avm);
        loginThread.start();
        control.start();
        exit.start();


    }
}
