package com.percula.viewpagerbug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import coil.api.load
import com.percula.viewpagerbug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create list of images
        val images = listOf(
            "https://placekitten.com/600/400",
            "https://placekitten.com/601/410",
            "https://placekitten.com/602/420",
            "https://placekitten.com/603/430",
            "https://placekitten.com/604/440",
            "https://placekitten.com/605/450"
        )
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.setImages(images)
        setContentView(binding.root)
    }
}

class ImageAdapter(override val items: List<String>): BaseAdapter<String>() {
    override fun getObjForPosition(position: Int): String  = items[position]
    override fun getLayoutIdForPosition(position: Int): Int = R.layout.component_image_page
    override fun getItemCount(): Int = items.size
}

@BindingAdapter("imageUrls")
fun ViewPager2.loadImages(imageUrls: List<String>?) {
    if (imageUrls != null) {
        adapter = ImageAdapter(imageUrls)
    }
}

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    if (url != null) {
        // Using Coil (images will appear but not be the correct width)
        load(url)

        // OR using Glide (nothing will appear)
//        Glide.with(context).load(url).into(this)
    }
}