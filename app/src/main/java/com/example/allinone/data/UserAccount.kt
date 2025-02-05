package com.example.allinone.data

import androidx.annotation.StringRes

data class UserAccount (
    /** User's unique ID **/
    val id: Long,
    /** User's first name **/
    val firstName: String,
    /** User's email address **/
    val email: String,
)
