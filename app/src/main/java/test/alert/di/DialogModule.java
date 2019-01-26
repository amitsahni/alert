package test.alert.di;

import android.content.Context;

import com.progressView.Builder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class DialogModule {


    @Singleton
    @Provides
    public Builder provideBuilder(Context context) {
        return new Builder(context);
    }


}
