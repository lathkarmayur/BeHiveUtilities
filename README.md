# BeHiveUtilities

[![](https://jitpack.io/v/saurabhYulu/BeHiveUtilities.svg)](https://jitpack.io/#saurabhYulu/BeHiveUtilities)

**Installation**

Add the Following to your gradle file.

***Add it in your root build.gradle at the end of repositories:***

```java
         allprojects {
            repositories {
              ...
              maven { url 'https://jitpack.io' }
            }
         }
```

***Add the dependency***

```java
          implementation 'com.github.saurabhYulu:BeHiveUtilities:v1.0'
```

## Network Signal Monitoring
1. Initilize 
``` java
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkDetector.getInstance().init(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        NetworkDetector.getInstance().deInit(this);
    }
}
```
2. Use any where in the app
``` java
NetworkDetector.getInstance().addObserver(...);
NetworkDetector.getInstance().removeObserver(...);
```
