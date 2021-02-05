package com.saad.maximatechtest.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.saad.maximatechtest.R
import com.saad.maximatechtest.databinding.WidgetUserInformationBinding

class UserInformationWidget @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var fieldLabel: String? = null
    private var binding: WidgetUserInformationBinding =
        WidgetUserInformationBinding.inflate(LayoutInflater.from(context))

    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.UserInformationWidget,
            0, 0
        ).apply {
            try {
                fieldLabel = getString(R.styleable.UserInformationWidget_userInfomationLabel)
            } finally {
                recycle()
            }
        }

        binding.userInfoLabel.text = fieldLabel

        addView(binding.root)
    }

    fun setValue(value: String) {
        binding.userInfoValue.text = value
    }
}