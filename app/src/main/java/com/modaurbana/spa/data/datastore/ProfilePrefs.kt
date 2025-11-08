package com.modaurbana.spa.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

// Extensión de Context para tener un DataStore propio del perfil
private val Context.profileDataStore by preferencesDataStore(name = "profile_prefs")

class ProfilePrefs(private val context: Context) {

    // Claves
    private val KEY_DISPLAY_NAME = stringPreferencesKey("display_name")
    private val KEY_AVATAR_URI   = stringPreferencesKey("avatar_uri")

    // Lecturas (flows)
    val displayNameFlow: Flow<String> =
        context.profileDataStore.data.map { prefs -> prefs[KEY_DISPLAY_NAME] ?: "" }

    val avatarUriFlow: Flow<String> =
        context.profileDataStore.data.map { prefs -> prefs[KEY_AVATAR_URI] ?: "" }

    // Escrituras (suspend)
    suspend fun saveDisplayName(name: String) {
        context.profileDataStore.edit { it[KEY_DISPLAY_NAME] = name }
    }

    suspend fun saveAvatarUri(uri: String) {
        context.profileDataStore.edit { it[KEY_AVATAR_URI] = uri }
    }

    suspend fun clearAll() {
        context.profileDataStore.edit { it.clear() }
    }
}
