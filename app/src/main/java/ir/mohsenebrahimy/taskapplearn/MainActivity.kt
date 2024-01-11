package ir.mohsenebrahimy.taskapplearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.mohsenebrahimy.taskapplearn.mvp.model.ModelMainActivity
import ir.mohsenebrahimy.taskapplearn.mvp.presenter.PresenterMainActivity
import ir.mohsenebrahimy.taskapplearn.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: PresenterMainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ViewMainActivity(this)
        val model = ModelMainActivity(this)

        setContentView(view.binding.root)

        presenter = PresenterMainActivity(view, model)
        presenter.onCreate()
    }
}