package test.alert.di;

import android.content.Context;

import com.pref.PrefUtil;
import com.pref.SharedPreferenceApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PrefModule {

    @Singleton
    @Provides
    public SharedPreferenceApp provideSharedPreference(Context context) {
        return PrefUtil.with(context);
    }


}
