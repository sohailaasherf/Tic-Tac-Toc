package com.sohaila.project

import android.os.Bundle
import android.widget.RadioButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.experimental.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sohaila.project.ui.theme.ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                   myapp()
                   // myradiobutton()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = MaterialTheme.colors.primary,
    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Text(text = name)
            myradiobutton()

        }
    }
}

@Composable
fun myradiobutton(){
    val radiooptions= listOf("yes","no")

  //  val radiobuttons = listOf(0,1)
    val selectedbutton = remember {
        mutableStateOf(radiooptions.first())
    }


    Column( ){
        radiooptions.forEach{ text->
            val isSelected = text== selectedbutton.value
            RadioButton(selected =isSelected, onClick = { selectedbutton.value=text })
            Text(text = text)

        }
        
    }



}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProjectTheme {
        Greeting("Android")
    }
}

@Composable
fun myapp(names:List<String> = listOf("CHD","PHYSICS ACTIVITY","FRUITS","VEGIES","HVY","HEALTH CARE")){
    Column() {
        for (name in names)
            Greeting(name = name)
        
    }

}
