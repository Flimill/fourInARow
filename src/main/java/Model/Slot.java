package Model;

public class Slot {
    public int posX;
    public int posY;

    public boolean status;

    public Constants belonging;

    public Slot(int x, int y, boolean status,Constants belonging) {
        this.posX = x;
        this.posY = y;
        this.status = status;
        this.belonging = belonging;
    }
}