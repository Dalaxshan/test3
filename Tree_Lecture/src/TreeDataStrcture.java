
public class TreeDataStrcture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree obj=new Tree(280);
		
		obj.insert(308);
		obj.insert(180);
		obj.insert(416);
		obj.insert(298);
		obj.insert(350);
		obj.insert(156);
		obj.insert(255);
		obj.insert(580);
		obj.insert(275);
		obj.insert(12);

		obj.inOrder(Tree.root);
		System.out.println("value is: "+obj.find(180));
		System.out.println("Minimum value is:"+obj.minimum());
		System.out.println("Maximum value is:"+obj.maximum());
		obj.DescOrder(Tree.root);
		System.out.println("Convert value is:"+obj.delete(308));
	}

}

class Tree{
	
	static Node root;
	
	Tree(){
		root=null;
	}
	
	Tree(int i){
		root=new Node(i);
		
	}
	

class Node{
	int value;
	Node leftChild,rightChild;
	
	Node(int i){
	value=i;
	leftChild=rightChild=null;
		
	}
}

//insert function
void insert(int y) {
	insert(y,root);
}

Node insert(int x,Node root) {
	
	if(root==null) {
		return new Node(x);
	}
	
	else if(root.value>x) {
		root.leftChild=insert(x, root.leftChild);
	}
	
	else if(root.value<x) {
		root.rightChild=insert(x,root.rightChild);
	}
	
	return root;
	
}

//inOrder function
void inOrder(Node root) {
	
	if(root!=null) {
		
		inOrder(root.leftChild);
		System.out.println(root.value);
		inOrder(root.rightChild);
		
	}
	
   }

//find function
Node find(int num) {
	
	Node currentNode=root;
	
	while(currentNode!=null) {
		
		if(currentNode.value==num) {
			return currentNode;
		}
		
		else if(currentNode.value>num) {
				currentNode=currentNode.leftChild;
			}
		
		else if(currentNode.value<num) {
			currentNode=currentNode.rightChild;
		}
	}
	return null;
}

//Maximum function
int minimum() {
	
	Node currentNode=root;
	Node beforeNode = null;
	
	while(currentNode!=null) {
		beforeNode=currentNode;
		currentNode=currentNode.leftChild;
	}
	
	return beforeNode.value;
	
}

//Maximum function
int maximum() {
	
	Node currentNode=root;
	Node beforeNode = null;
	
	while(currentNode!=null) {
		beforeNode=currentNode;
		currentNode=currentNode.rightChild;
	}
	
	return beforeNode.value;
	
}

//Desending Order
void DescOrder(Node root) {
	
	if(root!=null) {
	DescOrder(root.rightChild);
	System.out.println(root.value);
	DescOrder(root.leftChild);
	}
}

int delete(int num) {
	
    Node currentNode=root;
    Node currentLeftNode;
    Node currentRightNode;
	
    if(currentNode!=null) {
	currentNode=find(num);
	currentLeftNode=currentNode.leftChild;
	currentRightNode=currentNode.rightChild;
	
	if(currentLeftNode.rightChild!=null) {
		currentNode=currentLeftNode.rightChild;
		return currentNode.value;
	  }
	
	else if(currentRightNode.leftChild!=null) {
		currentNode=currentRightNode.leftChild;
		return currentNode.value;
	  }
	
	
	else if(currentRightNode.leftChild==null) {
		currentNode=currentNode.rightChild;
		return currentNode.value;
	}
	
  }
	return 0;
    
    
}

}

















































