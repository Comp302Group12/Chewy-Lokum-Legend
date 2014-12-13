
public class Objective {
	
	private int goalScore;
	
	public Objective(int goalScore) {
		// TODO Auto-generated constructor stub
		this.goalScore = goalScore;
	}
	
	public int getGoalScore() {
		return goalScore;
	}
	
	public boolean checkScore(int score) {
		return score == goalScore;
	}

}
