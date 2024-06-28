remember this. example logcat console. <br/>

### code
```kotlin
Log.v(tag, "className:${s.className}")
Log.v(tag, "fileName:${s.fileName}")
Log.v(tag, "methodName:${s.methodName}")
```

### result(from logcat console)
```text
className:com.donguran.nlog.MainActivity
fileName:MainActivity.kt
methodName:onCreate
```