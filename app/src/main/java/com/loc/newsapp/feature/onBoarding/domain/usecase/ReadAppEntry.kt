package com.loc.newsapp.feature.onBoarding.domain.usecase
import com.loc.newsapp.feature.onBoarding.domain.manager.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}