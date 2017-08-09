package com.alertutil.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;

import com.alertutil.R;


/**
 * This class is used as Widget instead of TextView.This class has also a custom
 * attribute which is used in xml file.
 * <p>
 * This attribute is customtypeface support string value pass name of typeface
 * of using in asses folder here. It will automatically set on TextView text.
 * </P>
 *
 * @author amit.singh
 */
public class BaseTextView extends AppCompatTextView {

    /**
     * Instantiates a new Base text mView.
     *
     * @param context the context
     */
    public BaseTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new Base text mView.
     *
     * @param context the context
     * @param attrs   the attrs
     */
    public BaseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        setAttributes(attrs);
    }

    /**
     * Sets attributes.
     *
     * @param attrs the attrs
     */
    void setAttributes(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs,
                    R.styleable.ProgressViewApplication);

            String typeface = getContext().getString(a.getResourceId(R.styleable.ProgressViewApplication_customTypeface, -1));
            if (!TextUtils.isEmpty(typeface)) {
                Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                        typeface);
                setTypeface(tf);
            }
            float letterSpacing = a.getFloat(R.styleable.ProgressViewApplication_letterSpacing, 0.0f);
            boolean textAllCaps = a.getBoolean(R.styleable.ProgressViewApplication_android_textAllCaps, false);
            if (textAllCaps) {
                setText(getText().toString().toUpperCase());
            }
            a.recycle();
        }
    }

    /**
     * This method is used to setTextSize. In this float value is changed to
     * scaledDenisty and then set to the editText
     *
     * @param px float size of editText
     */
    public void setTextViewSize(float px) {
        float scaledDensity = getResources().getDisplayMetrics().scaledDensity;
        int sp = (int) (px / scaledDensity);
        setTextSize(sp);
    }

    /**
     * Gets forced gravity.
     *
     * @param langCode the lang code
     * @return the forced gravity
     */
    public int getForcedGravity(String langCode) {
        int gravity = Gravity.LEFT;
        if (!TextUtils.isEmpty(langCode)) {
            if (TextUtils.equals(langCode, "ar")) {
                gravity = Gravity.RIGHT;
            }
        }
        return gravity;
    }

    /**
     * Sets forced gravity.
     *
     * @param langCode the lang code
     */
    public void setForcedGravity(String langCode) {
        int gravity = Gravity.LEFT;
        if (!TextUtils.isEmpty(langCode)) {
            if (TextUtils.equals(langCode, "ar")) {
                gravity = Gravity.RIGHT;
            }
        }
        this.setGravity(gravity);
    }

    /**
     * ***************
     * Spacing between characters of text mView
     * *******************
     * <ahref http://stackoverflow.com/questions/5133548/how-to-change-letter-spacing-in-a-textview></ahref>
     * <ahref http://stackoverflow.com/questions/5133548/how-to-change-letter-spacing-in-a-textview></ahref>
     */



}
