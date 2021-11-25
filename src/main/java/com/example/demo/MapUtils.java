package com.example.demo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {

	private static final String Delimiter = ",";

	public static <T,U> Map<T,U> mergingMaps(Map<T,U> m1, Map<T, U> m2) {
		if(m1.isEmpty())
			return m2;
		else if(m2.isEmpty())
			return m1;
		else {
			m2.entrySet().stream().forEach(entry->addingElememts(entry.getKey(), entry.getValue(),m1));
			return m1;
		}
			
		
	}

	private static <T, U> void addingElememts(T key, U value, Map<T, U> m1) {
		if(m1.containsKey(key)) {
			U val1=m1.get(key);
			m1.put(key, combine(val1 , value));
		}else
			m1.put(key,value);
	}

	private static <U> U combine(U val1, U val2) {
		U returnVal;
		if(val1 instanceof String) 
			returnVal=(U) ((String)val1+Delimiter+(String)val2);
		else if (val1 instanceof BigDecimal)
			returnVal=(U) (((BigDecimal) val1).add((BigDecimal)val2));
		else if (val1 instanceof BigInteger)
			returnVal=(U)(((BigInteger) val1).add((BigInteger)val2));
		else returnVal=val2;
			return returnVal;
	}

}
