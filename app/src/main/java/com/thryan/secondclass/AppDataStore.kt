package com.thryan.secondclass

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.thryan.secondclass.model.Constant
import com.thryan.secondclass.model.Constant.KEY_ACCOUNT
import com.thryan.secondclass.model.Constant.KEY_DYNAMIC
import com.thryan.secondclass.model.Constant.KEY_LAST_TIME
import com.thryan.secondclass.model.Constant.KEY_PASSWORD
import com.thryan.secondclass.model.Constant.KEY_RESIGN
import com.thryan.secondclass.model.Constant.KEY_SC_PASSWORD
import com.thryan.secondclass.model.Constant.KEY_TWFID
import com.thryan.secondclass.model.Constant.KEY_WEB_VIEW
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
class AppDataStore @Inject constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun putAccount(value: String) {
        putString(KEY_ACCOUNT, value)
    }

    suspend fun putPassword(value: String) {
        putString(KEY_PASSWORD, value)
    }

    suspend fun putScPassword(value: String) {
        putString(KEY_SC_PASSWORD, value)
    }

    suspend fun putTwfid(value: String) {
        putString(KEY_TWFID, value)
    }

    suspend fun putLastTime(value: String) {
        putString(KEY_LAST_TIME, value)
    }

    suspend fun putDynamic(value: Boolean) {
        dataStore.edit {
            it[KEY_DYNAMIC] = value
        }
    }

    suspend fun putWebView(value: Boolean) {
        dataStore.edit {
            it[KEY_WEB_VIEW] = value
        }
    }

    suspend fun putResign(value: Boolean) {
        dataStore.edit {
            it[KEY_RESIGN] = value
        }
    }


    fun getAccount(default: String): String = runBlocking {
        val string = getString(KEY_ACCOUNT)
        return@runBlocking string ?: default
    }

    fun getPassword(default: String): String = runBlocking {
        val string = getString(KEY_PASSWORD)
        return@runBlocking string ?: default
    }

    fun getScPassword(default: String): String = runBlocking {
        val string = getString(KEY_SC_PASSWORD)
        return@runBlocking string ?: default
    }

    fun getTwfid(default: String): String = runBlocking {
        val string = getString(KEY_TWFID)
        return@runBlocking string ?: default
    }

    fun getLastTime(default: String): String = runBlocking {
        val string = getString(KEY_LAST_TIME)
        return@runBlocking string ?: default
    }

    fun getDynamic(default: Boolean): Boolean = runBlocking {
        val bool = dataStore.data.map {
            it[KEY_DYNAMIC]
        }.first()
        return@runBlocking bool ?: default
    }

    fun getWebView(default: Boolean): Boolean = runBlocking {
        val bool = dataStore.data.map {
            it[KEY_WEB_VIEW]
        }.first()
        return@runBlocking bool ?: default
    }


    fun getResign(default: Boolean): Boolean = runBlocking {
        val bool = dataStore.data.map {
            it[KEY_RESIGN]
        }.first()
        return@runBlocking bool ?: default
    }


    suspend fun putKeyword(value: String) {
        putString(Constant.KEY_KEYWORD, value)
    }

    suspend fun putStatus(value: String) {
        putString(Constant.KEY_STATUS, value)
    }

    suspend fun putType(value: String) {
        putString(Constant.KEY_TYPE, value)
    }

    suspend fun putOnlySign(value: Boolean) {
        dataStore.edit {
            it[Constant.KEY_ONLY_SIGN] = value
        }
    }

    suspend fun putExcludeClasses(value: Boolean) {
        dataStore.edit {
            it[Constant.KEY_EXCLUDE_CLASSES] = value
        }
    }


    fun getKeyword(default: String): String = runBlocking {
        val string = getString(Constant.KEY_KEYWORD)
        return@runBlocking string ?: default
    }

    fun getStatus(default: String): String = runBlocking {
        val string = getString(Constant.KEY_STATUS)
        return@runBlocking string ?: default
    }

    fun getType(default: String): String = runBlocking {
        val string = getString(Constant.KEY_TYPE)
        return@runBlocking string ?: default
    }


    fun getOnlySign(default: Boolean): Boolean = runBlocking {
        val bool = dataStore.data.map {
            it[Constant.KEY_ONLY_SIGN]
        }.first()
        return@runBlocking bool ?: default
    }

    fun getExcludeClasses(default: Boolean): Boolean = runBlocking {
        val bool = dataStore.data.map {
            it[Constant.KEY_EXCLUDE_CLASSES]
        }.first()
        return@runBlocking bool ?: default
    }

    private suspend fun putString(key: Preferences.Key<String>, value: String) = dataStore.edit {
        it[key] = value
    }

    private fun getString(key: Preferences.Key<String>): String? = runBlocking {
        return@runBlocking dataStore.data.map {
            it[key]
        }.first()
    }

}