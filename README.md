# Proteus
A quick and simple way to paint your Drawables the color you want

# How it works
Proteus comes with a custom ImageView and an ImageButton. Simply use that in your XML files, and set the "app:paint" data as per your requirements. For example

    <in.raveesh.proteus.ImageView
       android:id="@+id/imageView"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:src="@drawable/ic_action_thumbs_up"
       app:paint="@android:color/black"/>

You could also do this from your Java code using either of the two functions

    imageView.setPaintResource(android.R.color.holo_blue_bright);

or

    imageView.setPaint(color);

While it doesn't natively support setting a colorized version of a Drawable as a View's background, you could use the following bit of code to get a colored Bitmap, which you can use anywhere as per your requirements.

    Bitmap bmp = Proteus.getColoredBitmap(Drawable src, int color);

# How to use it
Add the following lines to your build.gradle file

    repositories {
        maven { url "https://oss.sonatype.org/content/repositories/snapshots/" }
    }
    
    dependencies {
        compile 'in.raveesh:proteus:0.1.0-SNAPSHOT'
    }

# TODO
- Add documentation
- Clean up code
- ~~Add to Maven Central~~
- Add screenshots

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Proteus-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/1709)
