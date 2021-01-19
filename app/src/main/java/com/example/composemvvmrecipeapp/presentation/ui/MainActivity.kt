package com.example.composemvvmrecipeapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.composemvvmrecipeapp.R
import dagger.hilt.android.AndroidEntryPoint

const val STATE_KEY_RECIPE_ID = "recipe_id"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setContent {
//            ScrollableColumn(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFFF2F2F2))
//            ) {
//                Image(
//                    bitmap = imageFromResource(res = resources, resId = R.drawable.foods),
//                    modifier = Modifier.height(300.dp),
//                    contentScale = ContentScale.Crop
//                )
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.SpaceBetween
//                    ) {
//                        Text(
//                            text = "Happy Meal",
//                            style = TextStyle(
//                                fontSize = TextUnit.Companion.Sp(27)
//                            )
//                        )
//                        Text(
//                            text = "$34.5",
//                            style = TextStyle(
//                                fontSize = TextUnit.Companion.Sp(17),
//                                color = Color(0xFF4CAF50)
//                            ),
//                            modifier = Modifier.align(Alignment.CenterVertically)
//                        )
//                    }
//                    Spacer(modifier = Modifier.padding(8.dp))
//                    Text(
//                        text = "800 Calories",
//                        style = TextStyle(fontSize = TextUnit.Companion.Sp(17))
//                    )
//                    Spacer(modifier = Modifier.padding(8.dp))
//                    Button(
//                        modifier = Modifier.align(Alignment.CenterHorizontally),
//                        onClick = { /*TODO*/ }
//                    ) {
//                        Text(text = "ORDER NOW")
//                    }
//                }
//            }
//        }
    }
}