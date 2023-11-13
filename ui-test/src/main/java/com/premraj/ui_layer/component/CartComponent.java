package com.premraj.ui_layer.component;

import com.premraj.annotation.PageFragment;
import com.premraj.ui_layer.base.Base;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@PageFragment
public class CartComponent extends Base {
    private static final Logger logger = LoggerFactory.getLogger(CartComponent.class);

    private By GO_TO_CART = By.cssSelector("li[class='dropdown'] i[class='fa fa-shopping-cart']");
    private By PRODUCT_DESCRIPTION_CART = By.cssSelector("td[class='align_left'] a");


    @Value("${shopme.cart.title}")
    private String pageTitle;

    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.driver.getTitle().startsWith(pageTitle));
    }

    public void goToCart(){
        findElement(GO_TO_CART).click();
    }

    public String getProductDescription(){
        String prodDescription = findElement(PRODUCT_DESCRIPTION_CART).getText();
        logger.info("Product Name in CART ===>"+prodDescription);
        return prodDescription;
    }
}
