package mutation;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	static LinkedList<NativeSequence> nativeStrands;
	
	
	public static void main(String[] args)
	{
		nativeStrands = new LinkedList<NativeSequence>();
		setNativeStrands();
	}
	
	public static void setNativeStrands()
	{
		File nativeSequences = new File("NativeSequences.txt");
		
		Scanner sc2 = null;
		try 
		{
			sc2 = new Scanner(nativeSequences);
		} 
		catch (FileNotFoundException e) 
		{
		 	System.out.println("nativeSequences Not Found");
		 	e.printStackTrace();  
		}
		    
		String sLocation = "";
		String sSequence = "";
		
		while (sc2.hasNextLine()) 
		{
			String line = sc2.nextLine(); 
			if(line.startsWith(">"))
			{
				sLocation = line.substring(1);
				//System.out.println(sLocation);
			}
			else if(line.startsWith("A") || line.startsWith("T") || line.startsWith("G") || line.startsWith("C"))
			{
				sSequence = line;
				//System.out.println(sSequence);
		    
				NativeSequence temp = new NativeSequence(sLocation, sSequence);
				System.out.println("The origin is " + temp.getOrigin());
				System.out.println("and the sequence is \n " + temp.originNode.sequence.toString());
				nativeStrands.add(temp);
			}
		}    
	}
	
	public void readInCurrent()
	{
		File nativeSequences = new File("CurrentOutbreakSequences.txt");
		
		Scanner sc2 = null;
		try 
		{
			sc2 = new Scanner(nativeSequences);
		} 
		catch (FileNotFoundException e) 
		{
		 	System.out.println("Current Sequences Not Found");
		 	e.printStackTrace();  
		}
		    
		while (sc2.hasNextLine()) 
		{
			Scanner s2 = new Scanner(sc2.nextLine());
		    while (s2.hasNext()) 
		    {
		    	String sLocation = s2.next();
		    	String sSequence = s2.next();
		    	
		    	sLocation = sLocation.substring(1);
		    	SequenceNode temp = new SequenceNode(sLocation, sSequence, null);
		    }
		}   
	}
	
	
	public void placefinder(SequenceNode newNode)
	{
		int lowestDifference = 1000;
		NativeSequence closestNode = null;
		
		//finding which original strand it was
		for(NativeSequence e: nativeStrands)
		{
			int temp = newNode.calcDiffrence(e.originNode);
			if(temp < lowestDifference)
			{
				lowestDifference = temp;
				closestNode = e;
			}
		}
		
		newNode.parent = closestNode.originNode;
		closestNode.allNodes.add(newNode);
		closestNode.unsortedNodes.add(newNode);
	}
}
