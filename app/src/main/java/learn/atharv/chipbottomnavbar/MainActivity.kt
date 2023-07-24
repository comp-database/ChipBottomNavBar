package learn.atharv.chipbottomnavbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import learn.atharv.chipbottomnavbar.databinding.ActivityMainBinding
// Step 1 : add the dependency in the build.gradle ->     implementation 'com.github.ismaeldivita:chip-navigation-bar:1.4.0'}
// Step 2 : add the ""maven { url 'https://jitpack.io' }"" in settings.gradle
// Step 3 : Create menu in res
// Step 4 : in layout file add the respective view from the dependency
// Step 5 : Follow the link for more info -> https://github.com/ismaeldivita/chip-navigation-bar
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTabBar()
    }
    private fun setUpTabBar() {
        // Instead of using single textView we can use fragment onClick
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it) {
                R.id.one -> binding.textMain.text = "Near"
                R.id.two -> binding.textMain.text = "Chat"
                R.id.three -> {
                    binding.textMain.text = "Profile"
                    binding.bottomNavBar.showBadge(R.id.four)
                }
                R.id.four -> {
                    binding.textMain.text = "Settings"
                    binding.bottomNavBar.dismissBadge(R.id.four)
                }
            }
        }
    }
}
