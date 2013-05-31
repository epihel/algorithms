package com.erikpihel.algorithms;

/**
 * Simulates C++ pointers.
 */
public class Pointer<T> {
	T value;
	Pointer<T> next;
	
	Pointer(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
