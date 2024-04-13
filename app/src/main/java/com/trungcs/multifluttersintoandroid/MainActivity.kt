package com.trungcs.multifluttersintoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModule
import com.trungcs.multifluttersintoandroid.flutter.first_module.FlutterFirstModuleCallEvents
import com.trungcs.multifluttersintoandroid.ui.theme.MultiFluttersIntoAndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var flutterFirstModule: FlutterFirstModule
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpFlutterCallBack()

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
                        ElevatedButton(onClick = ::openNewEngineFlutterFirstModule) {
                            Text(text = stringResource(id = R.string.open_new_first_flutter_module))
                        }

                        ElevatedButton(onClick = ::openCachedEngineFlutterFirstModule) {
                            Text(text = stringResource(id = R.string.open_cached_first_flutter_module))
                        }
                    }
                }
            }
        }
    }

    private fun setUpFlutterCallBack() {
        flutterFirstModule.setCallBack(object : FlutterFirstModuleCallEvents {
            override fun onOpenSecondModule() {

            }
        })
    }

    private fun openCachedEngineFlutterFirstModule() {
        startActivity(flutterFirstModule.buildWithNewEngine(this))
    }

    private fun openNewEngineFlutterFirstModule() {
        startActivity(flutterFirstModule.buildWithCachedEngine(this))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiFluttersIntoAndroidTheme {

    }
}