# Flagsmith Android SDK

![01](https://raw.githubusercontent.com/Flagsmith/flagsmith/main/static-files/hero.png)

## Flagsmith Android SDK

Flagsmith allows you to manage feature flags and remote config across multiple projects, environments and organisations.

The SDK for iOS and Swift applications for https://www.flagsmith.com/.

## Installation

### Gradle (app)

In path "{{root}}/app/build.gradle" add new dependence 

```

    //flagsmith
    implementation 'com.github.AbdallahAndroid:com.flagsmith.android:0.4.0'
   
```

### Gradle (Project)

In new gradle version 7+ write at file "settings.gradle"

```

    repositories {
        google()
        mavenCentral()

        maven { url "https://jitpack.io" }

    }
```

## Tutorial 

see full Android Tutorial Project https://github.com/AbdallahAndroid/Flagsmith_tutorial_android

### Android App Screens
<p align="left">
<img src="/screens/01.png" height="300"/>
<img src="/screens/02.png" height="300"/>
<img src="/screens/03.png" height="300"/>
<img src="/screens/04.png" height="300"/>
<img src="/screens/05.png" height="300"/>
<img src="/screens/06.png" height="300"/>
</p>

### Dashboard Flagsmith.com with Android Application
<img src="/screens/00.png" height="300"/>

## Basic Usage

The SDK is initialised against a single environment within a project on https://flagsmith.com, for example the Development or Production environment. You can find your Client-side Environment Key in the Environment settings page.


<img src="https://docs.flagsmith.com/assets/images/api-key-e495cbc55f0a0fcf19dabab16bd7507e.png" height="500"/>

## Initialization

 ### Create class "Helper" to set the constant key
 
 * This key generated from Dashboard Website
 * By default, the client uses a default configuration. You can override the configuration as follows Override just the default API URI with your own:
 
 ```
 
object Helper {

    var tokenApiKey: String = "b97c6f022fe7b736f7bcf6d99019337a7ff2f7d3"
    var environmentDevelopmentKey = "NaeCHAMjZtSmNudzhV9TWy"
    var identifierUserKey: String = "development_user_123456";
}
 ```
 
### Within your Activity inside "onCreate()" :

```
  lateinit var flagBuilder : FlagsmithBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
                
        initBuilder();
    }


    private fun initBuilder() {
        flagBuilder = FlagsmithBuilder.Builder()
            .tokenApi( Helper.tokenApiKey)
            .environmentId(Helper.environmentDevelopmentKey)
            .identifierUser( Helper.identifierUserKey)
            .build();
    }

```

## Flags

### Flag Object Data 

```
data class ResponseFlagElement (
    val id: Long,
    val feature: Feature,
    val featureStateValue: String,
    val environment: Long,
    val identity: Any? = null,
    val featureSegment: Any? = null,
    val enabled: Boolean
)

data class Feature (
    val id: Long,
    val name: String,
    val description: String,
    val type: String
)

```

### Now you are all set to retrieve feature flags from your project. For example to list and print all flags:

```
        //listener
        flagBuilder.getAllFlag(   object : IFlagArrayResult{
            override fun success(list: ArrayList<ResponseFlagElement>) {
            
            }

            override fun failed(str: String) {

            }
        });
```

### Check Flag key is found:

```

        flagBuilder.hasFeatureFlag( keyFlag, object  : IFeatureFoundChecker {
            override fun found() {
                 
            }

            override fun notFound() {
              
            }
        })
```

### Get Flag Object by featureId

To retrieve a config value by its name

```

        flagBuilder.getFeatureByIdAPi(   searchText, object  : IFlagSingle{
            override fun success(flag: ResponseFlagElement) {

            }

            override fun failed(str: String) {

            }
        });
```

### Create Tait by "keyTrait" and "valueTrait"

```
        flagBuilder.createTrait(  key, value, object  : ITraitUpdate {
            override fun success(response: ResponseTraitUpdate) {
            
            }

            override fun failed(str: String) {

            }
        })
```

### Get all Traits

To retrieve a trait for a particular identity [ ( See Traits ) ](https://docs.flagsmith.com/basic-features/managing-identities#identity-traits): 
```
        flagBuilder.getAllTrait(   object : ITraitArrayResult {
            override fun success(list: ArrayList<Trait>) {
 
            }

            override fun failed(str: String) {
 

            }
        })
```
