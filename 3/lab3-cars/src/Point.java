public class Point {
    public int type; // 0 - pusta przestrzen, 1 - pojazd
    public Point next;
    public boolean moved;
    public int velocity;

    public Point() {
        velocity = 1;
    }

    public void speedUp() {
        if (velocity < 5)
            velocity++;
    }

    public void slowDown() {
        Point nextPoint = this;
        int distance = 1;
        for (; distance <= 5; distance++) {
            nextPoint = nextPoint.next;
            if (nextPoint.type == 1)
                break;
        }
        if (distance <= velocity)
            velocity = distance - 1;
    }

    public void random() {
        if (velocity >= 1)
            if (Math.random() < 0.3)
                velocity -= 1;
    }

    public void move() {
        Point nextPoint = this;

        for (int nextPos = 0; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (type == 1 && !moved && nextPoint.type == 0) {
            nextPoint.type = 1;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
            type = 0;
            velocity = 0;
        }
    }

    public void clicked() {
        type = 1;
    }

    public void clear() {
        type = 0;
    }
}

