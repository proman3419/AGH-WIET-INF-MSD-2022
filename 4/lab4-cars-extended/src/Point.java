import java.util.Arrays;
import java.util.List;

public class Point {
    public static Integer[] types = {0, 1, 2, 3, 5};
    public static List carTypes = Arrays.asList(1, 2, 3);
    public int type;
    public Point prev;
    public Point next;
    public boolean moved;
    public int velocity;

    public Point() {
        velocity = Point.getMaxVelocity(type);
    }

    public static int getMaxVelocity(int type) {
        switch (type) {
            case 1: return 3;
            case 2: return 5;
            case 3: return 7;
        }
        return 0;
    }
    public void speedUp() {
        if (velocity < Point.getMaxVelocity(type))
            velocity++;
    }

    public void slowDown() {
        Point nextPoint = this;
        int distance = 1;
        for (; distance <= Point.getMaxVelocity(type); distance++) {
            nextPoint = nextPoint.next;
            if (Point.carTypes.contains(nextPoint.type))
                break;
        }
        if (distance <= velocity)
            velocity = distance - 1;
    }

    public void move() {
        Point nextPoint = this;

        for (int nextPos = 0; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (Point.carTypes.contains(type) && !moved && nextPoint.type == 0) {
            nextPoint.type = type;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
            type = 0;
            velocity = 0;
        }
    }

    public void clicked() {
        this.type = 0;
    }

    public void clear() {
        type = 0;
    }
}

