package com.oguzhanun.hibernate.generator;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.SequenceGenerator;

public class MyGenerator extends SequenceGenerator {

	private static int keyNumber;
	
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) {
		GenerationKey key;
		
		if(obj instanceof GenerationKey) {
			
			key = (GenerationKey) obj;
			key.setSequenceNumber(keyNumber);
			key.setGenerationState(key.getSequenceString(), key.getSequenceNumber());
			keyNumber++;
		} else key = null;
		
		
		return key;
	}
	
	

}
