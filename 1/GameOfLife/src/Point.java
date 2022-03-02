import java.util.ArrayList;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%numStates;	
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState(RulesSet rulesSet) {
		//TODO: insert logic which updates according to currentState and 
		//number of active neighbors
		//DONE
		int activeNeighbors = countActiveNeighbors();

		if (currentState == 0)
			nextState = RulesSet.getDeadRules(rulesSet).contains(activeNeighbors) ? 1 : 0;
		else if (currentState == 1)
			nextState = RulesSet.getAliveRules(rulesSet).contains(activeNeighbors) ? 1 : 0;
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	//DONE
	public int countActiveNeighbors() {
		int count = 0;

		for (Point neighbor : neighbors) {
			if (neighbor.getState() == 1)
				count++;
		}

		return count;
	}
}
