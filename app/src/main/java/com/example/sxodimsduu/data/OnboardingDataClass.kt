package com.example.sxodimsduu.data

import com.example.sxodimsduu.R

data class OnboardingData(
    val image: Int,
    val description: String,
)

val onboardingPages = listOf(
    OnboardingData(
        R.drawable.sdu,
        "SDU University is one of the leading private universities in Kazakhstan, located in Kaskelen. It was founded in 1996."
    ),
    OnboardingData(
        R.drawable.we_club, "WE - is a student club of the FENS faculty, established in 2021. Its mission is to make the social life of students vibrant, rich and unforgettable."
    ),
    OnboardingData(
        R.drawable.sxodim, "SXODIM.SDU unifies all student services into a single, user-friendly interface and helps you efficiently manage your studies and student life!"
    ),

    )