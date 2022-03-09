public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;

	public static Integer[] types = {0, 1, 2};
	public int type;

	public static int sinInput = 0;

	public Point() {
		clear();
		type = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		// DONE
		nVel = eVel = wVel = sVel = pressure = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		// DONE
		nVel = nVel - (nNeighbor.pressure - pressure);
		eVel = eVel - (eNeighbor.pressure - pressure);
		sVel = sVel - (sNeighbor.pressure - pressure);
		wVel = wVel - (wNeighbor.pressure - pressure);
	}

	public void updatePresure() {
		// TODO: pressure update
		// DONE
		if (type == 2) {
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
		else {
			pressure = pressure - 0.5f * (nVel + eVel + sVel + wVel);
		}
	}

	public float getPressure() {
		return pressure;
	}
}