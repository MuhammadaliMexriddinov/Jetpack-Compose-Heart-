package uz.alphadroid.cn.screens.pages

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import uz.alphadroid.cn.R

@Composable
fun FraminghamScreen(onClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val image: Painter = painterResource(id = R.drawable.icon)
        Image(
            painter = image,
            contentDescription = "icon",
            modifier = Modifier.padding(top = 28.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .border(
                    width = 2.dp,
                    color = Color.Blue,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Text(
                text = stringResource(id = R.string.shart),
                modifier = Modifier.padding(12.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Justify
            )
        }
        Spacer(modifier = Modifier.height(136.dp))
        Button(onClick = {
            onClick()
        }) {
            Text(text = stringResource(id = R.string.start))
        }
    }
}