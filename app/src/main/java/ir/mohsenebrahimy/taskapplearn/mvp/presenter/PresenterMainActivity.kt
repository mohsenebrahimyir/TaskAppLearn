package ir.mohsenebrahimy.taskapplearn.mvp.presenter

import ir.mohsenebrahimy.taskapplearn.mvp.ext.BaseLifeCycle
import ir.mohsenebrahimy.taskapplearn.mvp.model.ModelMainActivity
import ir.mohsenebrahimy.taskapplearn.mvp.view.ViewMainActivity

class PresenterMainActivity(
    private val view: ViewMainActivity,
    private val model: ModelMainActivity
) : BaseLifeCycle {

    override fun onCreate() {

    }
}