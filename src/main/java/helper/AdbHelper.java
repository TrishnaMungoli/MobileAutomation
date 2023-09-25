package helper;

import java.io.IOException;

public class AdbHelper {
	final static String FACEBOOK_APP_PACKAGE_NAME = "com.facebook.katana";
	public static void clearAppData(String appPackageName) {
		try {
			Process process = Runtime.getRuntime().exec("adb shell pm clear " + appPackageName);
			int exitCode = process.waitFor();
			assert exitCode == 0;
		} catch (IOException | InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void clearFacebookAppData() {
		clearAppData(FACEBOOK_APP_PACKAGE_NAME);
	}
}

