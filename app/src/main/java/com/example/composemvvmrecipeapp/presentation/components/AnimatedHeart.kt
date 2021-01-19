package com.example.composemvvmrecipeapp.presentation.components
import androidx.compose.animation.ColorPropKey
import com.example.composemvvmrecipeapp.presentation.components.AnimatedHeartState.*

import androidx.compose.animation.core.IntPropKey
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.transition
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

enum class AnimatedHeartState{
    IDLE,CHANGING
}

@Composable
fun AnimatedHeart(){
    val idleSize = 50
    val changingSize = 80
    val heartSize = IntPropKey(label = "heartSize")
    val heartColor = ColorPropKey(label = "heartColor")
    val transition = transition(
        initState = IDLE,
        toState = CHANGING,
        definition = transitionDefinition<AnimatedHeartState> {
            state(IDLE){
                this[heartSize] = idleSize
                this[heartColor] = Color.LightGray
            }
            state(CHANGING){
                this[heartSize] = changingSize
                this[heartColor] = Color.Red
            }
        }
    )

//    Text(style = TextStyle(fontSize = transition[heartSize].sp) ,
//        text = "Hello")
}