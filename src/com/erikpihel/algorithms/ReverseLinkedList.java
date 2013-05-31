package com.erikpihel.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a linked list, reverse the list
 * without using a second data structure.
 */
@SuppressWarnings("serial")
public class ReverseLinkedList<T> extends LinkedList<Pointer<T>> {
	Pointer<T> head;
	
	/**
	 * Constructor wraps the given {@link List} items
	 * with {@link Pointer}s.
	 * @param list
	 */
	public ReverseLinkedList(List<T> list) {
		List<Pointer<T>> pointerList = new ArrayList<Pointer<T>>(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			Pointer<T> p = new Pointer<T>(list.get(i));
			pointerList.add(p);
			
			if (i != 0) {
				pointerList.get(i - 1).next = p;
			}
		}
		
		addAll(pointerList);
		head = peekFirst();
	}
	
	/**
	 * Changes the pointers, not the list itself.
	 * TODO: check if list has < 3 items.
	 */
	public void reverse() {
		Pointer<T> current = null;
		// start at the current first item
		Pointer<T> next = head;
		Pointer<T> newPointerTarget = null;

		// iterate through each item and reverse the direction of the pointer;
		// when next is null, we're on the last item in the list => exit the loop
		while (next != null) {
			// store new target of the current item's pointer
			// (null the first time because current first element
			// will be the new last element, which has no pointer to next element)
			newPointerTarget = current;
			
			// move to next item in the list
			current = next;
			
			// define item for next iteration
			next = current.next;
			
			//System.out.println("newPointerTarget [" + newPointerTarget + "], current [" + current + "], next [" + next + "]");
			
			// repoint the current item's pointer in the opposite direction
			// (from next to previous)
			current.next = newPointerTarget;
		}
		
		// now that all the pointers have been reversed,
		// set head to the previously last item in the list
		// to align with the new direction
		head = current;
	}
	
	@Override
	public String toString() {
		return append(head, new StringBuilder()).toString();
	}
	
	private StringBuilder append(Pointer<T> pointer, StringBuilder sb) {
		sb.append(pointer.value);
		
		if (pointer.next != null) {
			sb.append(" -> ");
			return append(pointer.next, sb);
		}
		
		else {
			return sb;
		}
	}
}
