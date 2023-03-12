# SplashPlay

This is very basic app is to demonstrate how to implement splash screen in an android app without creating a new layout file.

* Concept is to create a spearate theme and set it as default in Android.Manifest.xml.
* Eventually make drawables available like icons, images, etc. 
* In **onCreate()** method, just before setting layout, change the theme from SplashTheme to the deafult theme created for layout using **setTheme(<theme_resource_id>)**. 