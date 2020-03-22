package UtesSzamlalo;

import UtesSzamlalo.Figurak.Babu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Allapot {
    private int palya[][];
    private final List<Koordinata> koordinatak = new ArrayList<>();
    private List<Babu> babuk = new ArrayList<>();

    /*
        Létrehozzuk a kezdőállapotot
     */
    public Allapot() {
        palya = new int[8][8];
        palya[0][1] = 1;
        koordinatak.add(new Koordinata(0, 1));
        palya[0][3] = 6;
        koordinatak.add(new Koordinata(0, 3));
        palya[2][4] = 2;
        koordinatak.add(new Koordinata(2, 4));
        palya[4][4] = 0;
        koordinatak.add(new Koordinata(4, 4));
    }

    /*
        Cél állapot ellenőrzése
     */
    public boolean cel() {
        boolean nyertem = true;
        for (int[] y : palya) {
            for (int x : y) {
                if (x != 0) {
                    nyertem = false;
                }
            }
        }
        return nyertem;
    }

    /*
        Figyeli, hogy ne legyen többször ütve egy szám
     */
    public boolean rosszLepes() {
        boolean eredmeny = false;
        for (int[] y : palya) {
            for (int x : y) {
                if (x < 0) {
                    eredmeny = true;
                }
            }
        }
        return eredmeny;
    }

    /*
        Egy mező értékét adja vissza
     */
    public int getMezo(Koordinata koordinata) {
        return palya[koordinata.getY()][koordinata.getX()];
    }

    /*
        Csökkenti a mező értékét
     */
    public void utMezo(Koordinata koordinata) {
        palya[koordinata.getY()][koordinata.getX()]--;
    }

    /*
        Állapot kiíratása konzolra
     */
    public void kiir() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int babuPozicio = -1;
                for (Babu babu : babuk) {
                    if (babu.getY() == i && babu.getX() == j) {
                        babuPozicio = babuk.indexOf(babu);
                    }
                }
                if (babuPozicio != -1) {
                    System.out.print(babuk.get(babuPozicio).getClass().getSimpleName().charAt(0) + " ");
                } else {
                    System.out.print(palya[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int[][] getPalya() {
        return palya;
    }

    public void setPalya(int[][] palya) {
        this.palya = palya;
    }

    public List<Koordinata> getKoordinatak() {
        return koordinatak;
    }

    public List<Babu> getBabuk() {
        return babuk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Allapot allapot = (Allapot) o;
        return Arrays.equals(palya, allapot.palya) &&
                Objects.equals(koordinatak, allapot.koordinatak) &&
                Objects.equals(babuk, allapot.babuk);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(koordinatak, babuk);
        result = 31 * result + Arrays.hashCode(palya);
        return result;
    }
}
