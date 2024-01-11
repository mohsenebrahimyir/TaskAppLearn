package ir.mohsenebrahimy.taskapplearn.mvp.ext

import ir.mohsenebrahimy.taskapplearn.db.model.TaskEntity

interface OnBindData {
    fun saveData(taskEntity: TaskEntity) {}
    fun editData(taskEntity: TaskEntity) {}
    fun getData(taskEntity: List<TaskEntity>) {}
    fun deleteData(taskEntity: TaskEntity) {}
    fun requestData(state: Boolean) {}
}