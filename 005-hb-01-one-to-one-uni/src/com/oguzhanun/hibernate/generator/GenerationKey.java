package com.oguzhanun.hibernate.generator;


import java.io.Serializable;


public class GenerationKey implements Serializable {

	
	private int sequenceNumber;
	private String sequenceString ="ABC-";
	private String generationState;
	
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	public String getSequenceString() {
		return sequenceString;
	}

	public void setSequenceString(String sequenceString) {
		this.sequenceString = sequenceString;
	}

	public String getGenerationState() {
		return generationState;
	}

	public void setGenerationState(String generationState, int generationNumber) {
		this.generationState = generationState + generationNumber;
	}
	
	
}
