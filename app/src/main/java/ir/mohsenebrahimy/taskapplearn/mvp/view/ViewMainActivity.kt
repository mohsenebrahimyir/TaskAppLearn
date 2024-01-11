package ir.mohsenebrahimy.taskapplearn.mvp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.mohsenebrahimy.taskapplearn.R
import ir.mohsenebrahimy.taskapplearn.adapter.RecyclerTaskAdapter
import ir.mohsenebrahimy.taskapplearn.databinding.ActivityMainBinding
import ir.mohsenebrahimy.taskapplearn.databinding.CustomDialogBinding
import ir.mohsenebrahimy.taskapplearn.db.model.TaskEntity
import ir.mohsenebrahimy.taskapplearn.mvp.ext.OnBindData

class ViewMainActivity(
    contextInstance: Context
) : FrameLayout(contextInstance) {
    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))

    private lateinit var adapter: RecyclerTaskAdapter
    fun initRecycler(tasks: ArrayList<TaskEntity>, onBindData: OnBindData) {
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        adapter = RecyclerTaskAdapter(tasks, onBindData)
        binding.recyclerView.adapter = adapter
    }

    fun showTask(tasks: List<TaskEntity>) {
        val data = arrayListOf<TaskEntity>()
        tasks.forEach { data.add(it) }
        adapter.dataUpdate(data)
    }

    fun setData(onBindData: OnBindData) {
        onBindData.requestData(false)

        binding.rdbTrue.setOnClickListener {
            onBindData.requestData(true)
        }

        binding.rdbFalse.setOnClickListener {
            onBindData.requestData(false)
        }
    }

    fun showDialog(onBindData: OnBindData) {
        binding.fab.setOnClickListener {
            val view = CustomDialogBinding.inflate(LayoutInflater.from(context))
            val dialog = Dialog(context)
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            view.btnCancel.setOnClickListener { dialog.dismiss() }
            view.btnSave.setOnClickListener {
                val text = view.edtTask.text.toString()
                if (text.isNotEmpty()) {
                    onBindData.saveData(TaskEntity(title = text, state = false))
                    Toast.makeText(
                        context,
                        resources.getString(R.string.success_edit_task),
                        Toast.LENGTH_SHORT
                    ).show()
                    dialog.dismiss()
                } else {
                    Toast.makeText(
                        context,
                        resources.getString(R.string.error_edit_task),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}