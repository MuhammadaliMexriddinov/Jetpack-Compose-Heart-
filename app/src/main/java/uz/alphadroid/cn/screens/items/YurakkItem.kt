package uz.alphadroid.cn.screens.items

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun YurakkItem(textTest: String, onClick: (String) -> Unit) {
    var value by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    var text1 = remember { mutableStateOf("Variant tanlanmagan !") }
    var dropVisibily by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color.Transparent,
//                    style = shadowShape
                )
            },
        elevation = 4.dp,
        shape = RoundedCornerShape(4.dp),
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column {
                Text(text = "lwhrfiuwheoiruhwiehurvoiuhr ?")
                Spacer(modifier = Modifier.height(12.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .weight(200.0f)
                            .border(border = BorderStroke(width = 1.dp, Color.LightGray)), contentAlignment = Alignment.Center
                    ) {
                            Text(text =text1.value, textAlign = TextAlign.Start )
                            IconButton(onClick = {
                            dropVisibily = !dropVisibily
                        } ,  modifier = Modifier.align(alignment = Alignment.CenterEnd)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowDown,
                                contentDescription = ""
                            )
                            DropdownMenu(
                                expanded = dropVisibily,
                                onDismissRequest = { dropVisibily = false }
                            ) {
                                DropdownMenuItem(
                                    content = { Text("Load") },
                                    onClick = {
                                        Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "Load"
                                        onClick("load")
                                    }
                                )
                                DropdownMenuItem(
                                    content = { Text("Jetpack Compose") },
                                    onClick = {
                                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "Jetpack Compose"
                                    }
                                )
                                DropdownMenuItem(
                                    content = { Text("Load") },
                                    onClick = {
                                        Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "Load"
                                    }

                                )
                                DropdownMenuItem(
                                    content = { Text("Save") },
                                    onClick = {
                                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "Save"
                                    }
                                )
                                DropdownMenuItem(
                                    content = { Text("RadioButton - Jetpack Compose Playground") },
                                    onClick = {
                                        Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "RadioButton - Jetpack Compose Playground"
                                    }
                                )
                                DropdownMenuItem(
                                    content = { Text("RadioButton") },
                                    onClick = {
                                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "RadioButton"
                                    }
                                )
                                DropdownMenuItem(
                                    content = { Text("Compose Playground") },
                                    onClick = {
                                        Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                                        dropVisibily = false
                                        text1.value = "Compose Playground"
                                    }
                                )
                            }
                        }
                    }

                }
            }
        }
//        if (dropVisibily) {
//            Demo_DropDownMenu(onClick)
//        }
    }
}