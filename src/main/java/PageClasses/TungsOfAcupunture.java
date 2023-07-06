package PageClasses;

import Base.BasePage;
import Utilities.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TungsOfAcupunture extends BasePage {
    protected WebDriver driver;
    private String TECH_1 = "cssSelector=>.chapter_inner_disease > button:nth-of-type(1)";
    private String GO = "cssSelector=>.pop_button";
    private String TILE = "cssSelector=>.card-title.h5";

    public TungsOfAcupunture(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private String getTechniques(int i) {
        return String.format("cssSelector=>.chapter_inner_disease > button:nth-of-type(%d)", i);
    }

    public boolean clickTechnique(int i) {
        WebElement technique = null, tileElement = null;
        String techiqueName = null, tileText = null;

        technique = getElement(getTechniques(i), "Get technique: " + i);
        techiqueName = technique.getText().split("\\.")[1].trim();

        try {
            waitAndClick(technique, 15, "Acupunture technique");
            waitAndClick(GO, 15, "Go button");
            tileElement = waitForPresenceOfValue(TILE, 15, "Tile", techiqueName);
            tileText = tileElement.getText();
            System.out.println(techiqueName + ">>" + tileText);
            return Util.verifyTextMatch(techiqueName, tileText);
        } catch (Exception e) {
            log.error("Exception occured");
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }


    }
}
