public class Point {
    public int type; // 0 - pusta przestrzen, 1 - pojazd
    public Point next;
    public boolean moved;

    public void move() {
        if (type == 1 && !moved && next.type == 0) {
            type = 0;
            next.type = 1;
            next.moved = true;
        }
    }

    public void clicked() {
        type = 1;
    }

    public void clear() {
        type = 0;
    }
}

