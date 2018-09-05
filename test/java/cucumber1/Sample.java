package cucumber1;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
public class Sample {
	static WebDriver dr;
	
	@Given("^The user is in demoqa home page$")
	public void the_user_is_in_demoqa_home_page() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\madhan\\eclipse-workspace\\pavi\\selenium\\driver\\chromedriver.exe");
	 dr = new ChromeDriver();
		dr.get("http://demoqa.com/registration/");
	   
	}

	@When("^The user enter the firstname and lastname$")
	public void the_user_enter_the_firstname_and_lastname() {
		dr.findElement(By.id("name_3_firstname")).sendKeys("pavithra");
		dr.findElement(By.id("name_3_lastname")).sendKeys("madan");
	  
	}

	@Then("^The user verifies the entered text in firstname and lastname$")
	public void the_user_verifies_the_entered_text_in_firstname_and_lastname() {
		Assert.assertEquals("pavithra", dr.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("madan", dr.findElement(By.id("name_3_lastname")).getAttribute("value"));
		
	   
	}



}
