package MbStepDefinition;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import MbDriverSetup.MbSetup;
import MbPages.MbPages;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Mb_Advice {
	

	
		static WebDriver driver;
		MbPages mp;
		WebDriverWait wait;
		
/*---------------------------Testing the Functionality of show trend button------------------------------ */
	/*
	 * Created By : Piyusha Thakare
	 * Reviewed By :
	 * Motive : It is the step to verify search bar for showing trends on the page
	 * 
	 */
		
		@Given("User is on Rates and Trends webpage")
		public void user_is_on_rates_and_trends_webpage() {
		   driver=MbSetup.chromedriver();
		   mp=new MbPages(driver);
		   
		   mp.HoverOnMbAdvice();
		   
		   mp.NavigateRatesAndTrends();
		   
		   mp.SwitchToRatesTrends();
		 
		}

		
		@When("User enter input")
		public void user_enter_input(DataTable dataTable){
			List<List<String>> cells = dataTable.cells();
			
			mp.SearchInput(cells.get(0).get(0));
		}

		
		@And("User select option from dropdown")
		public void user_opens_city_filter_drop_down_list(){
			
			mp.SelectDropdown();
		}

		@And("Click on show trends button")
		public void click_on_show_trends_button(){
		
			mp.SearchClick();
			
		}
		@Then("It should display the trends for entered location")
		public void it_should_display_the_trends_for_entered_location() {
		   
		   String location=mp.LocalityTrend();
		   Assert.assertEquals(location, "Thane");
		}
	
/*-------------------------------------Scenario 2---------------------------------------------*/
		/*
		 * Created By : Piyusha Thakare
		 * Reviewed By :
		 * Motive : It is the step to verify search bar is giving error messagre after entering wrong text
		 * 
		 */
		
		@Given("User is on Rates and Trends page")
		public void user_is_on_rates_and_trends_page() throws InterruptedException {
			 driver=MbSetup.chromedriver();
			   mp=new MbPages(driver);
			  
			   mp.HoverOnMbAdvice();
			   
			   mp.NavigateRatesAndTrends();
			 
			   mp.SwitchToRatesTrends();
		}
		
		@When("User enter invalid input")
		public void user_enter_invalid_input(DataTable dataTable1) {
			List<List<String>> cells = dataTable1.cells();
			mp.SearchInvalidInput(cells.get(0).get(0));
			
		}
		@And("Click on show the trends button")
		public void click_on_show_the_trends_button() {
			mp.SearchClick();
		}


		@Then("It should give error message")
		public void it_should_give_error_message() {

			String msg=mp.ErrorMessage();
		     Assert.assertEquals(msg, "Please enter a Valid Location");
		}

/*-------------------------------------Scenario3----------------------------------------------*/
		/*
		 * Created By : Piyusha Thakare
		 * Reviewed By :
		 * Motive : It is the step for comparing localities 
		 * 
		 */
		
		@Given("User is on compare localities page")
		public void user_is_on_compare_localities_page() throws InterruptedException {
			driver=MbSetup.chromedriver();
			mp=new MbPages(driver);
			
			mp.HoverOnMbAdvice();
			
			mp.ClickCompare();
			
			mp.SwitchToRatesTrends();
		}

		@When("User click on compare option")
		public void user_click_on_compare_option() throws InterruptedException {
			
			mp.ClickCompare1();
		}

		@And("User clicks on radio button")
		public void user_clicks_on_radio_button() throws InterruptedException {
		    
			mp.ClickProjectRadio();
		}

		@And("User enters {string} and {string}")
		public void user_enters_and(String string, String string2) throws InterruptedException {
		  
		  mp.Projects(string, string2);
		   
		}

		@And("Clicks on compare button")
		public void clicks_on_compare_button() throws InterruptedException {
			
			mp.ClickComparebutton();
			mp.SwitchToRatesTrends();
			
		   
		}

		@Then("User gets redirected to Compare page")
		public void user_gets_redirected_to_compare_page() {
			
			Assert.assertTrue(mp.Comparision());
		}
		
/*---------------------------------NewProject------------------------------------------*/
		/*
		 * Created By : Piyusha Thakare
		 * Reviewed By :
		 * Motive : It is the step for applying filter for getting new projects in given location
		 * 
		 */
		
		@Given("User is on new projects page")
		public void user_is_on_new_projects_page() throws InterruptedException {
			driver=MbSetup.chromedriver();
			mp=new MbPages(driver);
			
			mp.HoverOnMbAdvice();
			
			mp.ClickNewProject();
			
			mp.SwitchToRatesTrends();
			
		}

		@When("User scrolls down the page")
		public void user_scrolls_up_the_page() {
		   
			mp.ScrollDown();
		}

		@And("Clicks on the filters option available")
		public void clicks_on_the_filters_option_available(){
		    
			mp.ClickFilter();
			
		}

		@And("Select city from dropdown list")
		public void select_city_from_dropdown_list()  {
		   
			
		   mp.ClickLocPin();
		 
		   mp.ClickCity();
		   
		}

		@And("Select hotspot")
		public void select_hotspot() throws InterruptedException {
		   mp.ClickHotspot();
		}

		@And("Select budget using scrollbar")
		public void select_budget_using_scrollbar(){
		  mp.ClickMinValue();
		  
		  mp.MinValue();
		 
		  mp.ClickMaxValue();
		 
		  mp.MaxValue();
		}

		@And("Select BHK option")
		public void select_bhk_option()  {
			
			mp.SelectBhk();
			
		}

		@And("Select possesion year")
		public void select_possesion_year()  {
		    mp.ScrollDown1();
		   
		    mp.ClickPossesion();
		}
		
		
		@And("Click on View Project")
		public void click_on_view_project() {
		 
			mp.ViewProject();
		}


		@Then("Projects are displayed with selected filter")
		public void projects_are_displayed_with_selected_filter() {
			 String expectedURL = "https://www.magicbricks.com/new-projects-Mumbai";
			 String actualURL = driver.getCurrentUrl();
			 Assert.assertEquals(actualURL, expectedURL, "URLs do not match");
		}
		
		
/*--------------------------------------Scenario-5---------------------------------------------*/
		
		/*
		 * Created By : Piyusha Thakare
		 * Reviewed By :
		 * Motive : It is the Step for verifying defect in find pincode page
		 * 
		 */
		
		@Given("User is on find pincode page")
		public void user_is_on_find_pincode_page() {
			driver=MbSetup.chromedriver();
			mp=new MbPages(driver);
			
			mp.HoverOnMbAdvice();
			
			mp.ClickFindPincode();
			
			mp.SwitchToRatesTrends();
		}

		@When("User Scroll down page")
		public void user_scroll_down_page() {
		    
			mp.ScrollDown2();
		}

		@And("User Select state from dropdown")
		public void user_select_state_from_dropdown(){
		   
			mp.SelectStateDropdown();
		}

		@And("Select City from dropdown")
		public void select_city_from_dropdown(){
			
			mp.SelectCityDropdown();
		}

		@And("User does not select locality dropdown")
		public void user_does_not_select_locality_dropdown() {
		    
		}

		@And("Click on search button")
		public void click_on_search_button() {
			
			mp.SearchButton();
		}

		@Then("It should display an error message")
		public void it_should_display_an_error_message() {
		   
		    try {
		        String expectedMessage = "Please select locality";
		        String actualMessage = mp.Errortext();
		        Assert.assertEquals(actualMessage, expectedMessage);
		    } catch (AssertionError e) {
		        
		        System.out.println("Assertion failed: " + e.getMessage());
		        
		        throw e;
		    }
		    
		}
		
		
/*----------------------------Method for taking Screenshot-------------------------------*/
		
		@AfterStep
		public static void takeScreendown(Scenario scenerio) {
			   TakesScreenshot ts= (TakesScreenshot) driver;
			   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			   scenerio.attach(src, "image/png",scenerio.getName());

		}



	}


