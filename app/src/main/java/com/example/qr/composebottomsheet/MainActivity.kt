package com.example.qr.composebottomsheet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.qr.composebottomsheet.ui.theme.ComposeBottomSheetTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBottomSheetTheme {
                var showBottomSheet by remember { mutableStateOf(false) }

                Column (
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Button(onClick = { showBottomSheet = true }) {
                        Text("Show Bottom Sheet")
                    }
                    if (showBottomSheet) {
                        ModalBottomSheet(
                            sheetState = rememberModalBottomSheetState(),
                            onDismissRequest = {
                                showBottomSheet = false
                                Toast.makeText(this@MainActivity, "Bottom sheet dismissed", Toast.LENGTH_SHORT).show()
                            },
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "This is the bottom sheet content",
                                    modifier = Modifier.padding(16.dp)
                                )
                                Button(
                                    onClick = {
                                        showBottomSheet = false
                                    },
                                    modifier = Modifier.padding(16.dp)
                                ) {
                                    Text("Dismiss")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}