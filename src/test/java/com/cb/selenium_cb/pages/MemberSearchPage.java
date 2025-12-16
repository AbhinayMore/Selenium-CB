package com.cb.selenium_cb.pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Locators (adjust these if your actual XPaths differ)
    private By searchMembers = By.xpath("//*[@id=\"rightSidebar\"]/div/div/div[1]/div/div[1]/input");
    private By selectCategory = By.xpath("//*[@id=\"rightSidebar\"]/div/div/div[1]/div/div[2]/div[1]/div/select");
    private By selectHub = By.xpath("//*[@id=\"rightSidebar\"]/div/div/div[1]/div/div[2]/div[2]/div/select");
    private By applyFilterBtn = By.xpath("//*[@id=\"rightSidebar\"]/div/div/div[1]/div/div[3]/button/b");
    private By resetBtn = By.xpath("//button[contains(text(),'Reset')]");
//    private By noResultsMsg = By.xpath("//div[contains(text(),'No results found')]");

    public MemberSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Enter search keyword
    public void enterSearchKeyword(String keyword) {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(searchMembers));
        el.clear();
        el.sendKeys(keyword);
    }

    public void selectCategoryRandom() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCategory));
        Select dropdown = new Select(el);
        List<WebElement> options = dropdown.getOptions();

        // avoid selecting the first placeholder option (index 0)
        if (options.size() > 1) {
            int randomIndex = new Random().nextInt(options.size() - 1) + 1;
            dropdown.selectByIndex(randomIndex);
            System.out.println("✅ Random category selected: " + options.get(randomIndex).getText());
        } else {
            System.out.println("⚠️ No selectable options found in category dropdown.");
        }
    }

 // ✅ Select a random hub
    public void selectHubRandom() {
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(selectHub));
        Select dropdown = new Select(el);
        List<WebElement> options = dropdown.getOptions();

        if (options.size() > 1) {
            int randomIndex = new Random().nextInt(options.size() - 1) + 1; // skip 0
            dropdown.selectByIndex(randomIndex);
            System.out.println("✅ Random hub selected: " + options.get(randomIndex).getText());
        } else {
            System.out.println("⚠️ No selectable options found in hub dropdown.");
        }
    }


    // ✅ Click "Apply Filter" button
    public void clickApplyFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(applyFilterBtn)).click();
    }

    // ✅ Click "Reset" button
    public void clickReset() {
        wait.until(ExpectedConditions.elementToBeClickable(resetBtn)).click();
    }

    // ✅ Check if a specific member is found
 // ✅ Check if a specific member is found
    public boolean isMemberFound(String memberName) {
        try {
            List<WebElement> members = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//div[contains(@class,'member-list')]//h6 | //table//tr/td[1]")
                )
            );

            for (WebElement member : members) {
                String name = member.getText().trim();
                if (name.equalsIgnoreCase(memberName)) {
                    return true;
                }
            }
            return false;

        } catch (TimeoutException e) {
            return false;
        }
    }


//    // ✅ Check if "No results found" is displayed
//    public boolean isNoResultsDisplayed() {
//        try {
//            WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(noResultsMsg));
//            return el.isDisplayed();
//        } catch (TimeoutException e) {
//            return false;
//        }
    }

