package heapSort;

import java.io.*;
import java.lang.Integer;

class HeapSortApp {
	public static void main(String[] args) throws IOException{
		int size, j;
		
		System.out.print("Enter number of items: ");
		size = getInt();
		Heap theHeap = new Heap(size);
		
		for(j = 0; j<size; j++){
			int random = (int)(java.lang.Math.random()*100);
			Node newNode = new Node(random);
			theHeap.insertAt(j, newNode);
			theHeap.incrementSize();
		}
		
		System.out.print("Random: ");
		theHeap.displayArray();
		
		for(j=size/2-1; j<0; j--)
			theHeap.trickleDown(j);
		
		System.out.print("Heap:    ");
		theHeap.displayArray();
		theHeap.displayHeap();
		
		for(j=size-1; j>=0; j--){
			Node biggestNode = theHeap.remove();
			theHeap.insertAt(j, biggestNode);
		}
		System.out.print("Sorted:  ");
		theHeap.displayArray();
	}
	
//---------------------------------------------------------------------------------------
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
//-----------------------------------------------------------------------------------
	
	public static int getInt() throws IOException{
		String s = getString();
		return Integer.parseInt(s);
	}
}
