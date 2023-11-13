package com.premraj.ui_layer.pages;

import com.premraj.annotation.Page;
import com.premraj.config.FakerConfig;
import com.premraj.ui_layer.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class CheckoutPage extends Base {


    private By CHECKOUT_PRODUCT = By.id("cart_checkout1");
    private By GUEST_CHECKOUT = By.id("accountFrm_accountguest");
    private By CHECKOUT_CONTINUE =By.cssSelector("button[title='Continue']");

    private By FIRSTNAME = By.id("guestFrm_firstname");
    private By LASTNAME = By.id("guestFrm_lastname");
    private By EMAIL = By.id("guestFrm_email");
    private By TELEPHONE = By.id("guestFrm_telephone");
    private By ADDRESS = By.id("guestFrm_address_1");
    private By CITY = By.id("guestFrm_city");
    private By COUNTRY = By.id("guestFrm_country_id");
    private By STATE = By.id("guestFrm_zone_id");
    private By POSTALCODE = By.id("guestFrm_postcode");

    private By CONTINUE = By.cssSelector("button[title='Continue']");

    private By PRODUCT_NAME = By.cssSelector("a[class='checkout_heading']");
    private By PRODUCT_PRICE = By.cssSelector("td[class='checkout_heading']");
    private By CONFIRM_ORDER = By.id("checkout_btn");
    private By ORDER_SUCCESS = By.cssSelector(".maintext");

    @Autowired
    FakerConfig fakerConfig;

    @Override
    public boolean isAt() {
        return false;
    }

    public void checkoutOrderWithCustomerDetails() {
        findElement(CHECKOUT_PRODUCT).click();
        findElement(GUEST_CHECKOUT).click();
        findElement(CHECKOUT_CONTINUE).click();

        findElement(FIRSTNAME).sendKeys(fakerConfig.getFaker().name().firstName());
        findElement(LASTNAME).sendKeys(fakerConfig.getFaker().name().lastName());
        findElement(EMAIL).sendKeys(fakerConfig.getFaker().name().username()+"@aon.com");
        findElement(TELEPHONE).sendKeys(fakerConfig.getFaker().phoneNumber().cellPhone());
        findElement(ADDRESS).sendKeys(fakerConfig.getFaker().address().fullAddress());
        findElement(CITY).sendKeys(fakerConfig.getFaker().address().city());

        Select sCountry = new Select(findElement(COUNTRY));
        sCountry.selectByVisibleText("Singapore");
        findElement(POSTALCODE).sendKeys("460075");

        Select sState = new Select(findElement(STATE));
        sState.selectByVisibleText("Singapore");

        findElement(CONTINUE).click();

    }

    public String fetchProductNameInCheckout() {
        return findElement(PRODUCT_NAME).getText();
    }

    public String fetchProductPriceInCheckout() {
        return findElement(PRODUCT_PRICE).getText();
    }

    public boolean isOrderIsSuccessful() {
        findElement(CONFIRM_ORDER).click();
        return findElement(ORDER_SUCCESS).isDisplayed();
    }
}
