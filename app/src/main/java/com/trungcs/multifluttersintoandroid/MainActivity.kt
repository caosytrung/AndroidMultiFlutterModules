package com.trungcs.multifluttersintoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import com.trungcs.multifluttersintoandroid.flutter.second_module.FlutterSecondModule
import com.trungcs.multifluttersintoandroid.ui.theme.MultiFluttersIntoAndroidTheme

class MainActivity : ComponentActivity() {
    private val flutterSecondModule = FlutterSecondModule.getInstance()
    private val flutterFirstModule = FlutterFirstModule.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MultiFluttersIntoAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = getString(R.string.app_native_application),
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(64.dp))

                        ElevatedButton(onClick = ::openFirstModuleWithCachedEngine) {
                            Text(text = stringResource(id = R.string.open_cached_first_flutter_module))
                        }

                        Text(text = "------------------------")

                        ElevatedButton(onClick = ::openSecondModuleWithCachedEngine) {
                            Text(text = stringResource(id = R.string.open_cached_second_flutter_module))
                        }

                    }
                }
            }
        }
    }

    private fun openFirstModuleWithCachedEngine() {
        startActivity(flutterFirstModule.buildWithCachedEngine(this))
    }

    private fun openSecondModuleWithCachedEngine() {
        startActivity(flutterSecondModule.buildWithCachedEngine(this))
    }
}