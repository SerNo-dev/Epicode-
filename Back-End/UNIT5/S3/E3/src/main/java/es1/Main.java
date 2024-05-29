package es1;

import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Info info = new Info();
        info.setNome("Mario");
        info.setCognome("Rossi");
        info.setDataDiNascita(new GregorianCalendar(2000, 6,9).getTime());

        InfoAdapter infoAdapter = new InfoAdapter(info);

        UserData userData = new UserData();
        userData.getData(infoAdapter);

        System.out.println(userData);
    }
}
