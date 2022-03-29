public class Neighbor {
    Point point;
    int distance;

    public Neighbor(Point point, int distance) {
        this.point = point;
        this.distance = distance;
    }

    public static Neighbor getClosestNextNeighbor(Point point) {
        Point nextPoint = point;
        int distance = 0;

        for (; distance <= Point.getMaxVelocity(3); distance++) {
            nextPoint = nextPoint.next;
            if (nextPoint.isCar())
                break;
        }

        return new Neighbor(nextPoint, distance);
    }

    public static Neighbor getClosestPrevNeighbor(Point point) {
        Point prevPoint = point;
        int distance = 0;

        for (; distance <= Point.getMaxVelocity(3); distance++) {
            prevPoint = prevPoint.prev;
            if (prevPoint.isCar())
                break;
        }

        return new Neighbor(prevPoint, distance);
    }
}
