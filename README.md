### ProgressView
```
        ProgressView progressView = new ProgressView(this, R.style.Widget_ProgressDialog, R.layout.dialog_progress_base);
        progressView.show();
```     
### Toast
```
        ToastParam param = Alert.with(getApplicationContext(),R.string.app_name).show();
```     
### SnakeBar
```
        SnackBarParam param = Alert.with(this,R.string.app_name).show();
```
### Dailog
```
        AlertParam param = Alert.with(this, AlertParam.DialogType.SINGLE_OPTION)
                .message(R.string.app_name)
                .negativeButton(android.R.string.cancel)
                .positiveButton(android.R.string.ok)
                .show();
```
Download
--------
Add the JitPack repository to your root build.gradle:

```groovy
	allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
```
Add the Gradle dependency:
```groovy
	dependencies {
		compile 'com.github.amitclickapps:pubnub-util:1.0.1'
	}
```