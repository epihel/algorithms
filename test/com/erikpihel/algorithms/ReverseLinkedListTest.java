package com.erikpihel.algorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.erikpihel.Pointer;

public class ReverseLinkedListTest {
	@Test
	public void testReverse() {
		List<Integer> list = Arrays.asList(
			1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		);
		ReverseLinkedList<Integer> rll = new ReverseLinkedList<>(list);
		rll.reverse();
		
		// new head should be original last item
		Pointer<Integer> current = rll.head;
		// start with last item, which should now be first item
		int counter = list.size() - 1;
 
		// reverse-iterate the original list,
		// while forward-iterating through the pointers
		while (counter >= 0) {
			Assert.assertEquals(list.get(counter), current.value);
			current = current.other;
			--counter;
		}
	}
}
