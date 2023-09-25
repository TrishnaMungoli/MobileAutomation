package helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.NoSuchContextException;

public class ContextHelper {
	public static void switchToNative(AppiumDriver<MobileElement> driver) {
		for(int i = 0 ; i< 10 ; i++) {
			try {
				Thread.sleep(1000);
				driver.context("NATIVE_APP");
				System.out.println("Switched to NATIVE_APP context successfully");
				return;
			} catch (NoSuchContextException exception) {
				System.out.println("Waiting for NATIVE_APP context to be available");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Could not switch to NATIVE_APP context after waiting for 10 seconds");
	}

	public static void switchToChrome(AppiumDriver<MobileElement> driver){
		//TODO Find a way to delete Chrome cookies before switching to WEBVIEW_chrome
		for(int i = 0 ; i< 10 ; i++){
			try {
				Thread.sleep(1000);
				driver.context("WEBVIEW_chrome");
				System.out.println("Switched to WEBVIEW_chrome context successfully");
				return;
			} catch (NoSuchContextException exception){
				System.out.println("Waiting for WEBVIEW_chrome context to be available");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Could not switch to WEBVIEW_chrome context after waiting for 10 seconds");
	}

	public static void switchToWebview(AppiumDriver<MobileElement> driver) {
		for(int i = 0 ; i< 10 ; i++) {
			try {
				Thread.sleep(1000);
				driver.context("WEBVIEW_www.undostres.com.mx.sandbox");
				System.out.println("Switched to WEBVIEW_www.undostres.com.mx.sandbox context successfully");
				return;
			} catch (NoSuchContextException exception) {
				System.out.println("Waiting for WEBVIEW_www.undostres.com.mx.sandbox context to be available");
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		System.out.println("Could not switch to WEBVIEW_www.undostres.com.mx.sandbox context after waiting for 10 seconds");
	}
}

