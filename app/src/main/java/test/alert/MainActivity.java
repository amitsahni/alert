package test.alert;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.dialog.Dialog;
import com.dialog.OnDialogClickListener;
import com.dialog.OnDialogListClickListener;
import com.pref.PrefUtil;
import com.progressView.CustomDialog;
import com.snackbar.SnackBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by clickapps on 31/8/17.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.single)
    Button single;

    @BindView(R.id.dbl)
    Button dbl;

    @BindView(R.id.toast)
    Button toast;

    @BindView(R.id.progress)
    Button progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        single.setOnClickListener(this);
        dbl.setOnClickListener(this);
        toast.setOnClickListener(this);
        progress.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.single:
                Dialog.with(this)
                        .asSingleOption(R.string.app_name)
                        .title("title")
                        .tag(1)
                        .message("message")
                        .icon(android.R.drawable.sym_action_call)
                        .onClick(new OnDialogClickListener() {
                            @Override
                            public void onClick(int tag, DialogInterface dialog, int pos, Button button) {
                                SnackBar.with(MainActivity.this, button.name())
                                        .actionMessage("Ok")
                                        .info()
                                        .show();

                            }
                        })
                        .show();
                break;
            case R.id.dbl:
                Dialog.with(this)
                        .asDoubleOption("Ok", "cancel")
                        .message("Message")
                        .title("title")
                        .onClick(new OnDialogClickListener() {
                            @Override
                            public void onClick(int tag, DialogInterface dialog, int pos, Button button) {
                                SnackBar.with(MainActivity.this, button.name())
                                        .actionMessage("Ok")
                                        .info().show();
                            }
                        })
                        .show();
                break;
            case R.id.toast:
                Dialog.with(this)
                        .asList("aaa")
                        .title("title")
                        .onClick(new OnDialogListClickListener() {
                            @Override
                            public void onClick(int tag, DialogInterface dialog, int pos, String value) {
                                SnackBar.with(MainActivity.this, value)
                                        .actionMessage("Ok")
                                        .info().show();
                                PrefUtil.with(MainActivity.this)
                                        .save("key", "value");
                            }
                        })
                        .show();
                break;
            case R.id.progress:
                CustomDialog.with(this)
                        .view(R.layout.activity_main)
                        .build();
                break;
        }
    }
}
