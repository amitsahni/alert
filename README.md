version - 1.0.5

### CustomDialog
```
        CustomDialog.with(this)
                    .view(R.layout.activity_main)
                    .build();
```     

``
api 'com.github.amitsahni.alert:customdialog:version'
``

### Toast
```
        Toast.with(context,message)
                .duration(android.widget.Toast.LENGTH_SHORT)
                .typeface(typeface)
                .show();
```   
``
api 'com.github.amitsahni.alert:toast:version'
``
### SnackBar
```
        SnackBar.with(acitivityContext, message)
                .actionMessage("Ok")
                .typeface(typeface)
                .duration(Snackbar.LENGTH_SHORT)
                .info()
                .show();
```
``
api 'com.github.amitsahni.alert:snackbar:version'
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
``
api 'com.github.amitsahni.alert:dialog:version'
``

### Pref
```
    PrefUtil.with(context)
            .save(key,value);
    
    PrefUtil.with(context)
            .getString(key,defaultValue);    
```
``
api 'com.github.amitsahni.alert:pref:version'
``

Add the JitPack repository to your root build.gradle:

```
	allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}
```