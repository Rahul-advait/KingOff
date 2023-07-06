package PageClasses;

import Base.BasePage;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class HomePage extends BasePage {
    private WebDriver driver;
    private String URL = "https://newkingsoff.itechnolabs.tech/";
    private String ACUPUNTURE_LINK = "cssSelector=>.chat_first_img_right > button:nth-of-type(5)";
    private String BOOK_TUNGS = "cssSelector=>.chapter_text_div > button:nth-of-type(1)";


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isOpen() {
        return isOpen(URL);
    }

    public void clickAcupuntureLink() {
        waitAndClick(ACUPUNTURE_LINK, 15, "ACUPUNTURE_LINK");
    }
    public TungsOfAcupunture clickBook(){
        waitAndClick(BOOK_TUNGS, 15,"BOOK_TUNGS");
        return new TungsOfAcupunture(driver);
    }

    public boolean isElementPresent(){
        return isElementPresent(BOOK_TUNGS, "BOOK_TUNGS");
    }
}
