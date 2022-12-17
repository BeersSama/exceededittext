# Exceed Edittext

[![](https://www.jitpack.io/v/BeersSama/exceededittext.svg)](https://jitpack.io/#BeersSama/exceededittext)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

A simple way to limit the number of input value characters, using Paint() in combination with onDraw(),
to create a background in the Edittext, this fixed the cursor loss on the BackgroundSpan

#### [ExceedEdittext](./exceededittext/src/main/java/com/beerus/exceededittext/widgets/ExceedEdittext.kt)

Used to define how to format the text.

#### With Widget

```
<com.beerus.exceededittext.wigets.ExceedEdittext
        android:id="@+id/edtExceed"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:maxLines="7"
        app:highLightColor="@color/colorHighlightExceed"
        app:maxCharacter="5"
        tools:text="Lorem Ipsum is simply dummy text of the printing and typesetting industry." />
```

Other params in Widget
``` 
    highLightColor: Background exceed of edittext
    maxCharacter: Limit char count of edittext.
```

To get the result:
```
edtExceed.doAfterTextChanged {
    // do some thing by kotlin ext.
}
```

## Dependencies

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

```
dependencies {
    implementation 'com.github.BeersSama:exceededittext:1.0.0'
}
```

## License

```
Copyright 2022 Beerus

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```