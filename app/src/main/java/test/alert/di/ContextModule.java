package test.alert.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import test.alert.AppApplication;

@Module
public abstract class ContextModule {


    @Singleton
    @Binds
    public abstract Context providerContext(AppApplication context);
}
