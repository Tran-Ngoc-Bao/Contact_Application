package com.example.contactapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data
        val idList = resources.getStringArray(R.array.idList)
        val nameList = resources.getStringArray(R.array.nameList)
        val emailList = resources.getStringArray(R.array.emailList)
        val phoneList = resources.getStringArray(R.array.phoneList)

        val lopAdapter = arrayListOf<Person>()
        for (i in 0..14) {
            lopAdapter.add(
                Person(
                    resources.getIdentifier(
                        "char_${nameList[i].lowercase()[0]}",
                        "mipmap",
                        "com.example.contactapplication"
                    ), idList[i], nameList[i], emailList[i], phoneList[i]
                )
            )
        }
        val list = view.findViewById<ListView>(R.id.list_person)
        list.adapter = ListOfPeople(lopAdapter)

        list.setOnItemClickListener { _, _, position, _ ->
            val identify = idList[position]
            val name = nameList[position]
            val email = emailList[position]
            val phone = phoneList[position]

            val bundle = Bundle()
            bundle.putString("identify", identify)
            bundle.putString("name", name)
            bundle.putString("email", email)
            bundle.putString("phone", phone)
            findNavController().navigate(R.id.action_listFragment_to_subFragment, bundle)
        }
    }
}