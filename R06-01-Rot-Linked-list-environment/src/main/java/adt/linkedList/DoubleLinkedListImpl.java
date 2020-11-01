package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<>(element,new DoubleLinkedListNode<>(),new DoubleLinkedListNode<>());
		if(isEmpty()){
			setHead(node);
			setLast((DoubleLinkedListNode<T>) this.head);
		}else{
			node.setNext(this.getHead());
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
			head.setPrevious(node);
			setHead(node);

		}
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			setHead(new DoubleLinkedListNode<>(element,null,null));
			setLast((DoubleLinkedListNode<T>) this.head);
		}else{
			DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element,new DoubleLinkedListNode<>(),new DoubleLinkedListNode<>());
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);
			setLast(newNode);
		}
	}

	@Override
	public T search(T element) {
		return super.search(element);
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if(this.head.getData().equals(element)){
				removeFirst();
			}else{
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) getHead();
				while(aux != null){
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
					aux = (DoubleLinkedListNode<T>) aux.getNext();
				}
			}
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(this.head.getNext().isNIL()){
				this.head = new DoubleLinkedListNode<>();
				this.last = new DoubleLinkedListNode<>();
			}else{
				setHead(this.head.getNext());
				DoubleLinkedListNode<T> first = (DoubleLinkedListNode<T>) this.head;
				first.previous = new DoubleLinkedListNode<>();
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			DoubleLinkedListNode<T> node = getLast().getPrevious();
			setLast(node);
			node.setNext(new DoubleLinkedListNode<>());
		}
	}


	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
