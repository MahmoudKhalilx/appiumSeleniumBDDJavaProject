package Android.SauceLabs.resources.utilities.utilities;

import Android.SauceLabs.androidSetUp.BaseScreenAndroid;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AndroidGestures extends BaseScreenAndroid {
	public AndroidGestures(AndroidDriver driver) {
		super(driver);
	}

	public void scrollToText(String text) {

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

	}

	public void longPressGesture(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGuesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

	}

	public void doubleClickGesture(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile:doubleClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

	}

	public void swipeGesture(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
				"left", 100, "top", 100, "width", 200, "height", 200,
				"direction", "left",
				"percent", 0.75
		));

	}

	public void rotateToLandscape() {
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
	}

	public void dragAndDrop(WebElement sourceElement, WebElement targetElement) {
		Map<String, Object> params = new HashMap<>();
		params.put("elementId", ((RemoteWebElement) sourceElement).getId());
		params.put("endX", targetElement.getLocation().getX());
		params.put("endY", targetElement.getLocation().getY());

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", params);
	}

	public void DragAndDropX(WebElement dragElement, WebElement dropElement) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions
				.clickAndHold(dragElement)
				.moveToElement(dropElement)
				.pause(Duration.ofMillis(1000))
				.release(dropElement)
				.perform();
	}
	public void DragAndDrop2Point(WebElement dragElement,int dropX,int dropY) throws InterruptedException {
		Actions actions = new Actions(driver);
		actions
				.clickAndHold(dragElement)
				.moveToLocation(dropX,dropY)
				.pause(Duration.ofMillis(100))
				.release()
				.perform();
	}

	public void DragAndDropOnHoverElement(WebElement dragElement, WebElement dropElement) throws InterruptedException {
		TouchAction action = new TouchAction(driver);

		// Perform a long press (hover) on the drag element
		action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(dragElement)))
				.moveTo(ElementOption.element(dropElement))
				//.pause(Duration.ofMillis(100))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
				.release()
				.perform();

		// Get the name (or any attribute) of the drop element
		String elementName = dropElement.getAttribute("name"); // replace 'name' with the desired attribute

		// Assert that the hover was performed on the correct element
		assert elementName.equals("Expected Name") : "Hovered on wrong element: " + elementName;
	}

//
}
