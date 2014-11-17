package domain;

import java.util.ArrayList;
import java.util.List;

public class Answer {
	private List<Option> options = new ArrayList<Option>();
	private Question question;

	private List<Option> getOptions() {
		return options;
	}

	public void addOption(Option option) {
		this.options.add(option);
	}
	
	public boolean isCorrect(){
		boolean correct = true;
		for(int i = 0; i < options.size() && correct; i++){
			if(!options.get(i).isCorrectAnswer()){
				correct = false;
			}
		}
		return correct;
	}

	public boolean isForCategory(Category category) {
		return getOptions().get(0).getScore().getCategory().equals(category);
	}
	
	public int getScore(Category category){
		int score = 0;
		for(Option o : options){
			if(o.getScore().getCategory().equals(category)){
				score += o.getScore().getPoints();
			}
		}
		return score;
	}
	
	public int getMaximumScore(Category category){
		int score = 0;
		for(Option o : options){
			if(o.getScore().getCategory().equals(category)){
				score += o.getScore().getMaxPoints();
			}
		}
		return score;
	}

	private Question getQuestion() {
		return question;
	}

	protected void setQuestion(Question question) {
		this.question = question;
	}

	public String getFeedback(){
		return getQuestion().getFeedback();
	}
}
