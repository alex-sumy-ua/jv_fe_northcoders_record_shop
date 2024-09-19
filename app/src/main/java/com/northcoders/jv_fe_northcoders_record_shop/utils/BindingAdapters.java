package com.northcoders.jv_fe_northcoders_record_shop.utils;

import android.text.TextUtils;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({
        @InverseBindingMethod(type = EditText.class, attribute = "android:text", method = "getText")
})
public class BindingAdapters {

    @BindingAdapter("android:text")
    public static void setInteger(EditText view, int value) {
        if (!TextUtils.isEmpty(view.getText()) && Integer.parseInt(view.getText().toString()) == value) {
            return;
        }
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static int getInteger(EditText view) {
        if (!TextUtils.isEmpty(view.getText())) {
            return Integer.parseInt(view.getText().toString());
        }
        return 0;
    }

    @BindingAdapter("android:text")
    public static void setFloat(EditText view, float value) {
        if (!TextUtils.isEmpty(view.getText()) && Float.parseFloat(view.getText().toString()) == value) {
            return;
        }
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static float getFloat(EditText view) {
        if (!TextUtils.isEmpty(view.getText())) {
            return Float.parseFloat(view.getText().toString());
        }
        return 0f;
    }
}