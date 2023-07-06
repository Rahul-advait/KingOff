package org.testclasses;

import PageClasses.TungsOfAcupunture;
import base.BaseClassTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AcupunturePoints extends BaseClassTest {
    TungsOfAcupunture tungsOfAcupunture;

    @DataProvider(name = "numbersProvider")
    public static Object[][] numbersProvider() {
        Object[][] numbers = new Object[100][1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i][0] = i + 1;
        }
        return numbers;
    }

    @Test(dataProvider = "numbersProvider")
    public void verifyAcupunture(Object option) {
        log.warn("Starting with " + option);
        tungsOfAcupunture = homePage.clickBook();
        boolean verify = tungsOfAcupunture.clickTechnique((int) option);
        Assert.assertTrue(verify);
    }
}
