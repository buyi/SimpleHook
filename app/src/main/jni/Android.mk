LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= hookdemo

LOCAL_SRC_FILES := hook.cpp

LOCAL_LDLIBS+= 

LOCAL_CFLAGS    := -I./include/ -I./dalvik/vm/ -I./dalvik -DHAVE_LITTLE_ENDIAN

LOCAL_LDFLAGS	:=	-L./lib/  -L$(SYSROOT)/usr/lib -llog -ldvm -landroid_runtime  -lart


LOCAL_SHARED_LIBRARIES :=
include $(BUILD_SHARED_LIBRARY)

#------------------------------------------------------------------------

include $(CLEAR_VARS)

LOCAL_MODULE:= hookdemo2java

LOCAL_SRC_FILES := hookjava.cpp

LOCAL_LDLIBS+=

LOCAL_CFLAGS    := -I./include/ -I./dalvik/vm/ -I./dalvik -DHAVE_LITTLE_ENDIAN

LOCAL_LDFLAGS	:=	-L./lib/  -L$(SYSROOT)/usr/lib -llog -ldvm -landroid_runtime  -lart

include $(BUILD_SHARED_LIBRARY)
