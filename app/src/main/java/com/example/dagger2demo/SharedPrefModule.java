package com.example.dagger2demo;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/*  Annotations used in Dagger 2:

    @Module : This is used on the class that does the work of constructing objects
    that will be eventually provided as dependencies.

    @Provides : This is used on the methods inside the Module class that will return
    the object.

    @Singleton : This indicates that only a single instance of the dependency object
    would be created.

    @Inject : This is used upon a constructor, field or a method and indicates that
    dependency has been requested.

    @Component : The Module class doesn’t provide the dependency directly to the class
    that’s requesting it. For this, a Component interface is used that acts as a bridge
    between @Module and @Inject.

*/

@Module
public class SharedPrefModule {
    private Context context;

    public SharedPrefModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public SharedPreferences provideSharedPreferences() {
        return context.getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE);
    }

}
