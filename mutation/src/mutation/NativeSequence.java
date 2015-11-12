package mutation;

import java.util.*;

public class NativeSequence {
	private String origin;
	SequenceNode originNode;
	Queue<SequenceNode> unsortedNodes;
	LinkedList<SequenceNode> allNodes;
	
	public NativeSequence(String origin, String sequence)
	{
		this.origin = origin;
		originNode = new SequenceNode("Original", sequence, null);
		unsortedNodes = new LinkedList<SequenceNode>();
		allNodes = new LinkedList<SequenceNode>();
	}
	
	public String getOrigin()
	{
		return this.origin;
	}
}
