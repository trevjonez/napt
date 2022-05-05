package com.slapin.napt.task

import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

abstract class CleanNaptTrigger : DefaultTask() {

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val javaDirectory: DirectoryProperty

    @TaskAction
    fun run() {
        val trigger = javaDirectory.get().file("NaptTrigger.java").asFile
        didWork = trigger.exists()
        if (trigger.exists()) trigger.delete()
    }
}