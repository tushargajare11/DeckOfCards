package com.bridgelabz.essentials;

public class Node<T> {
	T data; // data to be stored
	Node<T> next; // reference to the next node

	Node(T data) {
		this.data = data;
		next = null;
	}
}
