package es1;

import java.util.Date;
import java.util.GregorianCalendar;

public class InfoAdapter implements DataSource{

    private Info info;

    public InfoAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome()+info.getCognome();
    }

    @Override
    public int getEta() {
        Date dataOggi = new Date();

        Date dataNascita = info.getDataDiNascita();

        return (int)((dataOggi.getTime()-dataNascita.getTime())/(1000l*60*60*24*365));
    }
}
