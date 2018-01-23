### ProgressView
```
        ProgressView progressView = new ProgressView(this, R.style.Widget_ProgressDialog, R.layout.dialog_progress_base);
        progressView.show();
```     

``
compile 'com.github.amitsahni.alert:progressView:1.0.0-alpha'
``

### Toast
```
        Toast.with(context,message)
                .duration(android.widget.Toast.LENGTH_SHORT)
                .typeface(typeface)
                .show();
```   
``
compile 'com.github.amitsahni.alert:toast:1.0.0-alpha'
``
### SnakeBar
```
        SnackBar.with(acitivityContext, message)
                .actionMessage("Ok")
                .typeface(typeface)
                .duration(Snackbar.LENGTH_SHORT)
                .info()
                .show();
```
``
compile 'com.github.amitsahni.alert:snakebar:1.0.0-alpha'
``
### Dailog
Single Option
```
        Dialog.with(this)
                .asSingleOption("Ok")
                .title("title")
                .message("message")
                .tag(1)
                .icon(android.R.drawable.sym_action_call)
                .onClick(new OnDialogClickListener() {
                 @Override
                 public void onClick(int tag, DialogInterface dialog, int pos, Button button) {
                                                         
                 }
                 })
                .show();
```
Double Option
```
       Dialog.with(this)
                .asDoubleOption("Ok", "cancel")
                .message("Message")
                .title("title")
                .onClick(new OnDialogClickListener() {
                @Override
                public void onClick(int tag, DialogInterface dialog, int pos, Button button) {
                   
                }
                })
                .show();
```
List
```
       Dialog.with(this)
               .asList("Item1","Item2")
               .title("title")
               .onClick(new OnDialogListClickListener() {
               @Override
               public void onClick(int tag, DialogInterface dialog, int pos, String value) {
               
               }
               })
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
		compile 'com.github.amitsahni:alert-util:1.0.1'
	}
```