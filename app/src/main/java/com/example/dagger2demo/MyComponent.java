package com.example.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;

/*  All the modules are mentioned inside the @Component annotation.
    The activities, services, or fragments that are allowed to request the
    dependencies declared by the modules (using @Inject) should be declared in this
    interface with individual inject() methods.
 */

@Singleton
@Component(modules = SharedPrefModule.class)
public interface MyComponent {
    void inject(MainActivity mainActivity);
}
