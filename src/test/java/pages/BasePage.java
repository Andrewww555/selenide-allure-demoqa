package pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    protected <T extends BasePage> T open(String path) {
        Selenide.open(path);
        return (T) this;
    }
}
