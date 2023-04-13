package com.example.CucumberDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StepDefinition {
    static WebDriver driver;
    static WebElement logo;
    static WebElement start;
    static WebElement program;
    static WebElement kanal;
    static  WebElement availability;
    @Given("SVTPlay is available")
    public void svt_play_is_available() {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        options.addArguments("–no-sandbox");

        driver = new ChromeDriver(options);
        driver.get("https://www.svtplay.se/");

        //throw new io.cucumber.java.PendingException();
    }

    @When("User visits SVTPlay")
    public void user_visits_svt_play() {
        // Write code here that turns the phrase above into concrete actions

        WebElement element =  driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/button[3]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/button[3]")));
        element.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.className("sc-4f221cd2-1")));

       // throw new io.cucumber.java.PendingException();
    }

    @Then("Title should be {string}")
    public void title_should_be(String string) {
        // Write code here that turns the phrase above into concrete actions

        String svtTitle1=  driver.getTitle();
        assertEquals("SVT Play", svtTitle1);
        driver.quit();
        //throw new io.cucumber.java.PendingException();
    }
//Test2
    @Then("logo should visible")
    public void logo_should_visible() {
        // Write code here that turns the phrase above into concrete actions

       logo = driver.findElement(By.className("sc-31022b15-0"));
        logo.isEnabled();
        logo.isDisplayed();



       // throw new io.cucumber.java.PendingException();
    }
    @Then("Text should be {string}")
    public void text_should_be(String string) {

        String svt =logo.getText();
        assertEquals( "SVT Play logotyp", svt );
        driver.quit();
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
// Test 3

    @When("User Navigate to Links")
    public void user_navigate_to_links() {
         start = driver.findElement(By.cssSelector("[type=\"start\"]"));
         //start.click();
        String start1 =start.getText();
         program = driver.findElement(By.cssSelector("[type=\"programs\"]"));
         //start.click();
        String program1 =start.getText();
         kanal = driver.findElement(By.cssSelector("[type=\"channels\"]"));
       //  kanal.click();
       // String start1 =start.getText();

        String kanal1 =start.getText();
    }
    @Then("Main many should be {string}, {string}, {string}")
    public void main_many_should_be(String string, String string2, String string3) {
        String start1 =start.getText();
       String program1 =program.getText();
       String kanal1 =kanal.getText();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        assertEquals("KANALER",kanal1);
        assertEquals("PROGRAM",program1);
        assertEquals("START", start1);
        driver.quit();
    }


    //Test 4 Tillgänglighet
/*
    @When("User Navigate to availability")
    public void user_navigate_to_availability() {
        WebElement linkText1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        linkText1.isDisplayed();

    }

 */
    @Then("Availability is visible with right text {string}")
    public void availability_is_visible_with_right_text(String string) {
        WebElement linkText1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        linkText1.isDisplayed();
        String text=  linkText1.getText();
        assertEquals("Tillgänglighet i SVT Play", text);

        driver.quit();
    }


    // Test5 Tillgänglighet länken

    @When("User Navigate to Availability")
    public void user_navigate_to_availability() {
        availability =driver.findElement(By.cssSelector("a[href='https://kontakt.svt.se/guide/tillganglighet']"));
        availability.click();
    }
    @Then("Right contents heading should be {string}")
    public void right_contents_heading_should_be(String string) {
        WebElement h1Text = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[1]/h1"));
        String heading=  h1Text.getText();
        assertEquals("Så arbetar SVT med tillgänglighet", heading);
        driver.quit();
    }


    //Test 6 Program categories

    @When("User navigate to Program")
    public void user_navigate_to_program() {

       // WebElement program =driver.findElement(By.xpath("//a[@href=\"/program\"]"));
        program = driver.findElement(By.cssSelector("[type=\"programs\"]"));
        program.click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("sc-a9073dc0-0")));
    }
    @Then("It should count amount of categories  {int}")
    public void it_should_count_amount_of_categories(Integer int1) {
        List<WebElement> programList = driver.findElements(By.className("sc-a9073dc0-0"));
        assertEquals(17, programList.size());  // Antal program list ändrar i SVT play.Det är inte fast


        driver.quit();

    }


    // TESTTTTTTT

    @Then("It should shows categories {string},{string}, {string},{string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},{string}, {string}, {string}, {string}, {string}, {string}")
        public void it_should_shows_categories(String categories0, String categories1, String categories2, String categories3, String categories4, String categories5, String categories6, String categories7, String categories8, String categories9, String categories10, String categories11, String categories12, String categories13, String categories14, String categories15, String categories16) {

        List<WebElement> programList = driver.findElements(By.cssSelector("a.sc-a9073dc0-1"));   //class : sc-a9073dc0-2   // class: sc-a9073dc0-0  //sc-a9073dc0-2

      // assertEquals(17, programList.size());  // Antal program list ändrar i SVT play.Det är inte fast
       /* css=tag:contains("inner text")
        css=tag#id
        css=tag.class
        css=tag[attribute=value]
        css=tag.class[attribute=value]

        */
        assertAll(
                () -> assertEquals("Serier msg", categories0, programList.get(0).getText()),
                () -> assertEquals("Serier msg", categories1, programList.get(1).getText()),
                () -> assertEquals("Serier msg", categories2, programList.get(2).getText()),
                () -> assertEquals("Serier msg", categories3, programList.get(3).getText()),
                () -> assertEquals("Serier msg", categories4, programList.get(4).getText()),
                () -> assertEquals("Serier msg", categories5, programList.get(5).getText()),
                () -> assertEquals("Serier msg", categories6, programList.get(6).getText()),
                () -> assertEquals("Serier msg", categories7, programList.get(7).getText()),
                () -> assertEquals("Serier msg", categories8, programList.get(8).getText()),
                () -> assertEquals("Serier msg", categories9, programList.get(9).getText()),
                () -> assertEquals("Serier msg", categories10, programList.get(10).getText()),
                () -> assertEquals("Serier msg", categories11, programList.get(11).getText()),
                () -> assertEquals("Serier msg", categories12, programList.get(12).getText()),
                () -> assertEquals("Serier msg", categories13, programList.get(13).getText()),
                () -> assertEquals("Serier msg", categories14, programList.get(14).getText()),
                () -> assertEquals("Serier msg", categories15, programList.get(15).getText()),
                () -> assertEquals("Serier msg", categories16, programList.get(16).getText())
        );

        driver.quit();
    }
}
