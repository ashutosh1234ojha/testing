package com.ashutosh1234ojha.unittestapp.data.local

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.ashutosh1234ojha.unittestapp.getOrAwaitValue
import com.ashutosh1234ojha.unittestapp.launchFragmentInHiltContainer
import com.ashutosh1234ojha.unittestapp.ui.ShoppingFragment
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Ashutosh Ojha on 24,October,2021
 */
@ExperimentalCoroutinesApi
@HiltAndroidTest
@SmallTest//its optional. It define testing pyramid position where our this test class lays
class ShoppingDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    @Named("test_db")
    lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before//we  create  new  database for every testcase, so that data  of one testcase do not impact  other
    fun setUp() {

        hiltRule.inject()
        Log.d("TestingTest",database.toString())

        dao = database.shoppingDao()
        Log.d("TestingTest",dao.toString())

    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertShoppingItem() {
        runBlockingTest {//here we don't want cocurrency that  is why we  used  runBlocking
            val shoppingItem = ShoppingItem("name", 1, 1f, "url", id = 1)
            dao.insertShoppingItem(shoppingItem)//since our this method is suspend, hence we used coroutine for  this
            val allShoppingItems = dao.observeAllShoppingItems().getOrAwaitValue()
            assertThat(allShoppingItems).contains(shoppingItem)
        }
        Log.d("TestingTest",database.toString())

    }
    @Test
    fun testLaunchFragmentInHiltContainer() {
        launchFragmentInHiltContainer<ShoppingFragment> {

        }
    }
    @Test
    fun deleteShoppingItem() {
        runBlockingTest {//runBlockingTest is optimized for writing test  cases
            val shoppingItem = ShoppingItem("name", 1, 1f, "url", id = 1)
            dao.insertShoppingItem(shoppingItem)
            dao.deleteShoppingItem(shoppingItem)
            val allShoppingItems = dao.observeAllShoppingItems()
                .getOrAwaitValue()//This is extension function of liveData.
            // This method  help  is getting livedata as normal data because we cannot observe it here
            assertThat(allShoppingItems).doesNotContain(shoppingItem)
        }
    }

    @Test
    fun observeTotalPriceSum(): Unit = runBlockingTest {
        val shoppingItem1 = ShoppingItem("name", 2, 10f, "url", id = 1)
        val shoppingItem2 = ShoppingItem("name", 4, 5.5f, "url", id = 2)
        val shoppingItem3 = ShoppingItem("name", 0, 100f, "url", id = 3)
        dao.insertShoppingItem(shoppingItem1)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)

        val totalPriceSum = dao.observeTotalPrice().getOrAwaitValue()

        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)
    }
}