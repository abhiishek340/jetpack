package com.example.codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.codelab.ui.theme.CodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodelabTheme{
                MyApp()

            }
        }
    }
}
@Composable
fun MyApp(names: List<String> = listOf("World" , "Compose")) {
    Surface(color = MaterialTheme.colorScheme.background){
        Column (modifier = Modifier.padding(vertical = 4.dp)){
            for(name in names) {
                Greeting(name)
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    var expanded = false
    Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp) ){
        Row (modifier = Modifier.padding(24.dp)){
            Column (modifier = Modifier.weight(1f)){
                Text(text = "Hello ",)
                Text(text = name,)
            }
            OutlinedButton(onClick = { expanded = !expanded}) {
                Text(if(expanded)"Show less" else "Show more")
            }

        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    CodelabTheme {
        MyApp()
    }
}