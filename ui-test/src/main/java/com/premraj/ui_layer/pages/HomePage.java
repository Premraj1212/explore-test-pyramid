package com.premraj.ui_layer.pages;

import com.premraj.annotation.Page;
import com.premraj.ui_layer.base.Base;
import com.premraj.ui_layer.component.SearchComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Page
public class HomePage extends Base {

    private static final Logger logger = LoggerFactory.getLogger(HomePage.class);

    @Autowired
    SearchComponent searchComponent;

    @Value("${shopme.application.url}")
    private String url;

    public void goTo(){
        this.driver.get(url);
        logger.info("User launched application successfully");
    }

    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void filterProduct(List<String> products) {
        products.forEach(
                product -> {
                    searchComponent.SearchProduct(product);
                }
        );
    }

    public List<String> getFilteredProductList(){
        return searchComponent.searchResults();
    }

    public Boolean verifySearchResult(List<String> similarProducts) {
        List<String> actualList = getFilteredProductList();
        String expectedProduct = similarProducts.iterator().next().toUpperCase();
        logger.info("Actual Result added in APP "+actualList);
        logger.info("Expected Result passed to APP "+expectedProduct);

        return actualList
                .stream()
                .allMatch(item -> item.contains(expectedProduct));

    }
}
