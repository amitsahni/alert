package test.alert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alertutil.alert.Alert;
import com.alertutil.dialog.OnDialogProcess;
import com.alertutil.dialog.ProgressView;

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
//                Alert.with(this, AlertParam.DialogType.SINGLE_OPTION)
//                        .message(R.string.app_name)
//                        .positiveButton(android.R.string.ok)
//                        .listener(new OnDialogProcess() {
//                            @Override
//                            public void onDialog(int dialogId, Bundle bundle, Object object, int selectionType) {
//                                if (selectionType == POSITIVE) {
////                                    Alert.with(MainActivity.this).message("Positive").show();
//                                }
//                            }
//                        })
//                        .show();
                break;
            case R.id.dbl:
//                Alert.with(this, AlertParam.DialogType.DOUBLE_OPTION)
//                        .message(R.string.app_name)
//                        .negativeButton(android.R.string.cancel)
//                        .positiveButton(android.R.string.ok)
//                        .listener(new OnDialogProcess() {
//                            @Override
//                            public void onDialog(int dialogId, Bundle bundle, Object object, int selectionType) {
//                                if (selectionType == POSITIVE) {
//                                    // Alert.with(getApplicationContext()).message("Positive").show();
//                                } else {
//                                    // Alert.with(getApplicationContext()).message("Negative").show();
//                                }
//                            }
//                        })
//                        .show();
                break;
            case R.id.toast:
//                Alert.with(getApplicationContext(), R.string.app_name).show();
                break;
            case R.id.progress:
                ProgressView progressView = new ProgressView(this, R.style.Widget_ProgressDialog, R.layout.activity_main);
                progressView.show();
                break;
        }
    }
}
