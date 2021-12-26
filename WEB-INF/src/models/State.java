package models;

public class State{
	//############ Fields #####################
	private Integer stateId;
	private String state;

	//############ Constructors ###############
	public State(){
		super();
	}

	public State(Integer stateId,String state){
		this.stateId = stateId;
		this.state = state;
	}

	//############ Getter-Setters #############
	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}

	public Integer getStateId(){
		return stateId;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}
}