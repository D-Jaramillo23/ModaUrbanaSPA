package com.example.modaurbanaspa.utils

fun isValidEmail(input: String): Boolean=
    input.isNotBlank() && input.contains("@")&& input.contains(".")

fun isValidPassword(input: String): Boolean =
    input.length >= 6