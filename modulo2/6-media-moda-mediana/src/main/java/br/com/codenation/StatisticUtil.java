package br.com.codenation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;
		for (int element : elements) {
		    soma = soma + element;
        }
		int media = soma / elements.length;
		return media;
	}

	public static int mode(int[] elements) {
		int maxNum = 0;
		int mode = 0;
		for (int element : elements) {
			int number = 0;
			for (int num : elements) {
				if (num == element) {
					number++;
				}
			}
			if (number > maxNum) {
				maxNum = number;
				mode = element;
			}
		}
		return mode;
	}

	public static int median(int[] elements) {
		boolean finished = true;
	    do {
			for (int i = 0; i < elements.length - 1; i++) {
				if (elements[i] > elements[i + 1]) {
					finished = false;
					int temp = elements[i];
					elements[i] = elements[i+1];
					elements[i+1] = temp;
				}
			}
		} while(!finished);

//		Arrays.sort(elements);

		int myMedian = 0;
		if (elements.length %2 != 0) {
			myMedian = Array.getInt(elements, elements.length / 2);
		} else {
			int[] centerNumbers = {};
			centerNumbers[centerNumbers.length] = centerNumbers[(centerNumbers.length / 2) - 1];
			centerNumbers[centerNumbers.length] = centerNumbers[(centerNumbers.length / 2)];
			myMedian = centerNumbers[0] + centerNumbers[1];
		}
		return myMedian;
	}
}