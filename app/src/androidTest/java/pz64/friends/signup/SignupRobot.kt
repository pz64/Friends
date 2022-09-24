package pz64.friends.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import pz64.friends.MainActivity
import pz64.friends.R

fun launchSignupScreen(
    rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: SignupRobot.() -> Unit
): SignupRobot {

    return SignupRobot(rule).apply(block)
}

class SignupRobot(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun typeEmail(email: String) {
        val emailHint = rule.activity.getString(R.string.email)
        rule.onNodeWithText(emailHint).performTextInput(email)
    }

    fun typePassword(password: String) {
        val passwordHint = rule.activity.getString(R.string.password)
        rule.onNodeWithText(passwordHint).performTextInput(password)
    }

    fun submit() {
        val signupButton = rule.activity.getString(R.string.signupButton)
        rule.onNodeWithText(signupButton)
    }

    infix fun verify(

        block: SignupVerification.() -> Unit
    ): SignupVerification {
        return SignupVerification(rule).apply(block)
    }

}

class SignupVerification(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun timelineScreenIsPresent() {
        val timeline = rule.activity.getString(R.string.timeline)
        rule.onNodeWithText(timeline).assertIsDisplayed()
    }

}