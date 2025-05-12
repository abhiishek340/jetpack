package com.example.codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    var expanded by remember {mutableStateOf(false)}
    val extrapadding = if (expanded)48.dp else 0.dp
    Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp) ){
        Row (modifier = Modifier.padding(24.dp)){
            Column (modifier = Modifier.weight(1f).padding(bottom = extrapadding)){
                Text(text = "Hello ",)
                Text(text = name,)
            }
            OutlinedButton(onClick = { expanded = !expanded}) {
                Text(if(expanded)"Show less" else "Show more" , color = MaterialTheme.colorScheme.onBackground)
            }

        }
    }
}



@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Surface {
        Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the  Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { shouldShowOnboarding = false }
        ) {
            Text("Continue")
        }

        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
   CodelabTheme {
        OnboardingScreen()
    }
}





@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingPreview() {
    CodelabTheme {
        MyApp()
    }
}