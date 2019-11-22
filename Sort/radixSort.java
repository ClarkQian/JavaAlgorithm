public static void radixSort(int[] a) {

		ArrayList<Integer>[] bucket = new ArrayList[10];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}

		int digit = 0;

		if (max == 0)
			digit = 0;
		else

			while (max != 0) {
				max /= 10;
				digit++;
			}

		for (int i = 0; i < digit; i++) {// 执行最大位数趟次

			int index = 0;

			// put in the bucket
			for (int j = 0; j < a.length; j++) {
				int tmp;
				if (i != 0)
					tmp = (int) (a[j] / Math.pow(10 , i));
				else
					// i = 0
					tmp = a[j];

				int flag = tmp % 10;
				bucket[flag].add((Integer) a[j]);
			}

			// get out the bucket
			for (int k = 0; k < 10; k++) {
				for (int t = 0; t < bucket[k].size(); t++) {
					a[index] = (Integer) bucket[k].get(t);
					index++;
				}
			}
			
			//clear the bucket
			for(int c = 0; c < 10; c++){
				bucket[c].clear();
			}

		}

	}
