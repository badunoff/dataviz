package mutation;

import java.util.*;

public class SequenceNode {
	private String strainName;
	Base[] sequence;
	SequenceNode parent;
	private LinkedList<SequenceNode> children;
	private int difWithParent;
	
	public SequenceNode(String strainName, String rawSequence, SequenceNode parent)
	{
		this.strainName = strainName;
		setSequence(rawSequence);
		this.parent = parent;
		children = new LinkedList<SequenceNode>();
		if(parent == null)
			difWithParent = 0;
	}
	
	private void setSequence(String rawSequence)
	{
		int length = rawSequence.length();
		
		sequence = new Base[length];
		
		for(int i = 0; i < length; i++)
		{
			
			switch(rawSequence.charAt(i))
			{
				case 'A':
					sequence[i] = Base.A;
					break;
				case 'T':
					sequence[i] = Base.T;
					break;
				case 'G':
					sequence[i] = Base.G;
					break;
				case 'C':
					sequence[i] = Base.C;
					break;
				default:
			}
		}
	}
	
	public void setDifWithParent(int difWithParent)
	{
		this.difWithParent = difWithParent;
	}
	
	public int calcDiffrence(SequenceNode other)
	{
		int retval = 0;
		
		for(int i = 0; i < sequence.length; i++)
		{
			if(sequence[i] != other.getBaseAt(i))
				retval++;
		}
		
		return retval;
	}
	
	public Base getBaseAt(int index)
	{
		return sequence[index];
	}
}
