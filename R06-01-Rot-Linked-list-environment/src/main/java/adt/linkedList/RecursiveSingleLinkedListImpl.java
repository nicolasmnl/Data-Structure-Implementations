package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int cont = 0;
		if(!isEmpty()){
			cont = 1 + this.getNext().size();
		}
		return cont;
	}

	@Override
	public T search(T element) {
		T output;
		if(isEmpty()){
			output = null;
		}else{
			if(this.getData().equals(element)){
				output = this.getData();
			}else{
				output = this.getNext().search(element);
			}
		}
		return output;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		}else{
			this.getNext().insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if(this.getData().equals(element)){
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			}else{
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		if(isEmpty()){
			return (T[]) new Object[0];
		}
		T[] array = (T[]) new Object[size()];
		return this.toArrayAux(array, this, 0);
	}

	private T[] toArrayAux(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {
		if (node.isEmpty()) {
			return array;
		}else{
			array[i] = node.getData();
			return toArrayAux(array, node.getNext(), i + 1);
		}

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
