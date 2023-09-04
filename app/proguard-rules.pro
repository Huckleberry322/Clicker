-keepattributes Annotation, InnerClasses

-keep,includedescriptorclasses class com.cleverside.crossword.**$$serializer { *; }

-keepclassmembers enum * { *; }

-keep class * extends com.google.protobuf.GeneratedMessageLite { *; }

-keepattributes Signature, InnerClasses, EnclosingMethod

-keepattributes RuntimeVisibleAnnotations, RuntimeVisibleParameterAnnotations

-keepattributes AnnotationDefault

-dontwarn javax.annotation.**

-dontwarn kotlin.Unit

-keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation

-dontwarn javax.annotation.**

-adaptresourcefilenames okhttp3/internal/publicsuffix/PublicSuffixDatabase.gz

-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt and other security providers are available.
# AGP 8.0 bug
-dontwarn okhttp3.internal.platform.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**

-keep,allowobfuscation,allowshrinking interface retrofit2.Call
-keep,allowobfuscation,allowshrinking class retrofit2.Response

-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**