package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T oldest = null;
		if(!isEmpty()){
			oldest = array[0];
		}
		return oldest;
	}

	@Override
	public boolean isEmpty() {
		boolean isEmpty;
		if(array.length == 0){
			isEmpty = true;
		}else{
			isEmpty = tail == -1;
		}
		return isEmpty;
	}

	@Override
	public boolean isFull() {
		boolean isFull;
		if(array.length == 0){
			isFull = true;
		}else{
			isFull = tail == array.length - 1;
		}
		return isFull;
	}

	private void shiftLeft() {
		for (int i = 1; i < array.length; i++) {
			array[i] = array[i - 1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}else if(element != null){
			array[++tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		for (T element:array) {
			System.out.println(element);;
		}
		if(isEmpty()){
			throw new QueueUnderflowException();
		}else{
			T temp = head();
			shiftLeft();
			tail--;
			return temp;
		}

	}


}
