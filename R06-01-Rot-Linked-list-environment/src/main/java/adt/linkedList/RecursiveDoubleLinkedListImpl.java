package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.setData(element);
			RecursiveDoubleLinkedListImpl<T> nextNode = new RecursiveDoubleLinkedListImpl<>();
			this.setNext(nextNode);
			if(this.getPrevious() == null){
				this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
			}
			this.getPrevious().setNext(this);
			nextNode.setPrevious(this);
		} else {
			getNext().insert(element);
		}
	}


	@Override
	public void remove(T element) {
		if(!isEmpty()){
			if(this.getData().equals(element)){
				if(this.getPrevious().isEmpty() && this.getNext().isEmpty()){
					this.setData(null);
					this.setNext(null);
					this.setPrevious(null);
				}else{
					this.setData(this.getNext().getData());
					this.setNext(this.getNext().getNext());
					if(this.getNext() != null){
						((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
					}

				}
			}else{
				this.getNext().remove(element);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if(this.isEmpty()){
			this.setData(element);
			RecursiveDoubleLinkedListImpl<T> nextNode = new RecursiveDoubleLinkedListImpl<>();
			this.setNext(nextNode);
			if(this.getPrevious() == null){
				this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
			}
			this.getPrevious().setNext(this);
			nextNode.setPrevious(this);
		}else{
			RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();
			newNode.setData(this.getData());
			this.setData(element);
			newNode.setNext(this.getNext());
			this.setNext(newNode);
			newNode.setPrevious(this);
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			this.setData(this.getNext().getData());
			this.setNext(this.getNext().getNext());
			if(this.getNext() != null){
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.getNext().isEmpty()){
				this.setData(this.getNext().getData());
				this.setNext(null);
			}else{
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
