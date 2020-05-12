package com.jp.boilerplate.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.animation.RotateAnimation
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jp.boilerplate.R

class ExpandButton(context: Context, attrs: AttributeSet?) : AppCompatImageView(context, attrs) {
    var isExpand = MutableLiveData(false)

    val animator: (Boolean) -> RotateAnimation = {
        val fromDegrees: Float = if (it) 180f else 0f
        val toDegrees: Float = if (it) 0f else 180f
        RotateAnimation(fromDegrees, toDegrees, this.width / 2f, this.height / 2f).apply {
            duration = 250
            fillAfter = true
        }
    }

    init {
        setImageResource(R.drawable.ic_expand_more_24px)
    }

    fun setLifecycleOwner(lifecycleOwner: LifecycleOwner) {
        isExpand.observe(lifecycleOwner, Observer {
            startAnimation(animator(it))
        })
    }

    companion object {
        @BindingAdapter("toggleOnClickAttrChanged")
        @JvmStatic
        fun toggleOnClickAttrChanged(view: ExpandButton, listener: InverseBindingListener?) {
            listener?.let { inverseBindingListener ->
                view.setOnClickListener {
                    inverseBindingListener.onChange()
                }
            }
        }

        @BindingAdapter("toggleOnClick")
        @JvmStatic
        fun toggleOnClick(view: ExpandButton, toggle: Boolean) {
            view.isExpand.value = toggle
        }

        @InverseBindingAdapter(attribute = "toggleOnClick")
        @JvmStatic
        fun isToggleOnClick(view: ExpandButton): Boolean? {
            view.isExpand.value = view.isExpand.value?.let { !it }
            return view.isExpand.value
        }
    }
}