package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.test.core.app.ApplicationProvider
import io.kotest.core.spec.style.DescribeSpec
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class TasksViewModelTest : DescribeSpec({
    var tasksViewModel:TasksViewModel? = null

    @Before
    fun before(){
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    describe("addNewTask()"){
        context("새로운 작업이 추가되었을 떄"){
            tasksViewModel?.addNewTask()
            it("새로운 작업 화면을 여는 작업이 실행된다."){

            }
        }
    }
})
