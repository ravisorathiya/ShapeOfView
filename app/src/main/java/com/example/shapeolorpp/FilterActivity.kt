package com.example.shapeolorpp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shapeolorpp.adapters.FilterAdapter
import com.example.shapeolorpp.databinding.ActivityFilterBinding
import com.example.shapeolorpp.models.Filter
import com.example.shapeolorpp.utills.Constanse
import com.example.shapeolorpp.utills.Filters
import com.example.shapeolorpp.utills.getBitmapFromView
import com.example.shapeolorpp.utills.toast
import ja.burhanrashid52.photoeditor.OnSaveBitmap
import ja.burhanrashid52.photoeditor.PhotoEditor
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext


private const val TAG = "FilterActivity"

class FilterActivity : AppCompatActivity(), FilterAdapter.OnSetFilter {

    private lateinit var binding: ActivityFilterBinding

    private lateinit var photoEditor: PhotoEditor
    private lateinit var imageURI: Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFilterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupPhotoEditor()
        setupFilterRecyclerView()

    }


    // get image from crop activity and set to photoeditor view for filter the image
    private fun setupPhotoEditor() {
        val data = intent.extras
        val uriString: String? = data?.getString(Constanse.IMAGE_URI)

        imageURI = Uri.parse(uriString)

        try {
            imageURI.let {
                if (Build.VERSION.SDK_INT < 28) {
                    val bitmap = MediaStore.Images.Media.getBitmap(
                        this.contentResolver,
                        it
                    )
                    binding.photoEditorView.source.setImageBitmap(bitmap)
                } else {
                    val source =
                        ImageDecoder.createSource(this.contentResolver, it)
                    val bitmap = ImageDecoder.decodeBitmap(source)
                    binding.photoEditorView.source.setImageBitmap(bitmap)

                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        photoEditor = PhotoEditor.Builder(this, binding.photoEditorView)
            .setPinchTextScalable(true)
            .build()
    }


    private fun setupFilterRecyclerView() {
        val filters = Filters.filtersList(imageURI, photoEditor)

        val filterAdapter = FilterAdapter(this, this)
        binding.rvFilter.apply {
            lifecycleScope.launchWhenCreated {
                withContext(IO) {
                    filterAdapter.submitList(filters)
                }
            }
            layoutManager =
                LinearLayoutManager(this@FilterActivity, LinearLayoutManager.HORIZONTAL, true)
            adapter = filterAdapter

        }
    }

    // set filter from filter-adapter items
    override fun setFilter(filter: Filter) {
        photoEditor.setFilterEffect(filter.filter)

        binding.textDone.setOnClickListener {

            photoEditor.saveAsBitmap(object : OnSaveBitmap {
                override fun onBitmapReady(saveBitmap: Bitmap?) {

                    val uri = getBitmapFromView(this@FilterActivity, saveBitmap)
                    val intent = Intent()
                    intent.putExtra(Constanse.FILTER_IMAGE, uri.toString())
                    setResult(Constanse.FILTER_IMAGE_CODE, intent)
                    finish()
                }

                override fun onFailure(e: Exception?) {
                    toast("${e?.message}")
                }
            })
        }
    }
}

