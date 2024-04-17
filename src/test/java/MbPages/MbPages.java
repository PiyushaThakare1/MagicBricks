package MbPages;


	import java.time.Duration;
	import java.util.Set;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.CacheLookup;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

public class MbPages {
	
			WebDriver driver;
			WebDriverWait wait;
				
			
	/*-----------------------All element Locators-----------------------------*/
			
			@FindBy(xpath="//li[@class=\"js-menu-container\"][6]/a")
			@CacheLookup
			WebElement mbAdvice;
			
			@FindBy(css="a[href=\"https://www.magicbricks.com/advice/trends/Mumbai/\"]")
			WebElement clickonRT;
			
			@FindBy(css="input#keyword.cityLocProjectField")
			WebElement searchBar;
			
			@FindBy(xpath="//div[@id=\"keyword_suggest\"]/child::div[2]")
			WebElement dropdown;
			
			@FindBy(id="showTrendsId")
			WebElement showTrendButton;
			
			@FindBy(id="citylocalityTrends")
			@CacheLookup
			WebElement localityTrend;
			
			@FindBy(id="validLocation")
			WebElement errormsg;
			

			@FindBy(css="a[href=\"https://www.magicbricks.com/advice/#compareSectionWrapper\"]")
			WebElement compare; 
			
			@FindBy(xpath="//a[text()=\"Compare\"]")
			WebElement compare1;
			
			@FindBy(id="projectsRD")
			WebElement projectRadio;
			
			@FindBy(id="prjOne")
			WebElement loc1;
			
			@FindBy(id="prjTwo")
			WebElement loc2;
			
			@FindBy(xpath="//div[@id=\"project_suggestOne\"]/child::div[3]")
			WebElement dropDownLoc1;
			
			@FindBy(xpath="//div[@id=\"project_suggestTwo\"]/child::div[2]")
			WebElement dropDownLoc2;
			
			@FindBy(xpath="//div[@id=\"projects\"]/div/div[4]/input")
			WebElement compareButton;
			
			@FindBy(id="compareHeadSec1")
			WebElement firstComp;
			
			@FindBy(id="compareHeadSec2")
			WebElement secondComp;
			
			@FindBy(xpath="//a[text()=\"New Projects in Mumbai\"]")
			WebElement newProject;
			
		    @FindBy(xpath="//div[@id=\"filterwrap\"]/div/child::div[2]/div")
		    WebElement filter;
		    
		    @FindBy(xpath="//div[@class=\"search-filter__city__pin\"]")
		    WebElement locationPin;
		    
		    @FindBy(xpath="(//div[text()=\"Navi Mumbai\"])[2]")
		    WebElement citydropdown;
		    
		    @FindBy(xpath="//div[@class=\"search-filter__city\"]")
		    WebElement citySearch;
		    
		    @FindBy(id="6")
		    WebElement city;
		    
		    @FindBy(xpath="(//label[@class=\"filter__common__component__item__label locality\"])[1]")
		    WebElement hotspot;
		    
		    @FindBy(xpath="//input[@value=\"50000000\"]")
		    WebElement sliderSrc;
		    
		    @FindBy(xpath="//input[@value=\"17000000\"]")
		    WebElement sliderDes;
		    
		    @FindBy(xpath="(//select[@class=\"filter-budget__select\"])[1]")
		    WebElement value1;
		    
		    @FindBy(xpath="//label[text()=\"2 BHK\"]")
		    WebElement bhk;
		    
		    @FindBy(xpath="(//select[@class=\"filter-budget__select\"])[1]")
		    WebElement selectMinBud;
		    
		    @FindBy(xpath="(//select[@class=\"filter-budget__select\"])[2]")
		    WebElement selectMaxBud;
		    
		    @FindBy(xpath="(//label[@class=\"filter__common__component__item__label possessionIn\"])[2]")
		    WebElement possesion;
		    
		    @FindBy(xpath="//div[@class=\"search-filter__btn\"]")
		    WebElement viewProject;
		    
			
			@FindBy(css="a[href=\"https://www.magicbricks.com/pin-code/\"]")
			WebElement findpincode;
			
			@FindBy(id="stateSelVal")
			WebElement clickstate;
			
			@FindBy(xpath="//li[text()=\"Maharashtra\"]")
			WebElement stateDropdown;
			
			@FindBy(id="citySelVal")
			WebElement clickCity;
			
			@FindBy(xpath="//li[text()=\"Mumbai\"]")
			WebElement cityDropdown;
			
			@FindBy(id="pinSearch")
			WebElement search;
			
			@FindBy(id="pinCodeDetails")
			WebElement error;
		    
		    
		    
		
/*-------------------------------RatesAndTrends------------------------------------*/
			
			//Constructor for initializing page factory
			public MbPages(WebDriver driver) {
				 this.driver=driver;
				 PageFactory.initElements(driver, this);
				 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			}
			
			//Method for hovering on MB_Advice module
			public void HoverOnMbAdvice()  {
				 Actions act = new Actions(driver);
				 act.moveToElement(mbAdvice).build().perform();
				 wait.until(ExpectedConditions.visibilityOf(mbAdvice));
				 mbAdvice.click();
			}
            
			//Method for navigating user to Rates and Trends page
			public void NavigateRatesAndTrends() {
				wait.until(ExpectedConditions.elementToBeClickable(clickonRT));	
				clickonRT.click();
			}
			
			//Method for Window Handle
			public void SwitchToRatesTrends() {
				String mainWindowHandle = driver.getWindowHandle();
	 
				Set<String> allWindowHandles = driver.getWindowHandles();
	 
				for (String handle : allWindowHandles)
				{
				    if (!handle.equals(mainWindowHandle)) 
				    {
				        driver.switchTo().window(handle);
				       // break;
				    }
				}
			}
			
			//Method for giving input in search bar
			public void SearchInput(String input){			
				wait.until(ExpectedConditions.elementToBeClickable(searchBar));
				searchBar.click();
				searchBar.sendKeys(input);
			
			}
			
			//Method for giving invalid input for Invalid scenario
			public void SearchInvalidInput(String invalidInput) {
				wait.until(ExpectedConditions.elementToBeClickable(searchBar));
				searchBar.click();
				searchBar.sendKeys(invalidInput);
			}
			
			//Method for selecting location from dropdown
			public void SelectDropdown() {
				
				wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
				
			}

			//Method for Clicking "show trend" button
			public void SearchClick(){
				wait.until(ExpectedConditions.elementToBeClickable(showTrendButton));
				showTrendButton.click();
			}
			
			//Method for getting text for assertion
			public String LocalityTrend() {
				wait.until(ExpectedConditions.visibilityOf(localityTrend));
				return localityTrend.getText();
			}
			
			//Getter of localitytrend
			public WebElement getLocalityTrend() {
				return localityTrend;
			}
			
			//Setter for Locality trend
			public void setLocalityTrend(WebElement localityTrend) {
				this.localityTrend = localityTrend;
			}
			
			//Getter of Dropdown
			public WebElement getDropdown() {
				return dropdown;
			}
			
			//Setter for dropdown
			public void setDropdown(WebElement dropdown) {
				this.dropdown = dropdown;
			}
			
			//Getter of Show trend button
			public WebElement getShowTrendButton() {
				return showTrendButton;
			}
			
			//Setter for show trend button
			public void setShowTrendButton(WebElement showTrendButton) {
				this.showTrendButton = showTrendButton;
			}

			//Method for getting error Message for Invalid input
			public String ErrorMessage() {
				wait.until(ExpectedConditions.visibilityOf(errormsg));
				return errormsg.getText();
			}
			
			
			
/*---------------------------------CompareLocality------------------------------------*/
			
			
			//Method to Click on Compare Localities option in dropdown
			public void ClickCompare() {
				wait.until(ExpectedConditions.elementToBeClickable(compare)).click();
				//compare.click();
			}
			
			//Method for clicking on compare option available on page
			public void ClickCompare1() {
				wait.until(ExpectedConditions.visibilityOf(compare1)).click();
				
			}
			
			//Method for clicking on Radio Button
			public void ClickProjectRadio() throws InterruptedException {
				Thread.sleep(1000);
				//wait.until(ExpectedConditions.visibilityOf(projectRadio));
				projectRadio.click();
				
			}
			
			//Method for entering Locality1 and Locality2 in input box
			public void Projects(String project1,String project2) throws InterruptedException  {
				loc1.click();
				
				loc1.sendKeys(project1);
				Thread.sleep(1000);
				//wait.until(ExpectedConditions.elementToBeClickable(dropDownLoc1));
				dropDownLoc1.click();
				
				
				loc2.click();
				
				loc2.sendKeys(project2);
				Thread.sleep(1000);
				//wait.until(ExpectedConditions.elementToBeClickable(dropDownLoc2));
				dropDownLoc2.click();
					
			}
			
			//Method for clicking on Compare button
			public void ClickComparebutton(){
				
				wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
			}
			
			//Method for getting text for assertion
			public String CompareProject() {
				return localityTrend.getText();
			}
			
			//Method for getting text of project1
			public String CompareProjectText() {
				return firstComp.getText();
			}
			
			//Method for getting text of project2
			public String CompareProjectText1() {
				return secondComp.getText();
			}
			
			//Method for comparing the both project text 
			public boolean Comparision() {
				if (CompareProjectText().contains("Oberoi") && CompareProjectText1().contains("Blu")) {
	                return true;
	            }
				else {
	                return false;
	            }
			}
			
			
	/*-------------------------------------New Project in Locality--------------------------------------------*/
			
			
			//Method fo clicking on new project option
			public void ClickNewProject() {
				
				wait.until(ExpectedConditions.elementToBeClickable(newProject)).click();
			}
			
			//Method for Scrooling down the page
			public void ScrollDown() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)"); 
			}
			
			//Method for clicking on filter option
			public void ClickFilter() {
				
				wait.until(ExpectedConditions.elementToBeClickable(filter)).click();
			}
			
			//Method for clicking on city dropdown
			public void ClickLocPin() {
				
				wait.until(ExpectedConditions.elementToBeClickable(locationPin)).click();
			}
			
			//Method for selecting city from list
			public void ClickCity() {
				
				wait.until(ExpectedConditions.elementToBeClickable(city)).click();
			}
			
			//Method for clicking on hotspot of city
			public void ClickHotspot() throws InterruptedException {
				Thread.sleep(1000);
				hotspot.click();
				//wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				//wait.until(ExpectedConditions.elementToBeClickable(hotspot)).click();
			}
			
			//Method for clicking minimum value dropdown
			public void ClickMinValue() {
				selectMinBud.click();
				//wait.until(ExpectedConditions.visibilityOf(selectMinBud)).click();
			}
			
			//Method for selecting minimum value from dropdown 
			public void MinValue() {
				Select select = new Select(selectMinBud);	
		    	 select.selectByVisibleText("₹ 5 Lac");
			}
			
			//Method for clicking on maximum dropdown
			public void ClickMaxValue() {
				selectMaxBud.click();
				//wait.until(ExpectedConditions.elementToBeClickable(selectMaxBud)).click();
			}
			
			//Method for selecting maximum value from dropdown
			public void MaxValue() {
				Select select = new Select(selectMaxBud);	
		    	 select.selectByVisibleText("₹ 1 Cr");
			}
			
			//Method for selecting bhk option
			public void SelectBhk() {
				
				wait.until(ExpectedConditions.elementToBeClickable(bhk)).click();
			}
			
			//Method for scrolling child filter page
			public void ScrollDown1() {
				
				Actions actions = new Actions(driver);
		        actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
				
			}
			
			//Method for clicking on possesion option
			public void ClickPossesion() {
				//possesion.click();
		        wait.until(ExpectedConditions.elementToBeClickable(possesion)).click();
			}
			
			//Click on view project project
			public void ViewProject() {
				//viewProject.click();
		        wait.until(ExpectedConditions.elementToBeClickable(viewProject)).click();
			}
			
	  /*------------------------------------FindPincodeDefect-----------------------------------*/
		
			//Method for clicking on findpincode option in dropdown
			public void ClickFindPincode() {
				
				 wait.until(ExpectedConditions.elementToBeClickable(findpincode));
				 findpincode.click();
			}
			
			//Method for Scrolling Findpincode page
			public void ScrollDown2() {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,300)"); 
			}
			
			//Method for Clicking and Selecting state from dropdown
			public void SelectStateDropdown() {

				 wait.until(ExpectedConditions.elementToBeClickable(clickstate)).click();
			     wait.until(ExpectedConditions.elementToBeClickable(stateDropdown)).click();
			}
			
			//Method for Clicking and Selecting city from dropdown
			public void SelectCityDropdown() {

				 wait.until(ExpectedConditions.elementToBeClickable(clickCity));
				 clickCity.click();
			     wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));
			     cityDropdown.click();
			}
			
			//Method for Clicking on search button
			public void SearchButton() {
				
				 wait.until(ExpectedConditions.elementToBeClickable(search));
				 search.click();
			}
			
			//Method for getting text 
			public String Errortext() {
				return error.getText();
			}
			
}
