package test.alert.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import test.alert.MainActivity;

@Module
public abstract class AppBinder {
    @ContributesAndroidInjector
    public abstract MainActivity mainActivity();
}
