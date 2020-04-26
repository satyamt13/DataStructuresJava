import java.util.ArrayList;
//Linked List structure to help deal with collision using chaining 
class hashNode<K,V>{
	
	K key;
	V value;
	hashNode<K,V> next;
	
	hashNode(K key, V value){
		this.key = key;
		this.value = value;
	}
}

/*
 * Implementation of a basic generic hash map with chaining 
 * for collision resolution using Linked Lists. This hashmap's
 * hash function consists of the hash value provided by java 
 * for the hashcode and a modulo with size of the hash table for the 
 * compressor
 */
class hashMap<K,V> {
	private ArrayList<hashNode<K,V>> bucketArray;
	private int numBuckets;
	private int size;
	
	public hashMap() {
		this.bucketArray = new ArrayList<>();
		this.numBuckets = 10;
		this.size = 0;
		for(int i = 0; i < this.numBuckets ; i++) {
			this.bucketArray.add(null);
		}
	}
	
	public int size() { 
		return this.size;
		}
	
	public boolean isEmpty() { 
		return this.size() == 0;
		}
	//Method that applies the hashfunction to the given key and returns the index
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % this.numBuckets;
		return index;
	}
	/*
	 * Method that removes the key,value pair from our hashmap given a key
	 * It requires us to get the index of the key by applying the hash function 
	 * and then traversing the linked lists associated with that index to find 
	 * the key,value pair to remove if any and the returns the value 
	 */
	public V remove(K key) {
		
		int bucketIndex = this.getBucketIndex(key);
		hashNode<K,V> head = this.bucketArray.get(bucketIndex);
		hashNode<K,V> prev = null;
		
		while(head != null) {
			if(head.key.equals(key)) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if(head == null) {
			return null;
		}
		
		this.size--;
		
		if(prev != null) {
			prev.next = head.next;
		}
		else {
			this.bucketArray.set(bucketIndex, head.next);
		}
		return head.value;
	}
	/*
	 * Similar to the remove function but instead of removing the 
	 * key,value pair it simply returns the value associated with the 
	 * provided key if it exists 
	 */
	public V get(K key) {
		
		int bucketIndex = this.getBucketIndex(key);
		hashNode<K,V> head = this.bucketArray.get(bucketIndex);
		while(head != null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;	
	}
	/*
	 * This is a two part function 
	 * Part 1: Get the index of the given key by applying the hash function
	 * and inserting the key value pair in the correct chain in the hash table 
	 * Part2: Check if load factor has exceeded the threshold of 0.7, if it has then the 
	 * method resizes the hash table by doubling it's allowed capacity and adds all the key,value 
	 * pairs in their new positions in the hash table again
	 */
	public void  add(K key, V value) {
		
		int bucketIndex = this.getBucketIndex(key);
		hashNode<K, V> head = this.bucketArray.get(bucketIndex);
		
		while(head != null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		this.size ++;
		head = this.bucketArray.get(bucketIndex);
		hashNode<K,V> newNode = new hashNode<K,V>(key,value);
		newNode.next = head;
		this.bucketArray.set(bucketIndex,newNode);
		
		if((1.0*this.size)/this.numBuckets >= 0.7) {
			
			ArrayList<hashNode<K,V>> temp = this.bucketArray;
			this.bucketArray = new ArrayList<>();
			this.numBuckets = this.numBuckets * 2;
			this.size = 0;
			
			for(int i = 0; i < this.numBuckets; i++) {
				this.bucketArray.add(null);
			}
			
			for(hashNode<K,V> headNode : temp) {
				while(headNode != null) {
					this.add(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
			
		}
	}
	
	
	public static void main(String args[]) {
		hashMap<String,Integer> HashMap = new hashMap<>();
		HashMap.add("Alpha",1);
		HashMap.add("Bravo",2);
		HashMap.add("Echo",5);
		System.out.println("The current hash map size is " + HashMap.size());
		HashMap.remove("Alpha");
		System.out.println("The current hash map size is " + HashMap.size());
		HashMap.remove("Bravo");
		HashMap.remove("Echo");
		HashMap.remove("Foxtrot");
		System.out.println("The current hash map size is " + HashMap.size());
		System.out.println("The hash map is empy: " + HashMap.isEmpty());
	}
	
}