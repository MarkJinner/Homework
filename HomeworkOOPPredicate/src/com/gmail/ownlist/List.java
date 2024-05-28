package com.gmail.ownlist;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class List<T> implements Frames<T>, Iterable {
	private Node<T> head = new Node<>();

	public List() {
		
	}
	
	public List(T ...values) {
		
		for(T i: values) {
			this.addLast(i);
		}
	}

	private class Node<T> {
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

			if (next != null) {
				if (this.data != null) {
					sb.append(data + "," + next);
				} else {
					sb.append(next);
				}
			} else {
				if (this.data != null) {
					sb.append(data);
				}
			}

			return sb.toString();

		}

	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	@Override
	public void addFirst(T data) {
		Node<T> add = new Node<>(data, head.getNext());
		head.setNext(add);

	}

	@Override
	public void addLast(T data) {
		Node<T> add = new Node<>(data, null);
		
		if (head.next != null) {
			Node<T> current = head.getNext();
			while (current.next != null) {
				current = current.next;
			}

			current.setNext(add);
			add.setNext(null);
		} else {
			head.setNext(add);
			add.setNext(null);

		}

	}

	@Override
	public void addByIndex(long index, T data) throws ListIsEmptyException, OutOfSizeException {
		Node<T> add = new Node<>(data, null);
		long count = 0;
		Node<T> current = head;

		if (head.next != null) {
			if (index < this.getSize()) {
				while (count < index) {
					current = current.next;
					count++;
				}
				add.setNext(current.next);
				current.setNext(add);
			} else {
				throw new OutOfSizeException("Index out of list size");
			}
		} else {
			throw new ListIsEmptyException("List is empty");
		}

	}

	@Override
	public void removeFirst() throws ListIsEmptyException {
		if (head.next != null) {
			Node<T> current = head.next;
			head.setNext(current.next);
			current = null;
		} else {
			throw new ListIsEmptyException("List is empty");
		}

	}

	@Override
	public void removeLast() throws ListIsEmptyException {
		if (head.next != null) {
			Node<T> current = head;
			Node<T> prev = current;

			while (current.next != null) {
				prev = current;
				current = current.next;
			}
			prev.setNext(null);
			current = null;

		} else {
			throw new ListIsEmptyException("List is empty");
		}

	}

	@Override
	public void removeByIndex(long index) throws ListIsEmptyException, OutOfSizeException {
		if (head.next != null) {
			if (index <= this.getSize()) {
				long count = 0;
				Node<T> current = head;
				Node<T> prev = current;

				while (count <= index) {
					prev = current;
					current = current.next;
					count++;
				}

				prev.setNext(current.next);
				current = null;

			} else {
				throw new OutOfSizeException("Index out of list size");
			}
		} else {
			throw new ListIsEmptyException("List is empty");
		}

	}

	@Override
	public T getByIndex(long index) throws OutOfSizeException, ListIsEmptyException {
		T temp = null;
		if (head.next != null) {
			if (index <= this.getSize()) {
				long count = 0;
				Node<T> current = head;
				Node<T> prev = current;

				while (count <= index) {
					prev = current;
					current = current.next;
					count++;
				}
				temp = current.data;

			} else {
				throw new OutOfSizeException("Index out of list size");
			}
		} else {
			throw new ListIsEmptyException("List is empty");
		}

		return temp;
	}

	public void setByIndex(long index, T value) throws ListIsEmptyException, OutOfSizeException {
		Node<T> add = new Node<>(value, null);
		Node<T> current = head;
		long count = 0;

		if (head.next != null) {
			if (index <= this.getSize()) {
				while (count < index) {
					current = current.next;
					count++;
				}
				add.setNext(current.getNext());
				current.setNext(add);

			} else {
				throw new OutOfSizeException("Index out of list size");
			}

		} else {
			throw new ListIsEmptyException("List is empty");
		}
	}

	public long getSize() {
//		SizeCounter count = () -> {
//			int l = 0;
//			Node<T> current = head;
//			while (current.next != null) {
//				l++;
//				current = current.next;
//			}
//
//			return l;
//		};
//
//		return count.getSize();
		
		SizeCounter count = this::getLength;
		
		return count.getSize();
	}

	public void sort(Comparator<T> cmp) throws OutOfSizeException, ListIsEmptyException {
		for (int i = 0; i < this.getSize(); i++) {
			for (int j = 1; j < this.getSize(); j++) {
				cmp = NullSafeComparator.rangeNullsFirst(cmp);
				if (cmp.compare(this.getByIndex(j), this.getByIndex(j - 1)) < 0) {
					T temp = this.getByIndex(j);
					this.removeByIndex(j);
					this.setByIndex(j, this.getByIndex(j - 1));

					this.removeByIndex(j - 1);
					this.setByIndex(j - 1, temp);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "[" + head + "]";
	}

	@Override
	public Iterator <T> iterator() {
		
		Iterator <T>iter = new Iterator<>() {
			private Node<T> current = head;
			private Node<T> prev = current;
			private T temp = null;

			@Override
			public boolean hasNext() {
				
				while(current.next!=null) {
					prev = current;
					current = current.next;
					return true;
				}
				
				return false;
			}

			@Override
			public T next() {
				temp = current.data;
				return temp;
			}

		};
		
		return iter;
	}
	
	
	public void throughList(Iterator <T> iter) {
		
		while(this.iterator().hasNext()) {
			
				System.out.println(iterator().next());		
			
		}
		
	}
	
	public void removeIf(Predicate<T> pr) throws OutOfSizeException, ListIsEmptyException {
		for(int i = 0; i< this.getSize();i++) {
			if(pr.test(this.getByIndex(i))) {
				this.removeByIndex(i);
				i--;
			}
		}
	}
	
	public long getLength() {
		int count = 0;
		Node<T> current = head; 
		while(current.next!=null) {
			current = current.next;
			count++;
		}
		
		return count;
	}

}
