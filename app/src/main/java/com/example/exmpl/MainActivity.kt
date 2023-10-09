package com.example.exmpl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.exmpl.Model.ChapterLists

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val userManager = UserManager(this)
        val mUser = userManager.getUserData()
        val userClass = mUser?.userClass
        val userName = mUser?.name

        val greet = findViewById<TextView>(R.id.greet)
        val showClass = findViewById<TextView>(R.id.showClass)

        greet.text = "Hi, $userName"
        showClass.text = "Class: $userClass"

        val chapterList = ChapterLists.getChaptersForClass(userClass)

        val chAdapter = ChapterAdapter(chapterList)
        val chRecyclerView = findViewById<RecyclerView>(R.id.chapterRecyclerView)
        (chRecyclerView.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
        chRecyclerView.layoutManager = LinearLayoutManager(this)
        chRecyclerView.adapter = chAdapter
        chRecyclerView.setHasFixedSize(true)

        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                chAdapter.filter(newText.orEmpty())
                return true
            }
        })
    }
}