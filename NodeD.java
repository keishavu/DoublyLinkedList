package cs2232assignment2;

public class NodeD<A,B,C> {
// instance variable
	private A stuID;
	private B stuName;
	private C stuScore;
	private NodeD<A,B,C> Next;
	private NodeD<A,B,C> Prev;
// constructor
	public NodeD() {
		this.stuID = null;
		this.stuName = null;
		this.stuScore = null;
	}
	public NodeD(A stuID, B stuName, C stuScore) {
		this.stuID = stuID;
		this.stuName = stuName;
		this.stuScore = stuScore;
	}
// methods
	public A getStuID() {
		return stuID;
	}
	public void setStuID(A a) {
		stuID = a;
	}
	public B getStuName() {
		return stuName;
	}
	public void setStuName(B stuName) {
		this.stuName = stuName;
	}
	public C getStuScore() {
		return stuScore;
	}
	public void setStuScore(C stuScore) {
		this.stuScore = stuScore;
	}
	public NodeD<A, B, C> getNext() {
		return Next;
	}
	public void setNext(NodeD<A, B, C> next) {
		Next = next;
	}
	public NodeD<A, B, C> getPrev() {
		return Prev;
	}
	public void setPrev(NodeD<A, B, C> prev) {
		Prev = prev;
	}
	public void displayNode() {
		System.out.println(stuID+", "+stuName+", "+stuScore);
	}
}
