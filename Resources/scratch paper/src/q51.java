
public class q51 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayBoundedQueue<String> q51 = new ArrayBoundedQueue<String>();
		
		//q51.ArrayBoundedQueue(4);
		q51.enqueue("one");
		q51.enqueue("two");
		q51.enqueue("three");
		q51.enqueue("four");
		System.out.println(q51.dequeue());
		System.out.println(q51.isEmpty());
		System.out.println(q51.isFull());
		System.out.println(q51.size());

	}

}
