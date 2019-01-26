package test.alert.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import test.alert.AppApplication;

@Singleton
@Component(modules = {PrefModule.class,
        DialogModule.class,
        AndroidSupportInjectionModule.class,
        AppBinder.class})
public interface AppComponent extends AndroidInjector<AppApplication> {
    void inject(AppApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(AppApplication application);

        AppComponent build();
    }
}
