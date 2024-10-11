package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import com.phonebook.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void login(String email, String password) {
        // click on login link
        click(By.xpath("//a[.='LOGIN']"));
        // enter email
        type(By.name("email"), email.toLowerCase());
        // enter password
        type(By.name("password"), password);
        // click on Login button
        click(By.name("login"));
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    /**
     * Метод для <code>регистрации нового пользователя<code/> на сайте.
     *
     * @param email    Электронная почта, используемая для регистрации.
     * @param password Пароль, который будет установлен для аккаунта.
     *                 <p>
     *                 В процессе регистрации выполняются следующие шаги:
     *                 1. Клик по ссылке "LOGIN".
     *                 2. Ввод электронной почты в поле для email.
     *                 3. Ввод пароля в соответствующее поле.
     *                 4. Нажатие на кнопку регистрации.
     *                 5. Проверка того, что кнопка "Sign Out" отображается после успешной регистрации.
     *                 <p>
     *                 Исключение: Если элемент "Sign Out" не найден, то утверждение выбросит исключение.
     */
    public void register(String email, String password) {
        // click on Login link //a[.='LOGIN']
        click(By.xpath("//a[.='LOGIN']"));
        // enter email in input By.name("email")
        type(By.name("email"), email);
        // enter password in input By.name("password")
        type(By.name("password"), password);
        // click on registration button By.name("registration")
        click(By.name("registration"));
        // Assert that button //button[.='Sign Out'] is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    public void logout() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public void fillInRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickRegistrationButton() {
        click(By.name("registration"));
    }

    public void clickLoginLink() {
        click(By.xpath("//a[.='LOGIN']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isError409Present() {
        return isElementPresent(By.xpath("//div[.='Registration failed with code 409']"));
    }
}
