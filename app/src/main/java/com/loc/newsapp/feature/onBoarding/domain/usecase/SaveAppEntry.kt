package com.loc.newsapp.feature.onBoarding.domain.usecase

import com.loc.newsapp.feature.onBoarding.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}