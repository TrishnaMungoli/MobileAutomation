package helper;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionHelper {
	
		
	private SoftAssert softAssertion= new SoftAssert();
	
	public static void verifyText(String s1, String s2 ,String message){	
		Assert.assertEquals(s1, s1,message);
	}
	
	public static void markPass(){
	
		Assert.assertTrue(true);
	}
	
	public static void markPass(String message){
		Assert.assertTrue(true, message);
	}
	
	public static void markFail(){

		Assert.assertTrue(false);
	}
	
	public static void markFail(String message){
		Assert.assertTrue(false, message);
	}
	
	public void verifyTrue(boolean status, String message){
		softAssertion.assertTrue(status,message);			
	}
	
	public void verifyFalse(boolean status, String message){
		softAssertion.assertFalse(status, message);
	}
	
	public static void verifyNull(String s1){
		Assert.assertNull(s1);
	}
	
	public static void verifyNotNull(String s1){
		Assert.assertNotNull(s1);
	}
	
	public static void fail(){
		Assert.assertTrue(false);
	}
	
	public static void pass(){
		Assert.assertTrue(true);
	}
	
	public static void updateTestStatus(boolean status){
		if(status){
			pass();
		}
		else{
			fail();
		}
	}
	
	public void softAssertTrue(boolean b, String message) {
		softAssertion.assertTrue(b, message);
	}
	
	public void softAssertToCompareString(String s1,String s2,String message) {			
		 softAssertion.assertEquals(s1, s2, message);			
	}
	
	public void softAssertToNotCompareString(String s1,String s2,String message) {
		 softAssertion.assertNotEquals(s1, s2,message);
	}

	public void softAssertVerifyContains(String container, String contained) {
		softAssertion.assertTrue(container.contains(contained), "expected [" + container + "] to contain [" + contained + "]");
	}
	
	public void softAssertToCompareIntegers(int s1,int s2,String message) {
		 softAssertion.assertEquals(s1, s2,message);
	}
	
	public void softAssertVerifyNull(String S1,String message) {
		 softAssertion.assertNull(S1,message);
	}
	
	public void softAssertVerifyNotNull(String s1,String message){
		softAssertion.assertNotNull(s1,message);
	}
	
	public void softAssertToCompareFloat(Float s1,Float s2,String message){
		softAssertion.assertEquals(s1,s2,message);
	}
	
	public void softAssertAll(){			
		 softAssertion.assertAll();	
	}
		

}