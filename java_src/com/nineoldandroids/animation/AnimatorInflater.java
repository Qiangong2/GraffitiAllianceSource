package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {
    private static final int[] Animator = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    private static final int[] AnimatorSet = {16843490};
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int[] PropertyAnimator = {16843489};
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;

    private static Animator createAnimatorFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(c, parser, Xml.asAttributeSet(parser), null, 0);
    }

    private static Animator createAnimatorFromXml(Context c, XmlPullParser parser, AttributeSet attrs, AnimatorSet parent, int sequenceOrdering) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        int i = 0;
        int depth = parser.getDepth();
        ArrayList arrayList2 = null;
        Animator animator = null;
        while (true) {
            int next = parser.next();
            if ((next != 3 || parser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    String name = parser.getName();
                    if (name.equals("objectAnimator")) {
                        animator = loadObjectAnimator(c, attrs);
                    } else if (name.equals("animator")) {
                        animator = loadAnimator(c, attrs, null);
                    } else if (name.equals("set")) {
                        animator = new AnimatorSet();
                        TypedArray obtainStyledAttributes = c.obtainStyledAttributes(attrs, AnimatorSet);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        createAnimatorFromXml(c, parser, attrs, (AnimatorSet) animator, typedValue.type == 16 ? typedValue.data : 0);
                        obtainStyledAttributes.recycle();
                    } else {
                        throw new RuntimeException("Unknown animator name: " + parser.getName());
                    }
                    if (parent != null) {
                        arrayList = arrayList2 == null ? new ArrayList() : arrayList2;
                        arrayList.add(animator);
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList2 = arrayList;
                }
            }
        }
        if (!(parent == null || arrayList2 == null)) {
            Animator[] animatorArr = new Animator[arrayList2.size()];
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                animatorArr[i] = (Animator) it.next();
                i++;
            }
            if (sequenceOrdering == 0) {
                parent.playTogether(animatorArr);
            } else {
                parent.playSequentially(animatorArr);
            }
        }
        return animator;
    }

    public static Animator loadAnimator(Context context, int id) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = context.getResources().getAnimation(id);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, xmlResourceParser);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (IOException e2) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            notFoundException2.initCause(e2);
            throw notFoundException2;
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attrs, ValueAnimator anim) throws Resources.NotFoundException {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, Animator);
        long j = (long) obtainStyledAttributes.getInt(1, 0);
        long j2 = (long) obtainStyledAttributes.getInt(2, 0);
        int i = obtainStyledAttributes.getInt(7, 0);
        if (anim == null) {
            anim = new ValueAnimator();
        }
        boolean z = i == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z2 = peekValue != null;
        int i2 = z2 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z3 = peekValue2 != null;
        int i3 = z3 ? peekValue2.type : 0;
        if ((z2 && i2 >= 28 && i2 <= 31) || (z3 && i3 >= 28 && i3 <= 31)) {
            z = false;
            anim.setEvaluator(new ArgbEvaluator());
        }
        if (z) {
            if (z2) {
                float dimension = i2 == 5 ? obtainStyledAttributes.getDimension(5, 0.0f) : obtainStyledAttributes.getFloat(5, 0.0f);
                if (z3) {
                    anim.setFloatValues(dimension, i3 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
                } else {
                    anim.setFloatValues(dimension);
                }
            } else {
                anim.setFloatValues(i3 == 5 ? obtainStyledAttributes.getDimension(6, 0.0f) : obtainStyledAttributes.getFloat(6, 0.0f));
            }
        } else if (z2) {
            int dimension2 = i2 == 5 ? (int) obtainStyledAttributes.getDimension(5, 0.0f) : (i2 < 28 || i2 > 31) ? obtainStyledAttributes.getInt(5, 0) : obtainStyledAttributes.getColor(5, 0);
            if (z3) {
                anim.setIntValues(dimension2, i3 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
            } else {
                anim.setIntValues(dimension2);
            }
        } else if (z3) {
            anim.setIntValues(i3 == 5 ? (int) obtainStyledAttributes.getDimension(6, 0.0f) : (i3 < 28 || i3 > 31) ? obtainStyledAttributes.getInt(6, 0) : obtainStyledAttributes.getColor(6, 0));
        }
        anim.setDuration(j);
        anim.setStartDelay(j2);
        if (obtainStyledAttributes.hasValue(3)) {
            anim.setRepeatCount(obtainStyledAttributes.getInt(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            anim.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            anim.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return anim;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attrs) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attrs, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }
}
