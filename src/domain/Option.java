package domain;

public class Option {
	private String statement;
	private Score score;
	
	public Option(String statement, Score score){
		setStatement(statement);
		setScore(score);
	}
	
	public String getStatement() {
		return statement;
	}
	private void setStatement(String statement) {
		this.statement = statement;
	}
	public Score getScore() {
		return score;
	}
	private void setScore(Score score) {
		this.score = score;
	}

	public boolean isCorrectAnswer() {
		return getScore().isMaximumScore();
	}
	
}
