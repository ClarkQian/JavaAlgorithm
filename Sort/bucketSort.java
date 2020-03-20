private static void bucketSort(int[] a, int n) {

		int bucketSize = n;
		LinkedList<Integer>[] bucket = (LinkedList<Integer>[]) new LinkedList[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			bucket[i] = new LinkedList<Integer>();
		}

		// get Max
		int max = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}

		int count = 0;
		
		// allocation
		for (int i = 0; i < n; i++) {
			int index = bucketSize * a[i] / (max + 1);

			if (bucket[index].size() == 0) {
				bucket[index].add(a[i]);
			} else {
				for (int j = 0; j < bucket[index].size(); j++) {
					
					if (bucket[index].get(j) <= a[i]) {
						if(j == bucket[index].size()-1){
							bucket[index].add(a[i]);
							break;
						}
						continue;
					} else {
						bucket[index].add(j, a[i]);
						break;
					}
				}
			}

		}

		//COLLECTION
		int index = 0;
		for(int i = 0; i < bucketSize; i++){
			for(int j = 0; j < bucket[i].size();j++){
				a[index++] = bucket[i].get(j);
			}
		}
		
		

	}
