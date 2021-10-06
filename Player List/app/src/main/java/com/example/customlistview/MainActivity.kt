package com.example.customlistview

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.customlistview.databinding.ActivityMainBinding
import java.security.AccessControlContext

class MyAdapter(private val context: Activity,private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context,
                 R.layout.listitem,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.listitem,null)

        val image: ImageView = view.findViewById(R.id.profile_pic)
        val username: TextView = view.findViewById(R.id.personname)
        val country: TextView = view.findViewById(R.id.country)

        image.setImageResource(arrayList[position].Imageid)
        username.text = arrayList[position].name
        country.text = arrayList[position].country



        return view
    }


}

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.messi,R.drawable.ronaldo,R.drawable.neymar,R.drawable.lewandoski,R.drawable.mbappe

        )

        val name = arrayOf(
            "Lionel Messi", "Cristiano Ronaldo","Neymar Jr.","Robert Lewandoski", "Kylian Mbappe"
        )

        val country = arrayOf(

            "Argentina", "Portugal", "Brazil", "Poland", "France"
        )

        val pos = arrayOf(

            "Forward","Forward","Forward","Forward","Forward"
        )

        val club = arrayOf(

            "FC Barcelona","Juventus", "Paris-Saint German", "Bayern Munich","Paris-Saint German"
        )

        userArrayList = ArrayList()

        for(i in name.indices){

            val user = User(name[i],country[i],pos[i],club[i],imageId[i])
            userArrayList.add(user)
        }

        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val country = country[position]
            val pos = pos[position]
            val club = club[position]
            val imageId = imageId[position]

            val i = Intent(this,UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("country",country)
            i.putExtra("position",pos)
            i.putExtra("club",club)
            i.putExtra("imageId",imageId)
            startActivity(i)


        }

    }
}