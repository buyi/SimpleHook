# SimpleHook

大名鼎鼎的dexposed的原理代码。
大家可以实地体验下hook是怎么运行起来的。

原理说白了很简单

1.将要hook的方法改为native方法

2.并将其方法体替换成本地native方法 在本地native方法里做逻辑 或者 callback调用java层


Xposed做的更深入一层，直接侵入式劫持zygote，让其加载自有jar包，从而使所有app进程都能hook。这个自然需要root。



参考了这两篇文章 向作者表示感谢
http://www.zhaoxiaodan.com/android/Android-Hook(1)-dexposed%E5%8E%9F%E7%90%86.html
http://www.zhaoxiaodan.com/android/Android-Hook(2)-java2java.html