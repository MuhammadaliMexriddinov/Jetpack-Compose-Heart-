package uz.alphadroid.cn.screens.bottom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import uz.alphadroid.cn.screens.FraminghamTestScreen
import uz.alphadroid.cn.screens.ScoreTest2Screen
import uz.alphadroid.cn.screens.ScoreTestScreen
import uz.alphadroid.cn.screens.YurakTestScreen
import uz.alphadroid.cn.screens.pages.*


@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Yurak.route) {
        composable(route = BottomBarScreen.Yurak.route) {
            YurakScreen {
                navController.navigate("yurak_test")
            }
        }
        composable(route = "yurak_test") {
            YurakTestScreen() {
                navController.popBackStack()
            }
        }

        composable(route = BottomBarScreen.Score.route) {
            ScoreScreen {
                navController.navigate("score_test")
            }
        }

        composable(route = "score_test") {
            ScoreTestScreen() {
                navController.popBackStack()
            }
        }
        composable(route = BottomBarScreen.Score2.route) {
            Score2Screen {
                navController.navigate("score2_test")
            }
        }

        composable(route = "score2_test") {
            ScoreTest2Screen() {
                navController.popBackStack()
            }
        }


        composable(route = BottomBarScreen.Framingham.route) {
            FraminghamScreen {
                navController.navigate("framingham_test")
            }
        }

        composable(route = "framingham_test") {
            FraminghamTestScreen() {
                navController.popBackStack()
            }
        }


        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }

    }
}