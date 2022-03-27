package com.bridgelabz.essentials;

public class Queue<T> {

	LinkedList<T> LinkedList;
	
	
	public Queue(){
		LinkedList = new LinkedList<T>();
	}
	
	public void enqueue(T data){
		LinkedList.add(data);
	}
	
	public T dequeue(){
		return LinkedList.pop(0);
	}
	
	
	public boolean isEmpty(){
		return LinkedList.isEmpty();
	}
	
	
	public int size(){
		return LinkedList.size();
	}
	
}
