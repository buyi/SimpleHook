LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= hookdemo

LOCAL_SRC_FILES := demo1.cpp

LOCAL_LDLIBS+= 

LOCAL_CFLAGS    := -I./include/ -I./dalvik/vm/ -I./dalvik -DHAVE_LITTLE_ENDIAN

LOCAL_LDFLAGS	:=	-L./lib/  -L$(SYSROOT)/usr/lib -llog -ldvm -landroid_runtime  -lart

#LOCAL_STATIC_LIBRARIES := hookart

LOCAL_SHARED_LIBRARIES :=
include $(BUILD_SHARED_LIBRARY)
