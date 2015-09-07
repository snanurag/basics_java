package algopractice;

public class NodeAtADistance {
	
	
	public static void main(String[] args) 
	{
		/**
		 * 							3
		 * 						   / \
		 * 						  4   8
		 * 						 / \
		 * 						5   6
		 * 					   /   / \
		 * 					  9	  7   11
		 *                     \
		 *                     10
		 * 
		 */
		
		
		Node headNode = new Node(3);
		headNode.left = new Node(4);
		headNode.right = new Node(8);
		
		Node randomNode = headNode.left.left = new Node(5);
		headNode.left.right = new Node(6);
		
		headNode.left.right.left = new Node(7);
		headNode.left.right.right = new Node(11);
		
		randomNode.left = new Node(9);
		randomNode.left.right = new Node(10);
		
		findUtil(headNode, randomNode, 4);
	}
	
	static void findUtil(Node headNode, Node randomNode, int dist)
	{
		find(headNode, randomNode,dist);
		search(randomNode,dist);
	}
	
	static int find(Node headNode, Node randomNode, int dist)
	{
		if(headNode == null || randomNode == null)
		{
			return -1;
		}	 
		else if(headNode == randomNode)
		{
			return 1;
		}
		
		int i = -1;
		
		if((i=find(headNode.left, randomNode, dist))!=-1)
		{
			search(headNode.right,dist-i-1);
		}
		else if((i=find(headNode.right, randomNode, dist))!=-1)
		{
			search(headNode.left,dist-i-1);
		}		
		
		if(dist-i-1==0)
		{
			System.out.println(headNode);
		}
		
		return (i==-1)?i:++i;		
	}
	
	static void search(Node node, int d)
	{
		if(node == null || d<=0)
		{
			return;
		}
		if(d == 1)
		{
			System.out.println(node);
		}
		else
		{		
			d--;
			search(node.left,d);
			search(node.right,d);
		}
	}
}

class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
	}
	
	@Override
	public String toString() {
		
		return Node.class.getName()+"["+data+"]";
	}
	
}
