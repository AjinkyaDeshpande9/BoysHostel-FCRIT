package com.example.boyshostelfcrit.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldPath
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User

object FirestoreUtil {
    private val firestoreInstance: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    private val currentUserDocRef: DocumentReference
    get() = firestoreInstance.document("user/${FirebaseAuth.getInstance().uid
        ?: throw NullPointerException("UID is null")}")

    fun initCurrentUSerIfFirstTime(onComplete: () -> Unit){
        currentUserDocRef.get().addOnSuccessListener { documentSnapshot ->
            if(!documentSnapshot.exists()){
                val newUser = com.example.boyshostelfcrit.model.User(FirebaseAuth.getInstance().currentUser?.displayName ?: "",
                "", null)
                currentUserDocRef.set(newUser).addOnSuccessListener {
                    onComplete()
                }
            }
            else
                onComplete()
        }
    }
    fun updateCurrentUser(name: String = "",dept: String = "", profilePicturePath: String? = null) {
        val userFieldMap = mutableMapOf<String, Any>()
        if(name.isNotBlank()) userFieldMap["name"] = name
        if(dept.isNotBlank()) userFieldMap["dept"] = dept
        if(profilePicturePath != null)
            userFieldMap["profilePicturePath"]= profilePicturePath
        currentUserDocRef.update(userFieldMap)
    }
    fun getCurrentUser(onComplete: (User) -> Unit){
        currentUserDocRef.get()
            .addOnSuccessListener {
                it.toObject(User::class.java)?.let { it1 -> onComplete(it1) }
            }
    }


}