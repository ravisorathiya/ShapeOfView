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
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.shapeolorpp.adapters.ViewpagerAdapter
import com.example.shapeolorpp.ui.*
import com.example.shapeolorpp.utills.Constanse
import com.github.siyamed.shapeimageview.RoundedImageView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {


    private lateinit var frameLayout: FrameLayout

    private lateinit var roundedImageView: RoundedImageView
    private lateinit var imageURI: Uri

    // view for frame-layout
    private lateinit var view: View

    private lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var textWishView: TextView


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFrameLayout()
        setupTabViewPager()

        moveTextAgroundScreen()

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
                R.id.radialColorFragment

            )
        )


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun moveTextAgroundScreen() {

        val listener = View.OnTouchListener(function = { view, motionEvent ->

            if (motionEvent.action == MotionEvent.ACTION_MOVE) {

                view.y = motionEvent.rawY - view.height / 2
                view.x = motionEvent.rawX - view.width / 2
            }

            true

        })
        textWishView = findViewById(R.id.text_wish)
        textWishView.setOnTouchListener(listener)

    }

    private fun setupTabViewPager() {


        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2Tab = findViewById<ViewPager2>(R.id.pager_activity)

        val fragmentList = arrayListOf(
            FontStyleFragment(),
            FontSizeChangeFragment(),
            LinearColorFragment(),
            RadialColorFragment()


        )


        val pagerAdapter = ViewpagerAdapter(
            fragmentList,
            supportFragmentManager,
            lifecycle
        )

        viewPager2Tab.adapter = pagerAdapter

        // to attaching with viewpager and add icons to tab
        TabLayoutMediator(tabLayout, viewPager2Tab) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_font)
                1 -> tab.setIcon(R.drawable.ic_textsize)
                2 -> tab.setIcon(R.drawable.ic_linear)
                3 -> tab.setIcon(R.drawable.ic_greadient)
            }
            viewPager2Tab.setCurrentItem(tab.position, true)
        }.attach()


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
        view = layoutInflater.inflate(
            R.layout.frame_item,
            frameLayout,
            false
        )

        val rootLayout = view
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

        frameLayout.addView(view)


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