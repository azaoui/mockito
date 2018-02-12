package com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.hamcrest.Matchers.hasItem;


public class MockitoTests {
	
	@Rule
	public MockitoRule rule = MockitoJUnit.rule();
	
	@Captor
	private ArgumentCaptor<List<String>> capture;
	
	@Mock
	List<String> mockedList;
	
	@Test
	public void sampleTest(){
		
		List<String> asList = Arrays.asList("foo","bar");
		mockedList.addAll(asList);
		verify(mockedList).addAll(capture.capture());
		List<String> capturedValue = capture.getValue();
		System.out.println("##################################");
		System.out.println(capturedValue.get(0).equals("foo"));
		System.out.println(capturedValue.get(1).equals("bar"));
		System.out.println("##################################");
		//assertThat(Arrays.asList("foo", "bar"), hasItem("bar"));
		assertThat(capturedValue, hasItem("foo"));
		assertTrue(capturedValue.contains("bar"));
		//assertf
		
	
		
	}

}
