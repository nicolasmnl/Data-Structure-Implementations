package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL()){
				size += 1;
				aux = aux.next;
			}
		}
		return size;

	}

	@Override
	public T search(T element) {
		T data = null;
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL()){
				if (aux.getData().equals(element)) {
					data = element;
					break;
				}
				aux = aux.next;
			}

		}
		return data;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			setHead(new SingleLinkedListNode<>(element,new SingleLinkedListNode<>()));
		}else{
			SingleLinkedListNode<T> aux = getHead();
			while(true) {
				if (!aux.next.isNIL()){
					aux = aux.next;
				}else{
					break;
				}
			}
			aux.next = new SingleLinkedListNode<>(element,new SingleLinkedListNode<>());
		}
	}

	@Override
	public void remove(T element) {
		if(element != null){
			if(!isEmpty()){
				SingleLinkedListNode<T> aux = getHead();
				while(!aux.isNIL()){
					if(getHead().getData().equals(element)){
						setHead(getHead().getNext());
						break;
					}
					if(!aux.getNext().isNIL()){
						if(aux.getNext().getData().equals(element)){
							aux.setNext(aux.getNext().getNext());
							break;
						}
					}
					aux = aux.getNext();
				}
			}
		}

	}

	@Override
	public T[] toArray() {
		T[] array;
		if(isEmpty()){
			array = (T[]) new Comparable[0];
		}else{
			array = (T[]) new Comparable[size()];
			SingleLinkedListNode<T> node = getHead();
			for (int i = 0; i < array.length; i++) {
				array[i] = node.getData();
				node = node.getNext();
			}
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
