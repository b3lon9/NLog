package com.donguran.nlog

import android.util.Log

/**
 * @author neander of donguran
 * @since 2024-06-28
 *
 *
 * [NLog] class will be show
 * code occur location, class name, line number, print color
 *
 * this code architecture structure very simple.
 * I reference Exception class and android.util.log class.
 *
 * NLog's full name is Neander + Log :)
 *
 * Log result : [ClassName:lineNumber] message
 *
 * stackTrace first return value : com.donguran.nlog.NLog.v(NLog.kt:57).
 * stackTrace second return value : com.donguran.nlog.MainActivity.onCreate(MainActivity.kt:10)
 *
 * */
object NLog {
    // static code use this annotation @JvmStatic from Java
    // overload code use this annotation @JvmOverloads from Java

    /**
     * [tag] setting you want any TAG NAME.
     * if you don't want name. I wrote my nick name :)
     * */
    private var tag: String = "neander"

    /**
     * [isShow] property is control will show or dismiss logcat.
     * I recommand this property use debug mode.
     * */
    private var isShow: Boolean = true


    /**
     * [isPath] property is chase where this log occured full path.
     * return path + className.
     *
     * show log : [className(com.donguran.nlog.MainActivity):lineNumber] message
     * */
    private var isPath: Boolean = false

    /**
     * [isMethod] propery will be logcat console show method.
     *
     * if you use NLog library, and use [isMethod] setting parameter true.
     * you can see method name on logcat console.
     *
     * as) [className.methodName:lineNumber] message
     *
     * ex) [MainActivity.kt.onCreate:27] first commit
     * */
    private var isMethod: Boolean = false

    /**
     * show current tag name.
     *
     * now default tag name is 'neander'
     * */
    @JvmStatic
    fun getTagName(): String = tag

    /**
     * return [isShow] property boolean value.
     * if isShow propery is true. [isShowing] Function return true.
     * if isShow propery is flase. [isShowing] Function return false.
     * */
    @JvmStatic
    fun isShowing(): Boolean = isShow


    /**
     * you should not this function [configure].
     *
     * when this use? [configure] function is when app start point.
     * setting tag name[tag], when you want show debug so [isShow] setting Debug.
     * if you want see occur full path setting [isPath] parameter.
     * and if you want see method name. define true [isPath] parameter.
     *
     * @param tag logcat console's tag name. if you do not define this. will be show to 'neander'
     * @param isShow define NLog library's function output or dismiss
     * @param isPath visible to full path.
     * if [isPath] is true, [MainActivity.kt(com.donguran.nlog.MainActivity):lineNumber] message
     * if [isPath] is false, [MainActivity.kt:lineNumber] message
     * @param isMethod like [isPath] visible method name.
     * if [isMethod] is true, [className.methodName:lineNumber]
     * */
    @JvmOverloads
    @JvmStatic
    fun configure(tag: String, isShow: Boolean = true, isPath: Boolean = false, isMethod: Boolean = false) {
        this.tag = tag
        this.isShow = isShow
        this.isPath = isPath
        this.isMethod = isMethod
    }


    /**
     * @see [configure] overloads
     *
     * @param isShow define NLog library's function output or dismiss
     * */
    @JvmStatic
    fun configure(isShow: Boolean) {
        configure(tag = tag, isShow = isShow)
    }



    @JvmStatic
    fun v(message: String) {
        if (isShow) {
            val exception: Exception = Exception()
            val s = exception.stackTrace[1]

            output(message, s, level = NlogLevel.VERBOSE)
        }
    }

    @JvmStatic
    fun i(message: String) {
        if (isShow) {
            val exception: Exception = Exception()
            val s = exception.stackTrace[1]

            output(message, s, level = NlogLevel.INFORMATION)
        }
    }

    @JvmStatic
    fun d(message: String) {
        if (isShow) {
            val exception: Exception = Exception()
            val s = exception.stackTrace[1]

            output(message, s, level = NlogLevel.DEBUG)
        }
    }

    @JvmStatic
    fun w(message: String) {
        if (isShow) {
            val exception: Exception = Exception()
            val s = exception.stackTrace[1]

            output(message, s, level = NlogLevel.WARNING)
        }
    }

    @JvmStatic
    fun e(message: String) {
        if (isShow) {
            val exception: Exception = Exception()
            val s = exception.stackTrace[1]

            output(message, s, level = NlogLevel.ERROR)
        }
    }

    @JvmStatic
    private fun output(message: String, s: StackTraceElement, level: NlogLevel) {
        val absolutePath = if (isPath) "(${s.className})" else ""
        val className = s.fileName
        val lineNumber: Int = s.lineNumber
        val methodName = if (isMethod) ".${s.methodName}" else ""

        val combineMessage: String = "[$className$absolutePath$methodName:$lineNumber] $message"
        when (level) {
            NlogLevel.VERBOSE -> Log.v(tag, combineMessage)
            NlogLevel.INFORMATION -> Log.i(tag, combineMessage)
            NlogLevel.DEBUG -> Log.d(tag, combineMessage)
            NlogLevel.WARNING -> Log.w(tag, combineMessage)
            NlogLevel.ERROR -> Log.e(tag, combineMessage)
        }
    }
}