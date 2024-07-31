/*
 * Copyright (C) 2023 The Android Open Source Project
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

package com.example.sports.data

import com.example.sports.R
import com.example.sports.model.Sport

/**
 * Sports data
 */
object LocalSportsDataProvider{
    val defaultSport = getSportsData()[0]

    fun getSportsData(): List<Sport> {
        return listOf(
            Sport(
                id = 1,
                titleResourceId = R.string.gym,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.gym,
                sportsImageBanner = R.drawable.ic_basketball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 2,
                titleResourceId = R.string.basketball,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 5,
                olympic = true,
                imageResourceId = R.drawable.basquetbol,
                sportsImageBanner = R.drawable.ic_basketball_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 3,
                titleResourceId = R.string.running,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.atletismo,
                sportsImageBanner = R.drawable.ic_running_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 4,
                titleResourceId = R.string.soccer,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 11,
                olympic = true,
                imageResourceId = R.drawable.futbol,
                sportsImageBanner = R.drawable.ic_soccer_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 5,
                titleResourceId = R.string.swimming,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.natacion,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 6,
                titleResourceId = R.string.tae,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.tae,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 7,
                titleResourceId = R.string.danza,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.danza,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 8,
                titleResourceId = R.string.box,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.box,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 9,
                titleResourceId = R.string.voleibol,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.volei,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 10,
                titleResourceId = R.string.escolta,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.escolta,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            ),
            Sport(
                id = 11,
                titleResourceId = R.string.banda,
                subtitleResourceId = R.string.sports_list_subtitle,
                playerCount = 1,
                olympic = true,
                imageResourceId = R.drawable.banda,
                sportsImageBanner = R.drawable.ic_swimming_banner,
                sportDetails = R.string.sport_detail_text
            )
        )
    }
}
