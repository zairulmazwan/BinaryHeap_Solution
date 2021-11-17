
public class Heap {
	
	private static final int MAX_SIZE = 10;
    static int [] heap;
    static int size;
    
    public Heap() {
        heap = new int[MAX_SIZE];
        size = 0;
    }
    
    //get the index of the parent node
    public static int parent(int i) {
        return (i - 1) / 2;
    }
    
    // get the index of the left child 
    public static int leftChild(int i) {
        return 2*i + 1;
    }
    
    // get the index of the right child 
    public static int rightChild(int i) {
        return 2*i + 2;
    }
    
    // insert the item at the appropriate position
    public void insert(int data) {
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        // first insert the time at the last position of the array 
        // and move it up
        heap[size] = data;
        size = size + 1;


        // move up until the heap property satisfies
        int i = size - 1;
        while (i != 0 && heap[i]>heap[Heap.parent(i)]) {
            int temp = heap[i];
            heap[i] = heap[Heap.parent(i)];
            heap[Heap.parent(i)] = temp;
            i = Heap.parent(i);
        }
    }
    
    // moves the item at position i of array a
    // into its appropriate position
    public static void maxHeapify(int i){
        // find left child node
        int left = Heap.leftChild(i);

        // find right child node
        int right = Heap.rightChild(i);

        // find the largest among 3 nodes
        int largest = i;

        // check if the left node is larger than the current node
        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        // check if the right node is larger than the current node 
        // and left node
        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        // swap the largest node with the current node 
        // and repeat this process until the current node is larger than 
        // the right and the left node
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }

    }

    // returns the  maximum item of the heap
    public int getMax() {
        return heap[0];
    }

    // deletes the max item and return
    public int extractMax() {
        int maxItem = heap[0];

        // replace the first item with the last item
        heap[0] = heap[size - 1];
        size = size - 1;

        // maintain the heap property by heapifying the 
        // first item
        maxHeapify(0);
        return maxItem;
    }
    
    // deletes the max item and return
    public static int deleteNode(int i) {
        int node = heap[i];

        // replace the first item with the last item
        heap[i] = heap[size - 1];
        size = size - 1;

        // maintain the heap property by heapifying the 
        // first item
        maxHeapify(i);
        return node;
    }
    
    public static int [] descending() {
    	int [] res = new int [size];
    
    	int resSize = size;
    	int j = 0;
    	while(j < resSize) {
    		res[j] = heap[0];
    		deleteNode(0);
    		j++;
    	}
    	return res;
    }

    // prints the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    
    public static void printArray(int [] array) {
    	for(int x : array) {
    		System.out.print(x+" ");
    	}
    }
    

	public static void main(String[] args) {
		
		Heap bh = new Heap();
		
		bh.insert(47);
		bh.insert(57);
		bh.insert(23);
		bh.insert(42);
		bh.insert(31);
		bh.insert(29);
		bh.insert(17);
	
		
		System.out.println("Binary Heap : ");
		bh.printHeap();
		System.out.println("Size : ");
		System.out.println("Maximum value from the tree : ");
		
		int [] des = descending();
		printArray(des);
		System.out.println();
		bh.printHeap();

	}

}
