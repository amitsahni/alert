version - 1.0.0-alpha

### ProgressView
```
        ProgressView progressView = new ProgressView(this, R.style.Widget_ProgressDialog, R.layout.dialog_progress_base);
        progressView.show();
```     

``
compile 'com.github.amitsahni.alert:progressView:version'
``

### Toast
```
        Toast.with(context,message)
                .duration(android.widget.Toast.LENGTH_SHORT)
                .typeface(typeface)
                .show();
```   
``
compile 'com.github.amitsahni.alert:toast:version'
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
compile 'com.github.amitsahni.alert:snakebar:version'
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
compile 'com.github.amitsahni.alert:snackbar:version'
``

### Pref
```
    PrefUtil.with(context)
            .save(key,value);
    
    PrefUtil.with(context)
            .getString(key,defaultValue);    
```
``
compile 'com.github.amitsahni.alert:pref:version'
``