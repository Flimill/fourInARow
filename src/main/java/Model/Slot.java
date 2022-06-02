package Model;

public class Slot {
    public int posX;
    public int posY;

    public boolean isNotEmpty;

    public Constants belonging;

    public Slot(int x, int y, boolean isNotEmpty, Constants belonging) {
        this.posX = x;
        this.posY = y;
        this.isNotEmpty = isNotEmpty;
        this.belonging = belonging;
    }
}