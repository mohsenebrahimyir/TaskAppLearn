package ir.mohsenebrahimy.taskapplearn.mvp.ext

interface BaseLifeCycle {

    fun onCreate ()

    fun onDestroy() {}

    fun onStop() {}
}