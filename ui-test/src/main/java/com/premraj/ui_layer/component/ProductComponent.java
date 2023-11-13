package com.premraj.ui_layer.component;

import com.premraj.annotation.PageFragment;
import com.premraj.helper.RunHelper;
import com.premraj.ui_layer.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@PageFragment
public class ProductComponent extends Base {
    private static final Logger logger = LoggerFactory.getLogger(ProductComponent.class);

    private By PRODUCT_DETAIL = By.cssSelector(".bgnone");
    private By ADD_CART = By.cssSelector(".cart");
    private By PRODUCT_PRICE = By.cssSelector(".productfilneprice");

    @Value("${shopme.sale.title}")
    private String pageTitle;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.driver.getTitle().startsWith(pageTitle));
    }

    public void addToCart() {
        String productName = findElement(PRODUCT_DETAIL).getText();
        String productPrice = findElement(PRODUCT_PRICE).getText();
        RunHelper.addRunData("productName",productName);
        RunHelper.addRunData("productPrice",productPrice);
        findElement(ADD_CART).click();

    }
}
