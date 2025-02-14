package cs2232assignment2;

public class DLinkedList<A,B,C>{
// instance variables 
	private NodeD<A,B,C> header;
	private NodeD<A,B,C> trailer;
	private int size; 
// constructors
	public DLinkedList() {
		header = null;
		trailer = null;
		size = 0;
	}
// methods
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return (size==0);
	}
	public A getFirstStuID() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return header.getStuID();
	}
	public A getLastStuID() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return trailer.getStuID();
	}
	public B getFirstStuName() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return header.getStuName();
	}
	public B getLastStuName() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return trailer.getStuName();
	}
	public C getFirstStuScore() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return header.getStuScore();
	}
	public C getLastStuScore() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return trailer.getStuScore();
	}
	public NodeD<A,B,C> getHeader(){
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return header;
	}
	public void setHeader(NodeD<A,B,C> newHeader) {
		newHeader.setNext(header);
		header=newHeader;
		size++;
	}
	public NodeD<A,B,C> getTrailer(){
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		return trailer;
	}	
	public void setTrailer(NodeD<A,B,C> newTrailer) {
		newTrailer.setPrev(trailer);
		trailer.setNext(newTrailer);
		trailer = newTrailer;
		size++;
	}
	public void addBetween(A id, B name, C score, NodeD <A,B,C> before, NodeD<A,B,C> after) {
		NodeD<A,B,C> insert = new NodeD<>(id, name, score);
		before.setNext(insert);
		after.setPrev(insert);
		insert.setNext(after);
		insert.setPrev(before);
		size++;
	}
	public void addFirst(A id, B name, C score) {
		NodeD <A,B,C> newHeader = new NodeD<>(id, name, score);
		if (isEmpty()) {
			header = trailer = newHeader;
		}
		else { 
			header.setPrev(newHeader);
			newHeader.setNext(header);
			header = newHeader;
		}
		size++;
	}
	public void addLast(A id, B name, C score) {
		NodeD <A,B,C> newTrailer = new NodeD<>(id,name,score);
		if (isEmpty()) {
			header = trailer = newTrailer;
		}
		else {
			newTrailer.setPrev(trailer);
			trailer.setNext(newTrailer);
			trailer = newTrailer;
		}
		size++;
	}
	public void addAfter(A key, A id, B name, C score) {
		NodeD <A,B,C> before = search(key);
		NodeD <A,B,C> insert = new NodeD<>(id, name, score);
		if (before != null) {
			insert.setPrev(before);
			insert.setNext(before.getNext());
			if (before.equals(trailer)) {
				trailer=insert;
				trailer.setPrev(before);
			}
			before.setNext(insert);
			size++;
		}
	}
	public void addBefore(A key, A id, B name, C score) {
		NodeD <A,B,C> after = search(key);
		NodeD <A,B,C> insert = new NodeD<>(id, name, score);
		if (after != null) {
			insert.setNext(after);
			insert.setPrev(after.getPrev());
			if (after.getPrev()!=null) {
				NodeD <A,B,C> before = after.getPrev();
				before.setNext(insert);
			}
			if (after.equals(header)) {
				header=insert;
				header.setNext(after);
			}
			after.setPrev(insert);
			size++;
		}
	}
	public NodeD<A,B,C> remove(NodeD<A,B,C> remove) {
		if (remove.getPrev()==null&&remove.getNext()==null) {
			header = null;
			trailer = null;
		}
		else if (remove.getPrev()==null&&remove.getNext()!= null) {
			header = remove.getNext();
			header.setPrev(null);
		}
		else if (remove.getPrev()!=null && remove.getNext()==null) {
			trailer = remove.getPrev();
			trailer.setNext(null);
		}
		else {
			NodeD<A,B,C> before = remove.getPrev();
			NodeD<A,B,C> after = remove.getNext();
			before.setNext(after);
			after.setPrev(before);
		}
		size--;
		return remove;
	}
	public NodeD<A,B,C> removeAt (A key){
		NodeD <A,B,C> remove = search(key);
		if (remove != null) {
			if (remove.getPrev()==null&&remove.getNext()==null) {
				header = null;
				trailer = null;
			}
			else if (remove.getPrev()==null&&remove.getNext()!= null) {
				header = remove.getNext();
				header.setPrev(null);
			}
			else if (remove.getPrev()!=null && remove.getNext()==null) {
				trailer = remove.getPrev();
				trailer.setNext(null);
			}
			else {
				NodeD<A,B,C> before = remove.getPrev();
				NodeD<A,B,C> after = remove.getNext();
				before.setNext(after);
				after.setPrev(before);
			}
		}
		size--;
		return remove;
	}
	public NodeD<A,B,C> removeFirst() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		header = header.getNext();
		header.setPrev(null);
		size--;
		if (size==0) {
			trailer = null; 
			header = null;
		}
		return header;
	}
	public NodeD<A,B,C> removeLast(){
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		trailer = trailer.getPrev();
		trailer.setNext(null);
		size--;
		if (size==0) {
			trailer = null;
			header = null;
		}
		return trailer;
	}
	public void display() {
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		NodeD<A,B,C> pointer = header;
		System.out.println("StuID, Name, Score ");
		while (pointer != null) {
			pointer.displayNode();
			pointer = pointer.getNext();
		}
	}
	public NodeD<A,B,C> search(A key){
		if (isEmpty()) throw new IllegalStateException("List is Empty");
		NodeD <A,B,C> pointer = header;
		while (pointer != null) {
			if (pointer.getStuID().equals(key)) {
				return pointer;
			}
			pointer = pointer.getNext();
		}
		return null;
	}
	public NodeD<A,B,C> update (A key, A id, B name, C score){
		NodeD<A,B,C> update = search(key);
		if (update!=null) {
			update.setStuID(id);
			update.setStuName(name);
			update.setStuScore(score);
			return update;
		}
		else return null;
	}
}
