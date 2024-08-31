package com.gmail.list;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;

public class List<T> implements ListFunctions<T>, Iterable {
	private Node<T> head;

	public List() {
		head = new Node<>();
	}
	
	public List(T...strs) {
		head = new Node<>();
		for(int i = 0; i< strs.length;i++) {
			this.addFirst(strs[i]);
		}
	}

	private class Node<T> implements Comparable<T> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public Node() {

		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			if (this.data != null) {
				if (this.next != null) {
					sb.append(data + "," + next);
				} else {
					sb.append(data);
				}
			} else {
				sb.append(next);
			}

			return sb.toString();
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(data, next);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(data, other.data);
		}

		private List getEnclosingInstance() {
			return List.this;
		}

		@Override
		public int compareTo(Object o) {
			if (o == null) {
				throw new NullPointerException("Comparable node is null");
			} else if (this.data.hashCode() > o.hashCode()) {
				return 1;
			} else if (this.data.hashCode() > o.hashCode()) {
				return -1;
			}

			return 0;
		}

	}

	@Override
	public void addFirst(T val) {
		head.setNext(new Node<>(val, head.next));

	}

	@Override
	public void addLast(T val) {
		Node<T> current = head.next;
		while (current.next != null) {
			current = current.next;
		}
		current.setNext(new Node<>(val, null));

	}

	@Override
	public void addByIndex(T val, long index) throws OutOfSizeException {
		Node<T> current = this.getNodeByIndex(index - 1);
		current.setNext(new Node<>(val, current.next));

	}

	@Override
	public void set(T val, long index) throws OutOfSizeException {
		Node<T> current = this.getNodeByIndex(index);
		current.data = val;

	}

	@Override
	public void removeFirst() {
		head.setNext(head.next.next);

	}

	@Override
	public void removeLast() {
		Node<T> current = head.next;
		Node<T> prev = current;
		while (current.next != null) {
			prev = current;
			current = current.next;
		}

		prev.setNext(null);

	}

	@Override
	public T getByIndex(long index) throws OutOfSizeException {
		return this.getNodeByIndex(index).data;

	}

	private Node<T> getNodeByIndex(long index) throws OutOfSizeException {
		Node<T> current = head;
		long count = 0;
		if (head.next != null) {
			if (index < this.size()) {
				while (count <= index) {
					current = current.next;
					count++;
				}
			} else {
				throw new OutOfSizeException("Index out of size");
			}
		}
		return current;
	}

	@Override
	public long size() {
		long count = 0;
		Node<T> current = head;
		if (head.next != null) {
			while (current.next != null) {
				current = current.next;
				count++;
			}

		}
		return count;
	}

	@Override
	public void sort(Comparator<T> comp) throws OutOfSizeException {
		for (int i = 0; i < this.size(); i++) {
			for (int j = 1; j < this.size(); j++) {
				if (comp.compare(this.getByIndex(j), this.getByIndex(j - 1)) > 0) {
					T temp = this.getByIndex(j);
					this.set(this.getByIndex(j - 1), j);
					this.set(temp, j - 1);
				}
			}
		}

	}
	
	public void removeIf(Predicate<T> pr) {
		Iterator<T> iter  = this.iterator();
		while(iter.hasNext()) {
			if(pr.test(iter.next())) {
				iter.remove();
			}
		}
	}

	@Override
	public String toString() {
		return "[" + head + "]";
	}

	@Override
	public Iterator<T> iterator() {
		Iterator<T> iter = new Iterator<>() {
			Node<T> current = head;
			Node<T> prev = current;

			@Override

			public boolean hasNext() {
				while (current.next != null) {
					prev = current;
					current = current.next;
					
					return true;
				}
				return false;
			}

			@Override
			public T next() {
				return current.data;
			}

			@Override
			public void remove() {
				prev.setNext(current.next); 
				current = head;

			}

		};

		return iter;
	}

}
