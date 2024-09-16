package introduction;


	import java.time.Duration;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;
	

	public class letsShop {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://rahulshettyacademy.com/client");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(By.id("userEmail")).sendKeys("pbhattacharya023@gmail.com");
			driver.findElement(By.id("userPassword")).sendKeys("Payel@1999");
			driver.findElement(By.cssSelector("#login")).click();
			
			
			List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
			String ProductName="ADIDAS ORIGINAL";
			WebElement prod= products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
			prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
			driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
			List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
			Boolean match= cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(ProductName));
			
			driver.findElement(By.cssSelector(".totalRow button")).click();
			Actions a= new Actions(driver);
			a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			driver.findElement(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]")).click();
			driver.findElement(By.cssSelector(".action__submit ")).click();
			
			
		}

	}


