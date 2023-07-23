package uz.alphadroid.cn.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.alphadroid.cn.viewmodel.impl.YurakViewModelImpl

@SuppressLint("FlowOperatorInvokedInComposition", "CoroutineCreationDuringComposition")
@Composable
fun ScoreTest2Screen(mainViewModel: YurakViewModelImpl = viewModel(), onClick: () -> Unit) {
    var result = remember { mutableStateOf("qiymat berilmadi !") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 18.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = {
                onClick()
            } , modifier = Modifier.align(Alignment.CenterStart))
            {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
            }

            Text(text = "Score 2 test" , modifier = Modifier.align(Alignment.Center))
        }

        val openDialog = remember { mutableStateOf(false) }
        Button(onClick = {
            mainViewModel.sendData(
                "23",
                "0",
                "1",
                "110",
                "180",
                "0",
                "2",
                "200",
                "1",
                "3",
                "3",
                "2",
                "1"
            )
            openDialog.value = true
        }) {
            Text(text = "Natija")
        }
        if (openDialog.value) {

            mainViewModel.succesSharedFlow.onEach {
                if (it == "0") {
                    result.value = "0"
                } else if (it == "1") {
                    result.value = "1"
                }
            }.launchIn(mainViewModel.viewModelScope)

            AlertDialog(
                onDismissRequest = {
                    openDialog.value = false
                },
                title = {
                    Text(text = result.value)
                },
                confirmButton = {

                },
                dismissButton = {
                    Button(

                        onClick = {
                            openDialog.value = false
                        }) {
                        Text("Dismiss Button")
                    }
                }
            )
        }


    }
}