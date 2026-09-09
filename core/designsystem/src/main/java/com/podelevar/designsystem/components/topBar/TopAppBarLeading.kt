package com.podelevar.designsystem.components.topBar

sealed interface TopAppBarLeading {
    data object BrandIcon : TopAppBarLeading
    data object BrandLockup : TopAppBarLeading
    data class Back(val onBackClick: () -> Unit) : TopAppBarLeading
}