package com.akexorcist.photopickerchallenge

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.text.KButton
import org.junit.Rule
import org.junit.Test

class MainActivityTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun shouldDisplayAndClearImageCorrectly() {
        MainScreen {
            // Verify initial UI state
            textViewPlaceholder.isDisplayed()
            buttonClearImage.isDisabled()

            // Select an image from Photo Picker or legacy image chooser
            buttonSelectImage.click()
            // TODO Select an image from Photo Picker or legacy image chooser

            // Verify UI state when any image selected
            textViewPlaceholder.isNotDisplayed()
            buttonClearImage.isEnabled()
            buttonClearImage.isClickable()

            // Clear image
            buttonClearImage.click()

            // Verify UI state when image cleared
            textViewPlaceholder.isDisplayed()
            buttonClearImage.isDisabled()
        }
    }
}

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val textViewPlaceholder = KButton { withId(R.id.textViewPlaceholder) }
    val buttonSelectImage = KButton { withId(R.id.buttonSelectImage) }
    val buttonClearImage = KButton { withId(R.id.buttonClearImage) }
}
