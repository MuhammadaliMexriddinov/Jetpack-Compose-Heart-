package uz.alphadroid.cn.screens.items

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun YurakItem(textTest: String, onClick: (String) -> Unit) {
    var value by remember {
        mutableStateOf("")
    }
    var dropVisibily  = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(text = textTest)
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(value = value, onValueChange = {
                value = it
            }, trailingIcon = {
                IconButton(onClick = {
                    dropVisibily.value=!dropVisibily.value
                }

                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }
            })
        }
        if (dropVisibily.value){
            Demo_DropDownMenu(onClick)
        }
    }
}

@Composable
fun Demo_DropDownMenu(onClick: (String) -> Unit) {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }
    var text1 = remember { mutableStateOf("!!!") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterStart)
    ) {
        Column {
            Row() {
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        Icons.Filled.KeyboardArrowDown,
                        contentDescription = "More"
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        content = { Text("Load") },
                        onClick = {
                            Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "Load"
                            onClick("load")
                        }
                    )
                    DropdownMenuItem(
                        content = { Text("Jetpack Compose") },
                        onClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "Jetpack Compose"
                        }
                    )
                    DropdownMenuItem(
                        content = { Text("Load") },
                        onClick = {
                            Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "Load"
                        }

                    )
                    DropdownMenuItem(
                        content = { Text("Save") },
                        onClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "Save"
                        }
                    )
                    DropdownMenuItem(
                        content = { Text("RadioButton - Jetpack Compose Playground") },
                        onClick = {
                            Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "RadioButton - Jetpack Compose Playground"
                        }
                    )
                    DropdownMenuItem(
                        content = { Text("RadioButton") },
                        onClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "RadioButton"
                        }
                    )
                    DropdownMenuItem(
                        content = { Text("Compose Playground") },
                        onClick = {
                            Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                            expanded = false
                            text1.value = "Compose Playground"
                        }
                    )
                }
            }
            Text(text = text1.value)

        }

    }
}


/**
 *
 * */