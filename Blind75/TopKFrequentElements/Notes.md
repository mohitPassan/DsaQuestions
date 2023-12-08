# Problem statement

Given an integer array `nums` and an integer `k`, return _the_ `k` _most frequent elements_. You may return the answer in **any order**.

**Example 1:**

**Input:** nums = [1,1,1,2,2,3], k = 2
**Output:** [1,2]

**Example 2:**

**Input:** nums = [1], k = 1
**Output:** [1]

**Constraints:**

- `1 <= nums.length <= 105`
- `-104 <= nums[i] <= 104`
- `k` is in the range `[1, the number of unique elements in the array]`.
- It is **guaranteed** that the answer is **unique**.


# Max heap

First step is to create a map with the number as key and the frequency of that number as the value. The map will look like this for the array `{ 1, 1, 1, 2, 2, 3 }`:

```
{
	1 : 3,
	2 : 2,
	3 : 1
}
```

Using this map, we can create a max heap where the element with the higher frequency will be the parent. In Java, `PriorityQueue` is used to implement min/max heaps.

For custom heaps, we can create our own `comparator` or implement `comparable` for our objects.

Once the heap is created, we can pop the heap `k` times to get our result.
## Code

```java hl:12-18
Map<Integer, Integer> map = new HashMap<>();

for (int i : nums) {
	if (map.containsKey(i)) {
		int count = map.get(i);
		map.put(i, ++count);
	} else {
		map.put(i, 1);
	}
}

Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> {
	if (o1.getValue() < o2.getValue()) {
		return 1;
	} else {
		return -1;
	}
});

for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
	queue.add(entry);
}

int[] result = new int[k];
for (int i = 0; i < k; i++) {
	result[i] = queue.poll().getKey();
}

return result;
```

# Bucket sort

The first step will remain the same. We still need the frequency map.

```
{
	1 : 3,
	2 : 2,
	3 : 1
}
```

Now, we will use bucket sort and use our frequencies as buckets. So, we will put the numbers with the same frequency in one bucket and then traverse the bucket array in reverse and keep adding elements to our result array on the way. In the end, we will return our result array.

```java hl:13-22,26-36
Map<Integer, Integer> map = new HashMap<>();

for (int i : nums) {
	if (map.containsKey(i)) {
		int c = map.get(i);
		map.put(i, ++c);
	} else {
		map.put(i, 1);
	}
}

List<Integer>[] bucket = (List<Integer>[]) new ArrayList[nums.length + 1];
for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
	int count = entry.getValue();
	int number = entry.getKey();

	if(bucket[count] == null) {
		bucket[count] = new ArrayList<>();
	}

	bucket[count].add(number);
}

int[] result = new int[k];
int index = 0;
for(int i=nums.length; i>=0; i--) {
	if(bucket[i] == null) {
		continue;
	}

	for(int n : bucket[i]) {
		result[index++] = n;
		if(index == k) {
			return result;
		}
	}
}

return result;
```