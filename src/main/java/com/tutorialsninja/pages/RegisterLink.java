package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterLink extends Utility {
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");
    By accountList = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By path = By.xpath("//h1[contains(text(),'Register Account')]");
    By name = By.id("input-firstname");
    By lastname = By.id("input-lastname");
    By email = By.id("input-email");
    By telephone = By.id("input-telephone");
    By password = By.id("input-password");
    By confirmPassword = By.id("input-confirm");
    By radioButton = By.xpath("//fieldset[3]//input");
    By checkBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueButton =  By.xpath("//div[@class = 'buttons']//input[@value='Continue']");
    By path1 = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continue1= By.xpath("//a[contains(text(),'Continue')]");
    By path2 = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continue2 = By.xpath("//a[contains(text(),'Continue')]");
    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = getListOfElements(accountList);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = getListOfElements(accountList);
        }
    }
    public void clickOnMyAccount() {
        //Clicking on MyAccount link
        clickOnElement(myAccount);

    }
    public String getMessage() {
        //Getting message from webpage to verify
        return getTextFromElement(path);
    }
    public void sendName(String details){
        //Entering details to name field
        sendTextToElement(name ,details);
    }
    public void sendLastName(String details){
        //Entering details to lastname field
        sendTextToElement(lastname,details);
    }
    public void sendEmail(String details){
        //Entering details to email field
        sendTextToElement(email,details);
    }
    public void sendTelephone(String details){
        //Entering details to telephone field
        sendTextToElement(telephone,details);
    }
    public void sendPassword(String details){
        //Entering details to password field
        sendTextToElement(password,details);
    }
    public void sendConfirmPassword(String details){
        //Confirming password
        sendTextToElement(confirmPassword,details);
    }
    public void clickOnRadioButton(String details){
        //Clicking on subscription radio buttons
        clickOnElement(radioButton);
    }
    public void clickOnCheckbox(){
        //Clicking on Terms and condition checkbox
        clickOnElement(checkBox);
        //continue button after registering all mandatory details
        clickOnElement(continueButton);
    }
    public String getMessage1() {
        // method to verify Account Created
        return getTextFromElement(path1);
    }
    public void clickOnContinue1(){
//Continue button after registration finishes
        clickOnElement(continue1);
    }
    public String getMessage2() {
// method to verify Logout
        return getTextFromElement(path2);
    }
    public void clickOnContinue2(){
        //Continue button after log out to go on main page
        clickOnElement(continue2);
    }


}

