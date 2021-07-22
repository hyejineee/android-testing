package com.example.android.architecture.blueprints.todoapp

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.Spec

class InstantExecutorListener : TestListener {
    override suspend fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        println("remove delegate")
        ArchTaskExecutor.getInstance().setDelegate(null)


    }

    override suspend fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)

        println("delegate")
        ArchTaskExecutor.getInstance().setDelegate(object : TaskExecutor() {
            override fun executeOnDiskIO(runnable: Runnable) = runnable.run()
            override fun postToMainThread(runnable: Runnable) = runnable.run()
            override fun isMainThread(): Boolean = true
        })
    }
}


