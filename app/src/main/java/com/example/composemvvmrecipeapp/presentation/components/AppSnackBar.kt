package com.example.composemvvmrecipeapp.presentation.components

import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun AppSnasckBar(
    snackbarHostState: SnackbarHostState,
    onActionClicked:() -> Unit,
    modifier : Modifier = Modifier
) {

    SnackbarHost(
        modifier = modifier,
        hostState = snackbarHostState,
        snackbar = { data ->
            Snackbar(
                modifier = Modifier.padding(8.dp),
                action = {
                    data.actionLabel?.let { actionLabel ->
                        TextButton(onClick = { onActionClicked() }) {
                            Text(text = actionLabel)
                        }
                    }
                }
            ) {
                Text(text = data.message)
            }
        }
    )
}