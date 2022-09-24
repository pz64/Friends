package pz64.friends.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test
import pz64.friends.MainActivity

class SignupTest {

    @get:Rule
    val signupTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun performSignup() {
        launchSignupScreen(signupTestRule) {
            typeEmail("test@user.com")
            typePassword("Password")
            submit()
        } verify {
            timelineScreenIsPresent()
        }
    }
}