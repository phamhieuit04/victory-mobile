package com.example.victorymobile.services.auth

import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.example.victorymobile.models.User
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class FirebaseAuthService {
    private val webClientID: String =
        "534927885378-k49m51j5h8bi0cutivfn4unpkcjgha6l.apps.googleusercontent.com"
    private val authClient: FirebaseAuth = Firebase.auth

    private val googleIdOption = GetGoogleIdOption.Builder()
        .setServerClientId(webClientID)
        .setFilterByAuthorizedAccounts(false)
        .setAutoSelectEnabled(false)
        .build()

    private val request = GetCredentialRequest.Builder()
        .addCredentialOption(googleIdOption)
        .build()

    suspend fun processGoogleSignIn(
        context: Context,
        onResult: (Boolean, User?) -> Unit
    ) {
        try {
            val credentialManager: CredentialManager = CredentialManager.create(context = context)
            val result = credentialManager.getCredential(context = context, request = request)
            val credential = result.credential

            if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential =
                    GoogleIdTokenCredential.createFrom(data = credential.data)
                val googleAuthCredential =
                    GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)
                authClient.signInWithCredential(googleAuthCredential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val currentUser = authClient.currentUser
                            val user = User(
                                name = currentUser?.displayName,
                                email = currentUser?.email,
                                phone = currentUser?.phoneNumber,
                                avatar = currentUser?.photoUrl.toString()
                            )
                            onResult(true, user)
                        } else {
                            onResult(false, null)
                        }
                    }
            }
        } catch (e: Exception) {
            Log.i("MyApp", e.toString())
        }
    }
}