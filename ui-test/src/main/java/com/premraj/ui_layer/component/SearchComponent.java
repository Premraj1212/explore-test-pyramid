package com.premraj.ui_layer.component;

import com.premraj.annotation.PageFragment;
import com.premraj.ui_layer.base.Base;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.stream.Collectors;

@PageFragment
public class SearchComponent extends Base {

    @Value("${shopme.title}")
    private String pageTitle;

    private static final Logger logger = LoggerFactory.getLogger(SearchComponent.class);

    private By SEARCH_PRODUCTS = By.id("filter_keyword");
    private By TRIGGER_SEARCH = By.cssSelector(".fa.fa-search");
    private By SEARCH_RESULTS = By.xpath("//div[@class='fixed']/a");
    @Override
    public boolean isAt() {
        return this.wait.until((d) -> this.driver.getTitle().startsWith(pageTitle));
    }

    public void SearchProduct(String product){
        logger.info("Search a product :: ", product);
        this.driver.findElement(SEARCH_PRODUCTS).sendKeys(product);
        this.driver.findElement(TRIGGER_SEARCH).click();
    }

    public List<String> searchResults(){
        return
        this.driver
                .findElements(SEARCH_RESULTS)
                .stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
