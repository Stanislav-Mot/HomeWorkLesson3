package pages;

import eu.senla.Products;

import static com.codeborne.selenide.Selenide.$x;

public class InventoryPage extends AbstractPage {

    public static String URL = "https://www.saucedemo.com/inventory.html";

    private String addButton = "//button[@data-test = 'add-to-cart-%s']";

    public InventoryPage clickAddingButton(Products products) {
        $x(String.format(addButton, products.getName())).click();
        return this;
    }

}

