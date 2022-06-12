package acom.example.gallery

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestListener
import io.supercharge.shimmerlayout.ShimmerLayout

class GalleryAdapter(val item: List<PhotoItem>, val context: Context) : RecyclerView.Adapter<GalleryAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.imageView)
        val shimmer = view.findViewById<ShimmerLayout>(R.id.shimmerlayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.gallery_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.shimmer.apply {
            setShimmerColor(0x55ffffff)
            setShimmerAngle(0)
            startShimmerAnimation()
        }
        Glide.with(context)
            .load(item[position].previewUrl)
            .into(holder.image)
        Log.d("xxx",item[position].previewUrl)

    }

    override fun getItemCount(): Int {
       return item.size
    }

}

