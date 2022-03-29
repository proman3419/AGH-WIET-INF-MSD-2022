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
        setInitialVelocity();
    }

    public void becomePoint(Point point) {
        type = point.type;
        moved = point.moved;
        velocity = point.velocity;
    }

    public static int getMaxVelocity(int type) {
        switch (type) {
            case 1: return 3;
            case 2: return 5;
            case 3: return 7;
        }
        return 0;
    }

    public boolean isCar() {
        return Point.carTypes.contains(type);
    }

    public void setInitialVelocity() {
        if (this.isCar())
            velocity = Point.getMaxVelocity(type);
    }

    public void speedUp() {
        if (velocity < Point.getMaxVelocity(type))
            velocity++;
    }

    public void slowDown() {
        Neighbor nextNeighbor = Neighbor.getClosestNextNeighbor(this);
        if (nextNeighbor.distance <= velocity)
            velocity = nextNeighbor.distance - 1;
    }

    public void move() {
        Point nextPoint = this;

        for (int nextPos = 0; nextPos < velocity; nextPos++) {
            nextPoint = nextPoint.next;
        }

        if (this.isCar() && !moved && nextPoint.type == 0) {
            nextPoint.type = type;
            nextPoint.moved = true;
            nextPoint.velocity = velocity;
            type = 0;
            velocity = 0;
        }
    }

    public boolean canFinishOvertake(Point rightPoint) {
        Neighbor closestPrevNeighborRight = Neighbor.getClosestPrevNeighbor(rightPoint);
        Neighbor closestNextNeighborRight = Neighbor.getClosestNextNeighbor(rightPoint);
        Neighbor closestPrevNeighborLeft = Neighbor.getClosestPrevNeighbor(this);

        if (closestPrevNeighborRight.distance >= closestPrevNeighborRight.point.velocity) { // 1
            if (closestPrevNeighborLeft.distance <= Point.getMaxVelocity(closestPrevNeighborLeft.point.type)) { // 2
                if (closestNextNeighborRight.distance >= velocity) { // 3
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canOvertake(Point leftPoint) {
        Neighbor closestPrevNeighborLeft = Neighbor.getClosestPrevNeighbor(leftPoint);
        Neighbor closestNextNeighborLeft = Neighbor.getClosestNextNeighbor(leftPoint);
        Neighbor closestPrevNeighborRight = Neighbor.getClosestPrevNeighbor(this);

        if (velocity < getMaxVelocity(type)) { // 1
            if (closestPrevNeighborRight.distance >= Point.getMaxVelocity(closestPrevNeighborRight.point.type)) { // 2
                if (closestPrevNeighborLeft.distance >= Point.getMaxVelocity(closestPrevNeighborLeft.point.type)) { // 3
                    if (closestNextNeighborLeft.distance >= velocity) { // 4
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clicked() {
        type = 0;
    }

    public void clear() {
        if (type != 5)
            type = 0;
    }
}
