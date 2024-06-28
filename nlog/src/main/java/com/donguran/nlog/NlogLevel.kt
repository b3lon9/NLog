package com.donguran.nlog

/**
 * ditribute log level.
 *
 * [VERBOSE] use normal check,
 *
 * [INFORMATION] use you want to know instance or properties information,
 *
 * [DEBUG] use if you check purpose debug,
 * and do not want debug mode.
 *
 * [WARNING] use Exception or else condition in braket,
 *
 * [ERROR] use Exception.
 * */
internal enum class NlogLevel {
    VERBOSE,
    INFORMATION,
    DEBUG,
    WARNING,
    ERROR
}