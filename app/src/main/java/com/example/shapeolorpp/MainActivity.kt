package com.example.shapeolorpp

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.shapeolorpp.databinding.ActivityMainBinding
import com.example.shapeolorpp.utills.Constanse
import com.github.siyamed.shapeimageview.RoundedImageView


class MainActivity : AppCompatActivity() {

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

        val rootLayout = framView
        if (rootLayout is ConstraintLayout) {

            rootLayout.forEach {
                val id = resources.getResourceEntryName(it.id)
                val dynamicId = resources.getIdentifier(id, "id", packageName)

                if (it is RoundedImageView) {
                    it.setOnClickListener {
                        roundedImageView = findViewById(dynamicId)
                        openGallery()
                    }
                }

            }

        }

        frameLayout.addView(framView)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == Constanse.IMAGE_CODE) {

            imageURI = data?.data!!
            try {
                imageURI.let {
                    if (Build.VERSION.SDK_INT < 28) {
                        val bitmap = MediaStore.Images.Media.getBitmap(
                            this.contentResolver,
                            imageURI
                        )
                        roundedImageView.setImageBitmap(bitmap)
                    } else {
                        val source =
                            ImageDecoder.createSource(this.contentResolver, imageURI)
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        roundedImageView.setImageBitmap(bitmap)

                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, Constanse.IMAGE_CODE)
    }

    companion object {
        private const val TAG = "MainActivity"
    }


}