package com.example.racipeapp.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.racipeapp.Databases.AppDatabase
import com.example.racipeapp.Adapters.CategoryAdapter
import com.example.racipeapp.Recipe
import com.example.racipeapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    
    private lateinit var rvAdapter: CategoryAdapter
    private lateinit var dataList: ArrayList<Recipe>
    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra("TITTLE")

        binding.tittle.text = title

        setUpRecyclerView()

        binding.goBackHome.setOnClickListener{
            finish()
        }

    }

    private fun setUpRecyclerView(){
        dataList = ArrayList()

        binding.rvCategory.layoutManager = LinearLayoutManager(this)

        var db = Room.databaseBuilder(this@CategoryActivity, AppDatabase::class.java,"db_name")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .createFromAsset("recipe.db")
            .build()
        var daoObject = db.getDao()
        var recipes = daoObject.getall()
        for(i in recipes!!.indices)
        {
            if(recipes[i]!!.category.contains(intent.getStringExtra("CATEGORY")!!))
            {
                dataList.add(recipes[i]!!)
            }
            rvAdapter = CategoryAdapter(dataList,this)
            binding.rvCategory.adapter = rvAdapter
        }
    }


}