![](https://raw.githubusercontent.com/ssseasonnn/IronBranch/master/ironbranch.png)

# IronBranch

[![](https://jitpack.io/v/ssseasonnn/IronBranch.svg)](https://jitpack.io/#ssseasonnn/IronBranch)

### How to use

Step 1. Add the JitPack repository to your build file
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```gradle
dependencies {
    // replace xyz to latest version number
	implementation 'com.github.ssseasonnn:IronBranch:xyz'
}
```

Step 3. Usage

Create io thread:
```kotlin
ioThread {
    //do some thing
    Log.d(TAG, Thread.currentThread().name)
}
```

Create single io thread:
```kotlin
singleIoThread {
    //do some thing
    Log.d(TAG, Thread.currentThread().name)
}
```

Switch main thread:
```kotlin
mainThread {
    //do some thing
    Log.d(TAG, Thread.currentThread().name)
}
```

Assert main thread:
```kotlin
assertMainThread { 
    //do some thing
}
```

Assert main thread with result:
```kotlin
assertMainThreadWithResult { 
    //do some thing
}
```

Ensure main thread:
```kotlin
ensureMainThread { 
    //do some thing    
}
```

### License

> ```
> Copyright 2019 Season.Zlc
>
> Licensed under the Apache License, Version 2.0 (the "License");
> you may not use this file except in compliance with the License.
> You may obtain a copy of the License at
>
>    http://www.apache.org/licenses/LICENSE-2.0
>
> Unless required by applicable law or agreed to in writing, software
> distributed under the License is distributed on an "AS IS" BASIS,
> WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
> See the License for the specific language governing permissions and
> limitations under the License.
> ```
