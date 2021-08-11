package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.unity3d.player.i */
public final class DialogC1618i extends Dialog implements TextWatcher, View.OnClickListener {

    /* renamed from: c */
    private static int f4144c = 1627389952;

    /* renamed from: d */
    private static int f4145d = -1;

    /* renamed from: e */
    private static int f4146e = 134217728;

    /* renamed from: f */
    private static int f4147f = 67108864;

    /* renamed from: a */
    private Context f4148a = null;

    /* renamed from: b */
    private UnityPlayer f4149b = null;

    public DialogC1618i(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        super(context);
        this.f4148a = context;
        this.f4149b = unityPlayer;
        getWindow().setGravity(80);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (C1617h.f4140a) {
            getWindow().clearFlags(f4146e);
            getWindow().clearFlags(f4147f);
        }
        EditText editText = (EditText) findViewById(1057292289);
        m6128a(editText, str, i, z, z2, z3, str2);
        ((Button) findViewById(1057292290)).setOnClickListener(this);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.unity3d.player.DialogC1618i.View$OnFocusChangeListenerC16191 */

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    DialogC1618i.this.getWindow().setSoftInputMode(5);
                }
            }
        });
    }

    /* renamed from: a */
    private static int m6125a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z2 ? 131072 : 0) | (z ? 32768 : 0);
        if (z3) {
            i2 = 128;
        }
        int i4 = i2 | i3;
        return (i < 0 || i > 7) ? i4 : i4 | new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33}[i];
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private String m6126a() {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return null;
        }
        return editText.getText().toString().trim();
    }

    /* renamed from: a */
    private void m6128a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f4144c);
        editText.setInputType(m6125a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        editText.addTextChangedListener(this);
        editText.setClickable(true);
        if (!z2) {
            editText.selectAll();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: a */
    private void m6130a(String str, boolean z) {
        Selection.removeSelection(((EditText) findViewById(1057292289)).getEditableText());
        this.f4149b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public final void mo9100a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void afterTextChanged(Editable editable) {
        this.f4149b.reportSoftInputStr(editable.toString(), 0, false);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public final View createSoftInputView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f4148a);
        relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f4145d);
        C16202 r0 = new EditText(this.f4148a) {
            /* class com.unity3d.player.DialogC1618i.C16202 */

            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i == 4) {
                    DialogC1618i.this.m6130a(DialogC1618i.this.m6126a(), true);
                    return true;
                } else if (i != 84) {
                    return super.onKeyPreIme(i, keyEvent);
                } else {
                    return true;
                }
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) DialogC1618i.this.f4148a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        r0.setLayoutParams(layoutParams);
        r0.setId(1057292289);
        relativeLayout.addView(r0);
        Button button = new Button(this.f4148a);
        button.setText(this.f4148a.getResources().getIdentifier("ok", "string", "android"));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        button.setLayoutParams(layoutParams2);
        button.setId(1057292290);
        button.setBackgroundColor(0);
        relativeLayout.addView(button);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.unity3d.player.DialogC1618i.C16213 */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 6) {
                    DialogC1618i.this.m6130a(DialogC1618i.this.m6126a(), false);
                }
                return false;
            }
        });
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    public final void onBackPressed() {
        m6130a(m6126a(), true);
    }

    public final void onClick(View view) {
        m6130a(m6126a(), false);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
