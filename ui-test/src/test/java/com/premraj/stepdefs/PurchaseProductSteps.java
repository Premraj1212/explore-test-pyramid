package com.premraj.stepdefs;

import com.premraj.annotation.LazyAutowired;
import com.premraj.helper.RunHelper;
import com.premraj.ui_layer.pages.AddToCartPage;
import com.premraj.ui_layer.pages.CheckoutPage;
import com.premraj.ui_layer.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class PurchaseProductSteps {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseProductSteps.class);

    @LazyAutowired
    AddToCartPage addToCartPage;

    @LazyAutowired
    HomePage homePage;

    @LazyAutowired
    CheckoutPage checkoutPage;

    @When("^user finds a product in (.*)$")
    public void userFindsAProductInSale(String product) {
        logger.info("The Product Category "+product);
        homePage.filterProduct(List.of(product));

    }

    @And("user add a product to cart")
    public void userAddAProductToCart() {
        addToCartPage.addProductToCart();
    }

    @Then("user should see all products in the cart")
    public void userShouldSeeAllProductsInTheCart() {
        String expectedProductName = ((String) RunHelper.getRunData("productName"));
        Assert.assertEquals(addToCartPage.fetchProductAddedInCart(),expectedProductName);
    }

    @And("checkout the product")
    public void checkoutTheProduct() {
        checkoutPage.checkoutOrderWithCustomerDetails();
    }

    @Then("user should able to make order successfully")
    public void userShouldAbleToMakeOrderSuccessfully() {
        String expectedProductName = ((String) RunHelper.getRunData("productName"));
        String expectedProductPrice = ((String) RunHelper.getRunData("productPrice"));
        Assert.assertEquals(checkoutPage.fetchProductNameInCheckout(),expectedProductName);
        Assert.assertEquals(checkoutPage.fetchProductPriceInCheckout(),expectedProductPrice);
        Assert.assertTrue(checkoutPage.isOrderIsSuccessful());
    }
}
