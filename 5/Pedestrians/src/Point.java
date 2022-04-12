import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;
	public boolean blocked = false;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
	}

	public void clear() {
		staticField = 100000;
	}

	public boolean calcStaticField() {
		int min = 100000;
		for (Point neighbor : neighbors)
			if (neighbor.staticField < min)
				min = neighbor.staticField;

		if (staticField > min + 1) {
			staticField = min + 1;
			return true;
		}

		return false;
	}

	public void move() {
		if (isPedestrian && !blocked) {
			int minStaticField = 100001;
			Point minStaticFieldPoint = null;
			{
				for (Point neighbor : neighbors) {
					if (neighbor.type == 0 || neighbor.type == 2) {
						if (neighbor.staticField < minStaticField) {
							minStaticField = neighbor.staticField;
							minStaticFieldPoint = neighbor;
						}
					}
				}
			}

			if (minStaticFieldPoint != null && !minStaticFieldPoint.blocked) {
				type = 0;
				isPedestrian = false;
				minStaticFieldPoint.blocked = true;
				if (minStaticFieldPoint.type == 0) {
					minStaticFieldPoint.type = 3;
					minStaticFieldPoint.isPedestrian = true;
				}
			}
		}
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}