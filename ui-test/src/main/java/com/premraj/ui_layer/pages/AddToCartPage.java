package com.premraj.ui_layer.pages;

import com.premraj.annotation.Page;
import com.premraj.ui_layer.base.Base;
import com.premraj.ui_layer.component.CartComponent;
import com.premraj.ui_layer.component.ProductComponent;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Page
public class AddToCartPage extends Base {

    private static final Logger logger = LoggerFactory.getLogger(AddToCartPage.class);

    private By SALE_PRODUCT = By.cssSelector("ul#main_menu_top>li>a>i");



    @Autowired
    ProductComponent productComponent;

    @Autowired
    CartComponent cartComponent;
    @Override
    public boolean isAt() {
        return this.productComponent.isAt();
    }


    public void addProductToCart() {
        productComponent.addToCart();
    }

    public String fetchProductAddedInCart(){

        return cartComponent.getProductDescription();
    }
}
