package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(element == null){
			return;
		}
		if(isEmpty()) {
			head = 0;
			tail = 0;
		}else {
			tail = (tail + 1) % array.length;
		}
		array[tail] = element;
		elements += 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T temp = array[head];
		if(head == tail){
			head = -1;
			tail = -1;
		}else{
			head = (head + 1)%array.length;
		}
		elements -= 1;
		return temp;

	}

	@Override
	public T head() {
		T oldest = null;
		if(!isEmpty()){
			oldest = array[head];
		}
		return oldest;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty;
		if(array.length == 0){
			isEmpty = true;
		}else{
			isEmpty = (tail == -1 && head == -1);
		}
		return isEmpty;
	}

	@Override
	public boolean isFull() {
		boolean isFull;
		if(array.length == 0){
			isFull = true;
		}else{
			isFull = ((tail+1) % array.length) == head;
		}
		return isFull;
	}

}
