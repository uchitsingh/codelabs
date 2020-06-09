package com.example.codelabs.functions.annotations

import kotlin.reflect.full.*

@ImAPlant
class Plant {
    fun trim() {}
    fun fertilize() {}
}

fun testAnnotations() {
    val plantObj = Plant::class
    /*  for (m in plantObj.annotations) {
          println(m.annotationClass.simpleName)
      }*/
    val myAnnotationObject = plantObj.findAnnotation<ImAPlant>()
    println(myAnnotationObject)
}

fun labels() {
    outerLoop@ for (i in 1..100) {
        print("$i ")
        for (j in 1..100) {
            if (i > 10) break@outerLoop  // breaks to outer loop
        }
    }
}

fun main() {
    //testAnnotations()
    labels()
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

@ImAPlant
class Plant1 {
    @get:OnGet
    val isGrowing: Boolean = true

    @set: OnSet
    var needsFood: Boolean = false

}


