package algopractice;

public class MakeMyTripRollingHashMap
{

	public static void main(String[] args)
	{
		RollingHashMap<String, String> h = new RollingHashMap();

		h.put("Akshat", "India");

		try
		{
			// Let 5 seconds pass
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			// Do nothing. It is just IndexAt1Starts run

		}

		h.put("Akshat", "Delhi");

		try
		{
			// Let 5 more seconds pass. So total 10 second passed
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			// Do nothing. It is just IndexAt1Starts run

		}

		h.put("Verma", "Gurgaon");

		System.out.println(h.get("Akshat", -1));
		System.out.println(h.get("Akshat", 0));
		System.out.println(h.get("Akshat", 1));
		System.out.println(h.get("Akshat", 2));
		System.out.println(h.get("Akshat", 5));
		System.out.println(h.get("Akshat", 10));

		System.out.println(h.get("Verma", 7));
		System.out.println(h.get("Verma", 10));
		System.out.println(h.get("Verma", 25));

	}

}

/**
 * This is the required RollingHashMap class.
 * 
 * @author ashrinagar
 *
 * @param <K>
 * @param <V>
 */
class RollingHashMap<K, V>
{

	private Node[] mapStore = new Node[16];
	private final float loadfactor = 0.75f;
	private int size = 0;

	public void put(K k, V v)
	{
		if (mapStore.length * loadfactor < size)
		{
			resize();
		}

		insertIntoMapStore(k, v);
	}

	/**
	 * 
	 * @param k
	 * @param t
	 * @return
	 */
	public V get(K k, Integer t)
	{
		int index = k.hashCode() > -1 ? k.hashCode() % mapStore.length : mapStore.length + k.hashCode() % mapStore.length;

		Node temp = mapStore[index];

		while (temp != null)
		{
			if (temp.k.hashCode() == k.hashCode() && temp.k.equals(k))
			{
				Entry<Integer, V> e = temp.list.get(t);

				return e == null ? null : e.v;
			}

			temp = temp.next;
		}

		return null;
	}

	/**
	 * This function is called to resize the map if size of mapStore go beyond load factor.
	 */
	private void resize()
	{
		size = 0;

		Node[] temp = mapStore;

		mapStore = new Node[mapStore.length * 2];

		for (Node n : temp)
		{
			if (n == null)
				continue;

			while (n != null)
			{
				// New node should be made and inserted into new table. Old node (n) is already having a linkedlist from it.
				insertIntoMapStore(new Node(n.k, n.list));
				n = n.next;
			}
		}
	}

	/**
	 * This method is used by resize function to rearrange the Hashmap when size of internal array go beyond loadfactor.
	 * 
	 * @param n
	 */
	private void insertIntoMapStore(Node n)
	{
		int index = n.k.hashCode() > -1 ? n.k.hashCode() % mapStore.length : mapStore.length + n.k.hashCode() % mapStore.length;

		if (mapStore[index] == null)
		{
			mapStore[index] = n;
			size++;
		}
		else
		{
			Node temp = mapStore[index];

			while (temp.next != null)
			{
				temp = temp.next;
			}

			temp.next = n;
		}

	}

	/**
	 * This function stores new values into the mapStore
	 * 
	 * @param k
	 * @param v
	 */
	private void insertIntoMapStore(K k, V v)
	{
		int index = k.hashCode() > -1 ? k.hashCode() % mapStore.length : mapStore.length + k.hashCode() % mapStore.length;

		if (mapStore[index] == null)
		{
			mapStore[index] = new Node(k, new MyArrayList<V>(new Entry<Integer, V>(Utility.getTime(), v)));
			size++;
		}
		else
		{
			Node temp = mapStore[index];

			while (temp != null)
			{
				if (temp.k.hashCode() == k.hashCode() && temp.k.equals(k))
				{
					temp.list.add(new Entry(Utility.getTime(), v));

					return;
				}
				else if (temp.next != null)
				{

					temp = temp.next;
				}
				else
				{
					temp.next = new Node(k, new MyArrayList<V>(new Entry<Integer, V>(Utility.getTime(), v)));
					return;
				}
			}

		}
	}

	/**
	 * This class will help in making linkedlist of Node in HashMap.
	 * 
	 * @author ashrinagar
	 *
	 * @param <K>
	 */
	private class Node<K>
	{
		Node next;
		K k;
		MyArrayList list;

		public Node(K k, MyArrayList list)
		{
			this.k = k;
			this.list = list;
		}

	}

	/**
	 * This class will help in fetching values using binary search. So, the complexity will of order O(log n).
	 * 
	 * @author ashrinagar
	 *
	 */
	private class MyArrayList<V>
	{

		Entry<Long, V>[] store = new Entry[10];
		int size;

		MyArrayList(Entry e)
		{
			store[0] = e;
			size++;
		}

		/**
		 * Return value at time t or before using binary search operation on array.
		 * 
		 * @param t
		 * @return
		 */
		Entry get(int t)
		{
			int temp = size / 2;

			while (temp < size)
			{
				if (t < (store[0]).t)
				{
					return null;
				}
				else if (temp - 1 > -1 && t >= (store[temp - 1]).t && t < store[temp].t)
				{
					return store[temp - 1];
				}
				else
				{
					if (t < store[temp].t)
					{
						temp = temp / 2;
					}
					else if (temp == 1 || temp == 0)
					{
						temp++;
					}
					else
					{
						temp = (3 * temp) / 2;

					}
				}
			}
			return store[size - 1];
		}

		/**
		 * Add new entry to array. It does changes the array to have array of increased size.
		 * 
		 * @param e
		 */
		void add(Entry e)
		{
			if (size < store.length)
			{
				store[size++] = e;
			}
			else
			{
				store = copytoOtherArray(store, new Entry[store.length * 2]);

				store[size++] = e;
			}
		}

		private Entry[] copytoOtherArray(Entry[] from, Entry[] to)
		{
			for (int i = 0; i < from.length; i++)
			{
				to[i] = from[i];
			}

			return to;
		}
	}

	/**
	 * These entries will go into MyArrayList
	 * 
	 * @author ashrinagar
	 *
	 * @param <Long>
	 * @param <V>
	 */
	private class Entry<Integer, V>
	{
		public int t;
		V v;

		public Entry(int t, V v)
		{
			this.t = t;
			this.v = v;
		}

	}

}

/**
 * Utility class to get time.
 * 
 * @author ashrinagar
 *
 */
class Utility
{

	private static long beginTime = System.currentTimeMillis() / 1000;

	public static int getTime()
	{
		return (int) (System.currentTimeMillis() / 1000 - beginTime);
	}
}
