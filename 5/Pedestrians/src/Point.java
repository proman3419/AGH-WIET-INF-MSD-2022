import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;

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

		int prevStaticField = staticField;
		if (staticField > min + 1)
			staticField = min + 1;

		return !(staticField == prevStaticField);
	}

	public void move(){
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}