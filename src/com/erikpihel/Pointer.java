package com.erikpihel;

/**
 * Simulates C++ pointers.
 */
public class Pointer<T> {
	public T value;
	public Pointer<T> next;
	
	public Pointer(T value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
}
