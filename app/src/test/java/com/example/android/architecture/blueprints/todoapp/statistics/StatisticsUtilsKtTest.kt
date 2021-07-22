package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class StatisticsUtilsKtTest:DescribeSpec({
    describe("getActiveAndCompletedStats()"){
        context("완료된 작업이 없고, 활성 작업이 1개 이상 있을 때 "){
            val tasks = listOf<Task>(
                Task("title", "todo", isCompleted = false),
                Task("title", "todo", isCompleted = false),
            )

            val result = getActiveAndCompletedStats(tasks)

            it("활성 작업의 비율은 100%이고 완료된 작업의 비율은 0%이다."){
                result.completedTasksPercent.shouldBe(0f)
                result.activeTasksPercent.shouldBe(100f)
            }
        }

        context("작업 리스트가 비어있을 때 "){
            val emptyTasks = emptyList<Task>()
            val result = getActiveAndCompletedStats(emptyTasks)

            it("활성 작업의 비율과 완료된 작업의 비율 모두 0%이다."){
                result.activeTasksPercent.shouldBe(0f)
                result.completedTasksPercent.shouldBe(0f)
            }
        }

        context("null값을 전달 했을 때"){
            val result = getActiveAndCompletedStats(null)
            it("활성 작업의 비율과 완료된 작업의 비율 모두 0%이다."){
                result.activeTasksPercent.shouldBe(0f)
                result.completedTasksPercent.shouldBe(0f)
            }
        }
    }
})

