import java.util.ArrayList;

public class Node {
	Move prev;
	State state;
	int turn;
	
	int pos;
	int mobility;
	Node parent;
	ArrayList<Node> children = new ArrayList<Node>();
	
	public Node(Move prev, State state, int turn) {
		this.prev = prev;
		this.state = state;
		this.turn = turn;
	}
	
	public void addChild(Node child) {
		if (children == null)
			System.out.println("");
		else
			children.add(child);
	}
}
