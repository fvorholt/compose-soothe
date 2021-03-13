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
package com.example.androiddevchallenge

import com.example.androiddevchallenge.model.Topic

object DataProvider {

    fun getFavoriteTopics(filter: String? = null): List<Topic> {
        print(filter)
        return listOf(
            Topic(title = "Short mantras", imageRes = R.drawable.self_massage),
            Topic(title = "Stress and anxiety", imageRes = R.drawable.stress_and_anxiety),
            Topic(title = "Overwhelmed", imageRes = R.drawable.overwhelmed),
            Topic(title = "Nature meditations", imageRes = R.drawable.nature_meditations),
            Topic(title = "Self-massage", imageRes = R.drawable.self_massage),
            Topic(title = "Nightly wind down", imageRes = R.drawable.nightly_wind_down),
        ).filter { filter == null || it.title.contains(filter, ignoreCase = true) }
    }

    fun getBodyTopics(filter: String? = null): List<Topic> {
        return listOf(
            Topic(title = "Inversions", imageRes = R.drawable.inversions),
            Topic(title = "Quick yoga", imageRes = R.drawable.quick_yoga),
            Topic(title = "Stretching", imageRes = R.drawable.streching),
            Topic(title = "Tabata", imageRes = R.drawable.tabata),
            Topic(title = "HILT", imageRes = R.drawable.hilt),
            Topic(title = "Pre-natal yoga", imageRes = R.drawable.pre_natal_yoga),
        ).filter { filter == null || it.title.contains(filter, ignoreCase = true) }
    }

    fun getMindTopics(filter: String? = null): List<Topic> {
        return listOf(
            Topic(title = "Meditate", imageRes = R.drawable.meditate),
            Topic(title = "With kids", imageRes = R.drawable.with_kids),
            Topic(title = "Aromatherapy", imageRes = R.drawable.aromatherapy),
            Topic(title = "On the go", imageRes = R.drawable.on_the_go),
            Topic(title = "With pets", imageRes = R.drawable.with_pets),
            Topic(title = "High stress", imageRes = R.drawable.high_stress),
        ).filter { filter == null || it.title.contains(filter, ignoreCase = true) }
    }
}
