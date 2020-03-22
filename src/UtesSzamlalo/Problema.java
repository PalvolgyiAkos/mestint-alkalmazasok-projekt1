package UtesSzamlalo;

import UtesSzamlalo.Figurak.*;

import java.util.ArrayList;
import java.util.List;

public class Problema {
    private Allapot kezdo = new Allapot();

    private List<Operator> OPERATOROK = new ArrayList<Operator>();

    public Problema() {
        operatorokLetrehozasa("Vezer");
        operatorokLetrehozasa("Bastya");
        operatorokLetrehozasa("Huszar");
        operatorokLetrehozasa("Futo");
        operatorokLetrehozasa("Kiraly");
        operatorokLetrehozasa("Gyalog");
    }

    private void operatorokLetrehozasa(String babuNev) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Babu babu = null;
                switch (babuNev) {
                    case "Vezer":
                        babu = new Vezer(new Koordinata(i, j));
                        break;
                    case "Bastya":
                        babu = new Bastya(new Koordinata(i, j));
                        break;
                    case "Futo":
                        babu = new Futo(new Koordinata(i, j));
                        break;
                    case "Huszar":
                        babu = new Huszar(new Koordinata(i, j));
                        break;
                    case "Kiraly":
                        babu = new Kiraly(new Koordinata(i, j));
                        break;
                    case "Gyalog":
                        babu = new Gyalog(new Koordinata(i, j));
                        break;
                }
                Operator operator = new Operator(babu);
                if (operator.alkalmazhato(kezdo)) {
                    OPERATOROK.add(operator);
                }
            }
        }
    }

    public List<Operator> operatorok() {
        return OPERATOROK;
    }

    public Allapot kezdo() {
        return kezdo;
    }
}
