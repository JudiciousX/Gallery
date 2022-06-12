package acom.example.gallery

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson

class GalleryViewModel(application: Application) : AndroidViewModel(application) {
    private val _photoListView = MutableLiveData<List<PhotoItem>>()
    val photoListView : LiveData<List<PhotoItem>>
        get() = _photoListView

    fun fetchData() {
        val stringRequest = StringRequest (
            Request.Method.GET,
            getUrl(),
            {
                _photoListView.value = Gson().fromJson(it, Pixabay::class.java).hits.toList()
            },
            {
                Log.d("xxx", it.toString())
            }
            )
        VolleySingleton.getInstance(getApplication()).requestQueue.add(stringRequest)
    }

    private fun getUrl() : String {
        return "https://pixabay.com/api/?key=27988526-c638d1e729008b96d7d8f1466&q=${keyWords.random()}"
    }

    private val keyWords = arrayOf("cat","dog","car","beauty","phonr","computer","flower","animal")
}