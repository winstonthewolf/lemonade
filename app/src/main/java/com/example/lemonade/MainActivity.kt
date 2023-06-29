package com.example.lemonade

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeSqueeze()
                }
            }
        }
    }
}

@Composable
fun LemonadeSqueeze(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {


    var result by remember {(mutableStateOf(0))}
    val imageResource = when (result) {
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart

        else -> R.drawable.lemon_tree
    }
    val stringRes = when (result){
        1 -> R.string.tap_lemon
        2 -> R.string.tap_lemonade
        3 -> R.string.tap_empty_glass
        else -> R.string.tap_lemon_tree
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
//        Spacer(modifier = Modifier.height(75.dp))
        Button(
            onClick = {
                result++
                if(result >=4 ){
                    result =0
                }
                      }, modifier = Modifier.size(width = 200.dp, height = 200.dp)



        ) {

            Image(
                painter = painterResource(imageResource),
                contentDescription = result.toString()
//                modifier = Modifier.aspectRatio(16f / 9f),
            )
            

        }
        Text(
            text = stringResource(stringRes)
        )

        
    }
}

@Preview(showBackground = true)
@Composable
fun Lemonade() {
    LemonadeTheme {
        LemonadeSqueeze()
    }

}