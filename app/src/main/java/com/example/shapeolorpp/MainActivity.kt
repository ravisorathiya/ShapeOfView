package com.example.shapeolorpp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.forEachIndexed
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.bumptech.glide.Glide
import com.example.shapeolorpp.databinding.ActivityMainBinding
import com.example.shapeolorpp.libs.sticker.*
import com.example.shapeolorpp.libs.stickerimages.StickerImageView
import com.example.shapeolorpp.ui.StickerFragment
import com.example.shapeolorpp.utills.Constanse
import com.github.siyamed.shapeimageview.RoundedImageView
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.frame_item.view.*


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), StickerFragment.setOnStickerListener {

    // view binding
    private lateinit var binding: ActivityMainBinding

    // widgets
    private lateinit var roundedImageView: RoundedImageView
    private lateinit var imageURI: Uri
    lateinit var textWishView: TextView

    // view for frame-layout
    private lateinit var framView: View
    private lateinit var frameLayout: FrameLayout

    // navigation components
    private lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration


    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupFrameLayout()
        moveTextAroundScreen()
        navHostSetup()
        setFilterImage()

    }

    private fun navHostSetup() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        // top level destination fragments ( not put action back arrow )
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fontStyleFragment,
                R.id.fontSizeChangeFragment,
                R.id.linearColorFragment,
                R.id.radialColorFragment,
                R.id.colorFragment
            )
        )
        binding.bootomNav.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    @RequiresApi(Build.VERSION_CODES.P)
    @SuppressLint("ClickableViewAccessibility")
    private fun moveTextAroundScreen() {
        val listener = View.OnTouchListener(function = { view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {
                view.x = motionEvent.rawX - view.width / 2.0f
                view.y = motionEvent.rawY - view.height / 0.5f
            }
            true
        })
        textWishView = framView.findViewById(R.id.text_wish)
        textWishView.setOnTouchListener(listener)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }


    private fun setupFrameLayout() {
        frameLayout = findViewById(R.id.fram_layout)
        framView = layoutInflater.inflate(
            R.layout.frame_item,
            frameLayout,
            false
        )
        frameLayout.addView(framView)

    }

    override fun setSticker(stickerRef: Int) {
        try {
            val stickerView = StickerImageView(this@MainActivity)
            stickerView.setImageDrawable(
                ContextCompat.getDrawable(
                    this, stickerRef
                )
            )
            binding.stickerView.addView(stickerView)

        } catch (e: Exception) {
            //  Log.d(TAG, "getImageFromCollection: error is ${e.message}")
        }
    }

    // click image dynamically without findViewById for each image
    private fun setFilterImage() {
        val root = framView
        if (root is ConstraintLayout) {
            root.forEachIndexed { index, view ->
                val id = resources.getResourceEntryName(view.id)
                val dynamicId = resources.getIdentifier(id, "id", packageName)
                if (view is RoundedImageView) {
                    view.setOnClickListener {
                        roundedImageView = findViewById(dynamicId)
                        cropImage()
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // crop a image and sent to filter activity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode === RESULT_OK) {

                val result = CropImage.getActivityResult(data)
                imageURI = result.uri
                val intent = Intent(this, FilterActivity::class.java)
                val bundle = Bundle()
                bundle.putString(Constanse.IMAGE_URI, imageURI.toString())
                intent.putExtras(bundle)
                startActivityForResult(intent, Constanse.FILTER_REQUEST_CODE)

            } else if (resultCode === CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }

        // set a filtered image in roundimageview
        if (resultCode == Constanse.FILTER_IMAGE_CODE) {
            if (requestCode == Constanse.FILTER_REQUEST_CODE && data != null) {

                val data = data.getStringExtra(Constanse.FILTER_IMAGE)
                imageURI = Uri.parse(data)
                Glide.with(this).load(imageURI).into(roundedImageView)
            }
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun cropImage() {
        CropImage.activity()
            .setGuidelines(CropImageView.Guidelines.ON)
            .start(this)
    }


}


