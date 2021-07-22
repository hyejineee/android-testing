package com.example.android.architecture.blueprints.todoapp.tasks

import android.app.Application
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.InstantExecutorListener
import com.example.android.architecture.blueprints.todoapp.TodoApplication
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import io.kotest.extensions.robolectric.RobolectricTest
import io.kotest.matchers.shouldNotBe
import org.hamcrest.CoreMatchers.nullValue


@RobolectricTest
class TasksViewModelTest : DescribeSpec() {

    private var tasksViewModel: TasksViewModel? = null
    private val observer = Observer<Event<Unit>> {}

    override fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)
        val application = ApplicationProvider.getApplicationContext<Application>()
        tasksViewModel = TasksViewModel(application!!)
    }


    override fun afterEach(testCase: TestCase, result: TestResult) {
        super.afterEach(testCase, result)
        tasksViewModel?.newTaskEvent?.removeObserver(observer)
    }

    init {
        listener(InstantExecutorListener())

        describe("addNewTask()") {
            tasksViewModel?.newTaskEvent?.observeForever(observer)

            println("describe")

            context("새로운 작업이 추가되었을 떄") {
                tasksViewModel?.addNewTask()

                println("context")
                it("새로운 작업 화면을 여는 작업이 실행된다.") {

                    println("it")
                    val value = tasksViewModel?.newTaskEvent?.value
                    value?.getContentIfNotHandled() shouldNotBe nullValue()
                }
            }
        }
    }
}


