package com.company.services;

import com.company.pojo.Entity;
import com.company.pojo.enumAttribute.FirstAttribute;
import com.company.pojo.enumAttribute.FourthAttribute;
import com.company.pojo.enumAttribute.OutputAttribute;
import com.company.pojo.enumAttribute.SecondAttribute;

import java.util.ArrayList;
import java.util.Random;

public class Helper {

	private InformationGainService gainService = new InformationGainService();

	public Integer findMaxInformationGain (Double[] array) throws Exception {
		boolean isAllEquals = true;
		Random random = new Random();
		Double maxVal = array[0];
		int maxInd = 0;
		for (int i = 1; i < array.length; i++) {
			if ((array[i]).equals(maxVal)) {
				if (random.nextBoolean()) {
					maxInd = i;
					maxVal = array[i];
				}
			}
			if ((array[i]).compareTo(maxVal) == 1) {
				isAllEquals = false;
				maxInd = i;
				maxVal = array[i];
			}
			if ((array[i]).compareTo(maxVal) == -1) {
				isAllEquals = false;
			}
		}
		if (isAllEquals) {
			throw new Exception("equals");
		}
		return maxInd;
	}

	public Double[] listsOfGainSInitializer (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>>[] lists) {
		Double gainS[] = new Double[lists.length];
		System.out.print("1. Gain(S) for 1st attribute: ");
		gainS[0] = gainService.getGainS(entities, lists[0]);
		System.out.println(gainS[0]);
		System.out.print("2. Gain(S) for 2st attribute: ");
		gainS[1] = gainService.getGainS(entities, lists[1]);
		System.out.println(gainS[1]);
		System.out.print("3. Gain(S) for 3rd attribute (middle): ");
		gainS[2] = gainService.getGainS(entities, lists[2]);
		System.out.println(gainS[2]);
		System.out.print("4. Gain(S) for 4th attribute: ");
		gainS[3] = gainService.getGainS(entities, lists[3]);
		System.out.println(gainS[3]);
		System.out.print("5. Gain(S) for 5th attribute (middle): ");
		gainS[4] = gainService.getGainS(entities, lists[4]);
		System.out.println(gainS[4]);
		System.out.print("6. Gain(S) for 3rd attribute (left less): ");
		gainS[5] = gainService.getGainS(entities, lists[5]);
		System.out.println(gainS[5]);
		System.out.print("7. Gain(S) for 3rd attribute (left more): ");
		gainS[6] = gainService.getGainS(entities, lists[6]);
		System.out.println(gainS[6]);
		System.out.print("8. Gain(S) for 5th attribute (left less): ");
		gainS[7] = gainService.getGainS(entities, lists[7]);
		System.out.println(gainS[7]);
		System.out.print("9. Gain(S) for 5th attribute (left more): ");
		gainS[8] = gainService.getGainS(entities, lists[8]);
		System.out.println(gainS[8]);
		return gainS;
	}

	public Double[] listsOfGainRatioSInitializer (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>>[] lists) {
		Double gainRatioS[] = new Double[9];
		System.out.print("1. GainRatio(S) for 1st attribute: ");
		gainRatioS[0] = gainService.getGainRatioS(entities, lists[0]);
		System.out.println(gainRatioS[0]);
		System.out.print("2. GainRatio(S) for 2st attribute: ");
		gainRatioS[1] = gainService.getGainRatioS(entities, lists[1]);
		System.out.println(gainRatioS[1]);
		System.out.print("3. GainRatio(S) for 3rd attribute (middle): ");
		gainRatioS[2] = gainService.getGainRatioS(entities, lists[2]);
		System.out.println(gainRatioS[2]);
		System.out.print("4. GainRatio(S) for 4th attribute: ");
		gainRatioS[3] = gainService.getGainRatioS(entities, lists[3]);
		System.out.println(gainRatioS[3]);
		System.out.print("5. GainRatio(S) for 5th attribute (middle): ");
		gainRatioS[4] = gainService.getGainRatioS(entities, lists[4]);
		System.out.println(gainRatioS[4]);
		System.out.print("6. GainRatio(S) for 3rd attribute (left less): ");
		gainRatioS[5] = gainService.getGainRatioS(entities, lists[5]);
		System.out.println(gainRatioS[5]);
		System.out.print("7. GainRatio(S) for 3rd attribute (left more): ");
		gainRatioS[6] = gainService.getGainRatioS(entities, lists[6]);
		System.out.println(gainRatioS[6]);
		System.out.print("8. GainRatio(S) for 5th attribute (left less): ");
		gainRatioS[7] = gainService.getGainRatioS(entities, lists[7]);
		System.out.println(gainRatioS[7]);
		System.out.print("9. GainRatio(S) for 5th attribute (left more): ");
		gainRatioS[8] = gainService.getGainRatioS(entities, lists[8]);
		System.out.println(gainRatioS[8]);
		return gainRatioS;
	}

	public Double[] listsOfCARTGeneralIndicators (ArrayList<Entity> entities, ArrayList<ArrayList<Entity>>[] lists) {
		Double generalIndicator[] = new Double[lists.length];
		System.out.print("1. GeneralIndicators for 3rd attribute (left less): ");
		generalIndicator[0] = gainService.getGeneralIndicatorCART(entities, lists[0]);
		System.out.println(generalIndicator[0]);
		System.out.print("2. GeneralIndicators for 3rd attribute (middle): ");
		generalIndicator[1] = gainService.getGeneralIndicatorCART(entities, lists[1]);
		System.out.println(generalIndicator[1]);
		System.out.print("3. GeneralIndicators for 3rd attribute (left more): ");
		generalIndicator[2] = gainService.getGeneralIndicatorCART(entities, lists[2]);
		System.out.println(generalIndicator[2]);
		System.out.print("4. GeneralIndicators for 5rd attribute (left less): ");
		generalIndicator[3] = gainService.getGeneralIndicatorCART(entities, lists[3]);
		System.out.println(generalIndicator[3]);
		System.out.print("5. GeneralIndicators for 5rd attribute (middle): ");
		generalIndicator[4] = gainService.getGeneralIndicatorCART(entities, lists[4]);
		System.out.println(generalIndicator[4]);
		System.out.print("6. GeneralIndicators for 5rd attribute (left more): ");
		generalIndicator[5] = gainService.getGeneralIndicatorCART(entities, lists[5]);
		System.out.println(generalIndicator[5]);
		int i = 6;
		for (FirstAttribute first : FirstAttribute.values()) {
			System.out.print((i + 1) + ". GeneralIndicators for 1st attribute (" + first.toString() + "): ");
			generalIndicator[i] = gainService.getGeneralIndicatorCART(entities, lists[i]);
			System.out.println(generalIndicator[i]);
			i++;
		}
		for (SecondAttribute second : SecondAttribute.values()) {
			System.out.print((i + 1) + ". GeneralIndicators for 2nd attribute (" + second.toString() + "): ");
			generalIndicator[i] = gainService.getGeneralIndicatorCART(entities, lists[i]);
			System.out.println(generalIndicator[i]);
			i++;
		}
		for (FourthAttribute fourth : FourthAttribute.values()) {
			System.out.print((i + 1) + ". GeneralIndicators for 4th attribute (" + fourth.toString() + "): ");
			generalIndicator[i] = gainService.getGeneralIndicatorCART(entities, lists[i]);
			System.out.println(generalIndicator[i]);
			i++;
		}
		return generalIndicator;
	}

	public Boolean isOnlySingleClass (ArrayList<Entity> entities) {
		OutputAttribute outputAttribute = entities.get(0).getOutputAttribute();
		for (Entity entity : entities) {
			if (!entity.getOutputAttribute().equals(outputAttribute)) return false;
		}
		return true;
	}
}
