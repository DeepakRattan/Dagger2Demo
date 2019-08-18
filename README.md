# What is Android Dependency Injection?

You don’t create objects yourself, you let someone else create them for you.

Let’s analyze what the above statement means.

Imagine the following scenario: We have an Activity and we wish to save some data in the SharedPreferences. Doing this without DI would lead us to instantiate, saving, retrieving data from the SharedPreferences, all within the Activity’s boilerplate code. Something that the below illustration more or less portrays to an extent.


![android-no-di-illustration](https://user-images.githubusercontent.com/15645007/63225898-5d6aba00-c1f3-11e9-9f05-ed3ad336deac.png)

The above approach can lead to some serious issues especially when your codebase increases in size.

You’ll have issues with unit testing, too much boilerplate code, difficulties in modifying your current codebase with so many instances to keep an eye on (shared instances, scoped instances). This is where Android Dependency Injection Pattern can give a major boost to your code.

As mentioned in the dependency and with the following illustration, instead of instantiating the SharedPreferences in our Activity every time, we’d let it be injected from another class.

![android-di-illustration](https://user-images.githubusercontent.com/15645007/63225935-da962f00-c1f3-11e9-9877-70a35e1ac448.png)

So our Activity is dependent on the SharedPreferences. Thus SharedPreferences acts as a dependency for our Activity. SharedPreferences gets injected into our Activity from the outside instead of getting instantiated.

# Why use Android Dependency Injection?

Instead of instantiating SharedPreferences, Databases, Network Libraries in our Activity each time, we’ll prefer to have instances of them created somewhere else and inject them in our Activity when it’s needed.

# What is Dagger 2?

Dagger 2 is a compile-time android dependency injection framework.

Following are the basic annotations used in Dagger 2:

    @Module : This is used on the class that does the work of constructing objects that’ll be eventually provided as dependencies.
    @Provides : This is used on the methods inside the Module class that’ll return the object.
    @Inject : This is used upon a constructor, field or a method and indicates that dependency has been requested.
    @Component : The Module class doesn’t provide the dependency directly to the class that’s requesting it. For this, a Component interface is used that acts as a bridge between @Module and @Inject.
    @Singleton : This indicates that only a single instance of the dependency object would be created.
    
    My application consists of a Single Activity wherein we’ll save and retrieve the data from our EditTexts into our SharedPreferences.
    
    Let’s analyze how we’ll use Dagger and the above-mentioned annotations to bring in the power of Dependency Injection in our application.
    
   ![android-dagger2-workflow](https://user-images.githubusercontent.com/15645007/63225938-df5ae300-c1f3-11e9-9ab6-cc841e1363e5.png)
   
   To instantiate the SharedPreferences instance in another class, we need to pass the current context.
The Component does the work of passing the stuff to the Module class and Injects the dependency in our Activity.

# Dagger 2 Dependencies
    implementation 'com.google.dagger:dagger-android:2.20'
    implementation 'com.google.dagger:dagger-android-support:2.20'
    // if you use the support libraries
    annotationProcessor 'com.google.dagger:dagger-android-processor:2.20'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.20'

Source : https://www.journaldev.com/16758/android-dependeny-injection-dagger
