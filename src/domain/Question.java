package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
	private String question;
	private List<Option> options = new ArrayList<Option>();
	private Category category;
	private String feedback;
	
	public Question(){}
	
	public Question(Category category, String question){
		setCategory(category);
		setQuestion(question);
	}
	
	public Question(Category category, String question,  List<Option> options){
		this(category, question);
		setOptions(options);
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}

	public List<String> getStatementsShuffled() {
		List<String> shuffledStatements = new ArrayList<String>(getStatements());
		Collections.shuffle(shuffledStatements);
		return shuffledStatements;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category categorie) {
		this.category = categorie;
	}
	
	public String toString(){
		return getQuestion();
	}
	
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
	public void setStatements(List<String> statements) {
		getOptions().clear();
		for(String s : statements){
			Option option = new Option(s, new Score(getCategory()));
			options.add(option);
		}
	}
	
	public void addStatement(Option option) {
		options.add(option);
	}
	
	private  List<Option>getOptions(){
		return options;
	}
	
	public List<String> getStatements(){
		List<String> statementsStrings = new ArrayList<String>();
		for(Option s : getOptions()){
			statementsStrings.add(s.getStatement());
		}
		return statementsStrings;
	}

	public Option getOption(String statement) {
		Option option = null;
		for(int i = 0; i < getOptions().size() && option == null; i++){
			if(getOptions().get(i).getStatement().equals(statement)){
				option = getOptions().get(i);
			}
		}
		return option;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
