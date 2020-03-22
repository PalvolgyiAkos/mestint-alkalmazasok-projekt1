package UtesSzamlalo;

import java.util.Objects;

/*
    A Koordináták egyszerű kezelésére szolgáló osztály
 */
public class Koordinata {
    private int x;
    private int y;

    public Koordinata(int y, int x) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Koordinata that = (Koordinata) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
