package uz.alphadroid.cn.screens.bottom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(val route:String , val  title:String , val  icon :ImageVector){
    object  Yurak: BottomBarScreen(
        route = "Yurak",
        title = "Yurak",
        icon = Icons.Default.Home
    )

    object  Score: BottomBarScreen(
        route = "Score",
        title = "Score",
        icon = Icons.Default.Person
    )

    object  Score2: BottomBarScreen(
        route = "Score2",
        title = "Score2",
        icon = Icons.Default.Settings
    )

    object  Framingham: BottomBarScreen(
        route = "Framingham",
        title = "Framingham",
        icon = Icons.Default.Settings
    )

    object  Settings: BottomBarScreen(
        route = "settings",
        title = "settings",
        icon = Icons.Default.Settings
    )


}
