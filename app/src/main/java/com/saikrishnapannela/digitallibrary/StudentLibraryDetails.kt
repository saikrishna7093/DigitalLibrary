package com.saikrishnapannela.digitallibrary

import android.content.Context



object StudentLibraryDetails {

    fun putStudentLS(context: Context, value: Boolean) {
        val studentStatus = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        val editor = studentStatus.edit()
        editor.putBoolean("STUDENT_STATUS", value).apply()
    }

    fun getStudentLS(context: Context): Boolean {
        val studentStatus = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        return studentStatus.getBoolean("STUDENT_STATUS", false)
    }

    fun putStudentMail(context: Context, value: String) {
        val studentMail = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        val editor = studentMail.edit()
        editor.putString("STUDENT_MAIL", value).apply()
    }

    fun getStudentMail(context: Context): String {
        val studentMail = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        return studentMail.getString("STUDENT_MAIL", "")!!
    }

    fun putStudentName(context: Context, value: String) {
        val studentName = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        val editor = studentName.edit()
        editor.putString("STUDENT_NAME", value).apply()
    }

    fun getStudentName(context: Context): String {
        val studentName = context.getSharedPreferences("LIBRARY_DETAILS", Context.MODE_PRIVATE)
        return studentName.getString("STUDENT_NAME", "")!!
    }

}