package com.hacine.med.tddappexample

import androidx.activity.viewModels
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import com.hacine.med.tddappexample.data.model.response.Coffee
import com.hacine.med.tddappexample.presentation.MainActivity
import com.hacine.med.tddappexample.presentation.coffeelist.CoffeeListScreen
import com.hacine.med.tddappexample.presentation.coffeelist.IceedCoffeeListVM

import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@HiltAndroidTest
class CoffeeListScreenKtTest{

    @get:Rule(order = 1)
    var hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeTestRule = createAndroidComposeRule<MainActivity>()




    @Before
     fun setup() {

        hiltTestRule.inject()
        composeTestRule.setContent {

            CoffeeListScreen(composeTestRule.activity.viewModels<IceedCoffeeListVM>().value)
        }
    }


    @Test
     fun app_displays_list_of_items() {
        val listofCoffe = listOf(
            Coffee("Espresso ","Espresso Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "1" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Mocha","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
            Coffee("Hola","Mocha Coffe2", listOf("ing1" ,"ing2"),"imgurl" , id = "2" ),
        )
        //assert all items exist within the tree
           listofCoffe.forEach { item ->
               composeTestRule.onNodeWithText(item.title.toString()).assertExists()
           }
       // composeTestRule.onNodeWithText("Espresso ").assertExists().performScrollTo().fetchSemanticsNode("mal9itch")
       // composeTestRule.onNodeWithText("Hola").assertExists()
    }
}







//    private lateinit var viewModel: IceedCoffeeListVM
//    private lateinit var fakeUseCase: FakeUseCaseImpl
//    @Before
//    fun setUp() {
////        fakeUseCase = FakeUseCaseImpl()
////
////        viewModel = IceedCoffeeListVM(fakeUseCase)
//        composeTestRule.setContent {    // setting our composable as content for test
//            CoffeeGuideTheme {
//               //CoffeeListScreen(viewModel)
//            }
//        }
//    }
