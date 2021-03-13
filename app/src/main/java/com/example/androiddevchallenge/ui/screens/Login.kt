/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.views.PrimaryButton
import com.example.androiddevchallenge.ui.views.TextInput

@Composable
fun Login(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val background = if (isSystemInDarkTheme()) {
        painterResource(id = R.drawable.login_background_dark)
    } else {
        painterResource(id = R.drawable.login_background_light)
    }

    var mail by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = background,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text("LOG IN", style = MaterialTheme.typography.h1)
            Spacer(Modifier.size(32.dp))
            TextInput(
                value = mail,
                onValueChange = { mail = it },
                placeholder = "Email address",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(Modifier.size(8.dp))
            TextInput(
                value = password,
                onValueChange = { password = it },
                placeholder = "Password",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
            Spacer(Modifier.size(8.dp))
            PrimaryButton(caption = "log in", onClick = { onLoginClick() })
            Spacer(Modifier.size(16.dp))
            Text(
                text = AnnotatedString(
                    text = "Don't have an account? Sign up",
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            SpanStyle(
                                textDecoration = TextDecoration.Underline
                            ),
                            23, 30
                        )
                    )
                ),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.clickable { onSignUpClick() }
            )
        }
    }
}
