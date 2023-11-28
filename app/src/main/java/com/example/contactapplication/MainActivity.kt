package com.example.contactapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var idList: Array<String>
    private lateinit var nameList: Array<String>
    private lateinit var emailList: Array<String>
    private lateinit var phoneList: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addPerson = AddPerson()
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_add, addPerson)
            .add(R.id.fragment_list, listFragment).commit()
//
//        // Data
//        idList = resources.getStringArray(R.array.idList)
//        nameList = resources.getStringArray(R.array.nameList)
//        emailList = resources.getStringArray(R.array.emailList)
//        phoneList = resources.getStringArray(R.array.phoneList)
//
//        val lopAdapter = arrayListOf<Person>()
//        for (i in 0..14) {
//            lopAdapter.add(
//                Person(
//                    resources.getIdentifier(
//                        "char_${nameList[i].lowercase()[0]}", "mipmap", packageName
//                    ), idList[i], nameList[i], emailList[i], phoneList[i]
//                )
//            )
//        }
//        val list = findViewById<ListView>(R.id.list)
//        list.adapter = ListOfPeople(lopAdapter)
//
//        list.setOnItemClickListener { _, _, i, _ ->
//            val intent = Intent(this, SubActivity::class.java)
//            intent.putExtra("identify", idList[i])
//            intent.putExtra("name", nameList[i])
//            intent.putExtra("email", emailList[i])
//            intent.putExtra("phone", phoneList[i])
//            startActivity(intent)
//        }
//
//        registerForContextMenu(list)
    }

//    override fun onCreateContextMenu(
//        menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        menuInflater.inflate(R.menu.my_menu, menu)
//    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        val pos = (item.menuInfo as AdapterView.AdapterContextMenuInfo).position
//        when (item.itemId) {
//            R.id.call -> {
//                val intent = Intent(Intent.ACTION_DIAL)
//                intent.data = Uri.parse("tel:${phoneList[pos]}")
//                startActivity(intent)
//            }
//
//            R.id.send_sms -> {
//                val intent = Intent(Intent.ACTION_SENDTO)
//                intent.data = Uri.parse("smsto:${phoneList[pos]}")
//                intent.putExtra("sms_body", "Hello ${nameList[pos]}!")
//                startActivity(intent)
//            }
//
//            R.id.send_email -> {
//                val intent = Intent(Intent.ACTION_SEND)
//                intent.type = "text/plain"
//                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("${emailList[pos]}"))
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Three Kingdoms")
//                intent.putExtra(Intent.EXTRA_TEXT, "Dear ${nameList[pos]}!")
//                startActivity(intent)
//            }
//        }
//        return super.onContextItemSelected(item)
//    }
}

data class Person(
    val imageResource: Int, val id: String, val name: String, val phone: String, val email: String
)

class ListOfPeople(private val list: ArrayList<Person>) : BaseAdapter() {
    override fun getCount(): Int = list.size
    override fun getItem(p0: Int): Any = list[p0]
    override fun getItemId(p0: Int): Long = p0.toLong()
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val col: View = LayoutInflater.from(p2?.context).inflate(R.layout.person, p2, false)

        val image = col.findViewById<ImageView>(R.id.avatar)
        val name = col.findViewById<TextView>(R.id.name)

        image.setImageResource(list[p0].imageResource)
        name.text = list[p0].name

        return col
    }
}