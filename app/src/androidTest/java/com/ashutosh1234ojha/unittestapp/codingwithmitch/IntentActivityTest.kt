package com.ashutosh1234ojha.unittestapp.codingwithmitch

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.app.Instrumentation
import android.content.ContentResolver
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.ashutosh1234ojha.unittestapp.R
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Ashutosh Ojha on 30,December,2021
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class IntentActivityTest {
    @get:Rule
    val intentsTestRule = IntentsTestRule(IntenttActivity::class.java)


    @Test
    fun test_validateIntentSentToPickPackage() {

        // GIVEN
        val expectedIntent: Matcher<Intent> = allOf(
            hasAction(Intent.ACTION_PICK),
            hasData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        )
        val activityResult = createGalleryPickActivityResultStub()
        intending(expectedIntent).respondWith(activityResult)

        // Execute and Verify
        onView(withId(R.id.button_open_gallery)).perform(click())
        intended(expectedIntent)
    }

    private fun createGalleryPickActivityResultStub(): Instrumentation.ActivityResult {
        val resources: Resources = InstrumentationRegistry.getInstrumentation().context.resources
        val imageUri = Uri.parse(
            ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                    resources.getResourcePackageName(R.drawable.ic_launcher_background) + '/' +
                    resources.getResourceTypeName(R.drawable.ic_launcher_background) + '/' +
                    resources.getResourceEntryName(R.drawable.ic_launcher_background)
        )

//        val imageUri = Uri.parse(resources.getResourceName(R.drawable.abc))
        val resultIntent = Intent()
        resultIntent.data = imageUri
        return Instrumentation.ActivityResult(RESULT_OK, resultIntent)

    }
}