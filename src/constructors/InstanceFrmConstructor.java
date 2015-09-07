package constructors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InstanceFrmConstructor {
	

	static class SynchronizedCollection<E> implements Collection<E>{
		Collection c;
		Object mutex;
		public SynchronizedCollection(Collection c) {
		this.c = c;	
		this.mutex = this;
			// TODO Auto-generated constructor stub
		}
//		public SynchronizedCollection synchronizedCollection(){
//			
//		}
		@Override
		public boolean add(E arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	public static void main(String[] args) {
		InstanceFrmConstructor.SynchronizedCollection(new ArrayList());
		
	}
}