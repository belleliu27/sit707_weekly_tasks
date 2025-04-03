package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 */
public class LoginFormTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223924007";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "ZHAOJUN LIU";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testEmptyUsernameAndEmptyPassword() {
        LoginStatus status = LoginForm.login("", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("wrongUser", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameEmptyPassword() {
        LoginStatus status = LoginForm.login("ahsan", "");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Password", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameWrongPassword() {
        LoginStatus status = LoginForm.login("ahsan", "wrongPass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testEmptyUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Empty Username", status.getErrorMsg());
    }

    @Test
    public void testWrongUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("wrongUser", "ahsan_pass");
        Assert.assertFalse(status.isLoginSuccess());
        Assert.assertEquals("Credential mismatch", status.getErrorMsg());
    }

    @Test
    public void testCorrectUsernameCorrectPassword() {
        LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
        Assert.assertTrue(status.isLoginSuccess());
        Assert.assertEquals("123456", status.getErrorMsg()); // Validation code returned
    }

    @Test
    public void testValidateCodeEmpty() {
        Assert.assertFalse(LoginForm.validateCode(""));
    }

    @Test
    public void testValidateCodeWrong() {
        Assert.assertFalse(LoginForm.validateCode("wrongCode"));
    }

    @Test
    public void testValidateCodeCorrect() {
        Assert.assertTrue(LoginForm.validateCode("123456"));
    }
}

