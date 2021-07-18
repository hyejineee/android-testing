package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import com.example.android.architecture.blueprints.todoapp.Event
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldNotBe
import org.hamcrest.CoreMatchers.nullValue
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TasksViewModelTest : DescribeSpec({

    var instantExecutorRule = InstantTaskExecutorRule()

    var tasksViewModel:TasksViewModel? = null

    val observer = Observer<Event<Unit>> {}

    @Before
    fun before(){
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    afterEach {
        tasksViewModel?.newTaskEvent?.removeObserver(observer)
    }


    describe("addNewTask()"){
        tasksViewModel?.newTaskEvent?.observeForever(observer)

        context("새로운 작업이 추가되었을 떄"){
            tasksViewModel?.addNewTask()

            it("새로운 작업 화면을 여는 작업이 실행된다."){

                val value = tasksViewModel?.newTaskEvent?.value
                value?.getContentIfNotHandled() shouldNotBe nullValue()
            }
        }
    }
})
