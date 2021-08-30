package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> fNumbers = new ArrayList<>();
		int i;
		fNumbers.add(0);
		fNumbers.add(1);

		for (i = 0; fNumbers.get(i + 1) <= 350; i++) {
			int num = fNumbers.get(i) + fNumbers.get(i + 1);
			fNumbers.add(num);
		}
		return fNumbers;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> fNum;
		fNum = fibonacci();

		if (fNum.contains(a)) {
			return true;
		} else {
			return false;
		}
	}

}
