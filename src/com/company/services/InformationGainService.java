package com.company.services;

import com.company.pojo.Entity;
import com.company.pojo.enumAttribute.OutputAttribute;

import java.util.ArrayList;

public class InformationGainService {

	public Double getGainS (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>> list) {
		Double infoT = this.infoT(entities);
//		System.out.println("infoT = " + infoT);
		Double infoDownST = this.infoDownST(list, entities.size());
//		System.out.println("infoDownST = " + infoDownST);
		Double gainS = this.gainS(infoT, infoDownST);
//		System.out.println("gainS = " + gainS);
		return gainS;
	}

	public Double getGainRatioS (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>> list) {
		Double gainS = this.getGainS(entities, list);
//		System.out.println(gainS);
		Double splitInfoS = this.splitInfoS(entities.size(), list);
//		System.out.println(splitInfoS);
		Double gainRatioS = this.gainRatioS(gainS, splitInfoS);
//		System.out.println("gainRatioS = " + gainRatioS);
		return gainRatioS;
	}

	public Double getGeneralIndicatorCART (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>> list) {
		Double multiplication = this.multiplicationForCART(entities, list);
		Double w = this.wForCART(list);
		return multiplication * w;
	}

	private Double multiplicationForCART (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>> list) {
		double pDownL = (double) list.get(0).size() / entities.size();
		double pDownR = (double) list.get(1).size() / entities.size();
		return (double) 2 * pDownL * pDownR;
	}

	private Double wForCART (ArrayList<ArrayList<Entity>> lists) {
		Double[] arrayOfPjtDownL = new Double[OutputAttribute.values().length];
		Double[] arrayOfPjtDownR = new Double[OutputAttribute.values().length];
		int sizeLeft = lists.get(0).size();
		int sizeRight = lists.get(1).size();
		for (int i = 0; i < OutputAttribute.values().length; i++) {
			OutputAttribute out = OutputAttribute.values()[i];
			Integer first = this.freq(out, lists.get(0));
			Integer second = this.freq(out, lists.get(1));
			if (first == 0) {
				arrayOfPjtDownL[i] = 0.0;
			} else {
				arrayOfPjtDownL[i] = (double) first / sizeLeft;
			}
			if (second == 0) {
				arrayOfPjtDownR[i] = 0.0;
			} else {
				arrayOfPjtDownR[i] = (double) second / sizeRight;
			}
		}
		double w = 0.0;
		for (int i = 0; i < OutputAttribute.values().length; i++) {
			w += Math.abs(arrayOfPjtDownL[i] - arrayOfPjtDownR[i]);
		}
		return w;
	}

	private Double infoT (ArrayList<Entity> entities) {
		double resultInfoT = 0.0;
		for (int i = 0; i < OutputAttribute.values().length; i++) {
			Integer freqArray = freq(OutputAttribute.values()[i], entities);
			if (freqArray != 0) {
//			System.out.println("C" + (i + 1) + ": freq = " + freqArray);
				Double number = (double) freqArray / entities.size();
//			System.out.println("C" + (i + 1) + ": number = " + number);
//			System.out.println("C" + (i + 1) + ": log = " + log(2, number));
				resultInfoT += (-number) * log(2, number);
//			System.out.println("C" + (i + 1) + ": resultInfoT = " + resultInfoT);
//			System.out.println("---");
			}
		}
		return resultInfoT;
	}

	private Double infoDownST (ArrayList<ArrayList<Entity>> entities, Integer number) {

		double infoDownST = 0.0;
		for (ArrayList groupOfEntities : entities) {
			Double first = ((double) groupOfEntities.size() / number);
			Double infoT = infoT(groupOfEntities);
			infoDownST += first * infoT;
		}
		return infoDownST;
	}

	private Double gainS (Double infoT, Double infoDownST) {
		return infoT - infoDownST;
	}

	private Integer freq (OutputAttribute outputAttribute, ArrayList<Entity> entities) {
		Integer freq = 0;
		for (Entity entity : entities) {
			if (entity.getOutputAttribute().equals(outputAttribute)) {
				freq++;
			}
		}
		return freq;
	}

	private Double splitInfoS (Integer powerOfSet, ArrayList<ArrayList<Entity>> entities) {
		double splitInfoS = 0.0;

		for (ArrayList listEntity : entities) {
			if (listEntity.size() != 0) {
				Double number = (double) listEntity.size() / powerOfSet;
				splitInfoS += -number * log(2, number);
			}
		}
		return splitInfoS;
	}

	private Double gainRatioS (Double gainS, Double splitInfoS) {
		if (gainS == 0.0) return 0.0;
		return gainS / splitInfoS;
	}

	private Double log (Integer osn, Double num) {
		return ((Math.log(num)) / (Math.log(osn)));
	}

}

