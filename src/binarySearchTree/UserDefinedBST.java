package binarySearchTree;

import java.util.ArrayList;
import java.util.Scanner;

public class UserDefinedBST {
	static ArrayList<Integer> nodeList=new ArrayList<>();

	public static void main(String[] args) {
		Node root=null;
		Node nn;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Nodes");
		int size=sc.nextInt();
		int i;
		int data;
		for(i=1;i<=size;i++)
		{
			System.out.println("Enter Data for Node "+i+" : ");
			data=sc.nextInt();
			nn=new Node(data);
			if(root==null)
			{
				root=nn;
			}
			else
			{							
				insert(root,nn);		
			}								
		}
		
		inOrder(root);
		System.out.println(nodeList);
		
		System.out.println("Enter Sum");
		int sum=sc.nextInt(); 
		
		int n1;
		int n2;
		int flag=0;
		for(int j=nodeList.size()-1;j>=0;j--)
		{
			n1=nodeList.get(j);   
			n2=sum-n1;           
					if(nodeList.contains(n2))
					{
					System.out.println("Pair Found["+n1+","+n2+"]");
					flag=1;
					break;
					}	
		}
		if(flag==0)
			System.out.println("Pair NOT FOUND");
		
	}
	
	static void inOrder(Node root) //LDR
	{
		if(root!=null)
		{
		inOrder(root.left);
		nodeList.add(root.data);
		inOrder(root.right);
		}
	}

	private static void insert(Node root, Node nn) 
	{
		if(nn.data>root.data) //-->right
		{
			if(root.right==null)  //-->check vacancy
			{
				root.right=nn;
			}
			else
			{
				insert(root.right,nn);
			}
		}
		else				  //-->left
		{
			if(root.left==null)  //-->check vacancy
			{
				root.left=nn;
			}
			else
			{
				insert(root.left,nn);
			}
		}
		
	}

	}