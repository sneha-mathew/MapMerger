package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
class HashMapTest {

	@Test
	void shouldReturnEmptyHashMap_WhenEmptyHashMaps() {
		Map<String,String> m1= new HashMap();
		Map<String,String> m2= new HashMap();
		Map<String,String> m3= MapUtils.mergingMaps(m1,m2);
		assertEquals(new HashMap(),m3);
	}
	@Test
	void shouldReturnHashMapWithValue_WhenOneHashMap2IsEmpty() {
		Map<String,String> m1= new HashMap();
		m1.put("A1", "1");
		Map<String,String> m2= new HashMap();
		Map<String,String> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", "1");
		assertEquals(expected,m3);
	}
	@Test
	void shouldReturnHashMapWithValue_WhenOneHashMap1IsEmpty() {
		Map<String,String> m1= new HashMap();
		Map<String,String> m2= new HashMap();
		m2.put("A1", "1");
		Map<String,String> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", "1");
		assertEquals(expected,m3);
	}
	@Test
	void shouldReturnCombinesHashMap_WhenHashMapNotEmpty() {
		Map<String,String> m1= new HashMap();
		m1.put("A1", "1");
		Map<String,String> m2= new HashMap();
		m2.put("B1", "5");
		Map<String,String> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", "1");
		expected.put("B1", "5");
		assertEquals(expected,m3);
	}
	@Test
	void shouldReturnCombinesHashMap_WhenHashMapHasSameKeys() {
		Map<String,String> m1= new HashMap();
		m1.put("A1", "1");
		Map<String,String> m2= new HashMap();
		m2.put("A1", "5");
		Map<String,String> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", "1,5");
		assertEquals(expected,m3);
	}

	@Test
	void shouldReturnCombinesHashMap_WhenHashMapBigInteger() {
		Map<String,BigInteger> m1= new HashMap();
		m1.put("A1", new BigInteger("1"));
		Map<String,BigInteger> m2= new HashMap();
		m2.put("A1", new BigInteger("5"));
		Map<String,BigInteger> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", new BigInteger("6"));
		assertEquals(expected,m3);
	}
	
	@Test
	void shouldReturnCombinesHashMap_WhenHashMapBigDecimal() {
		Map<String,BigDecimal> m1= new HashMap();
		m1.put("A1", new BigDecimal("1.01"));
		Map<String,BigDecimal> m2= new HashMap();
		m2.put("A1", new BigDecimal("5.95"));
		Map<String,BigDecimal> m3= MapUtils.mergingMaps(m1,m2);
		HashMap expected= new HashMap();
		expected.put("A1", new BigDecimal("6.96"));
		assertEquals(expected,m3);
	}
}
