package com.beerus.exceededittext.extensions

import android.view.View

inline var View.isMaxOpacity: Boolean
    get() = isEnabled
    set(value) {
        isEnabled = value
        alpha = if (value) 1F else 0.5F
    }