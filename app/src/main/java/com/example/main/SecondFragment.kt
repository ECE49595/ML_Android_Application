package com.example.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.main.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment(){

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private var v: View? = null

    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner = view.findViewById<Spinner>(R.id.spTree)
        v = binding.root
        val tv = v?.findViewById<TextView>(R.id.treeNameTV)
        tv?.text = "testing"
        if (spinner != null) {
            val adapter = ArrayAdapter.createFromResource(this.requireContext(), R.array.arTrees, android.R.layout.simple_spinner_item).also {
                    adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
                @SuppressLint("Recycle")
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Components in fragment view
                    val treeName = binding.root.findViewById<TextView>(R.id.treeNameTV)
                    val latinTreeName = binding.root.findViewById<TextView>(R.id.treeNameLatinTV)
                    val treeInfo = binding.root.findViewById<TextView>(R.id.paragraphTreeInfoTV)
                    val treeImage = binding.root.findViewById<ImageView>(R.id.treeIV)
                    val indianaMap = binding.root.findViewById<ImageView>(R.id.indianaIV)
                    val worldMap = binding.root.findViewById<ImageView>(R.id.worldIV)
                    val treeImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView2)
                    val indianaImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView3)
                    val generalInfo = binding.root.findViewById<TextView>(R.id.generalInfoTV)

                    // Get String array for component text/image replacement
                    val trees = resources.getStringArray(R.array.arTrees)
                    val latinTrees = resources.getStringArray(R.array.arLatinTrees)

                    if (position == 0){
                            treeName?.visibility = View.INVISIBLE
                            latinTreeName?.visibility = View.INVISIBLE
                            treeInfo?.visibility = View.INVISIBLE
                            treeImage?.visibility = View.INVISIBLE
                            indianaMap?.visibility = View.INVISIBLE
                            worldMap?.visibility = View.INVISIBLE
                            treeImageBackground?.visibility = View.INVISIBLE
                            indianaImageBackground?.visibility = View.INVISIBLE
                            generalInfo?.visibility = View.INVISIBLE
                    }
                    else{
                            treeName?.visibility = View.VISIBLE
                            latinTreeName?.visibility = View.VISIBLE
                            treeInfo?.visibility = View.VISIBLE
                            treeImage?.visibility = View.VISIBLE
                            indianaMap?.visibility = View.VISIBLE
                            worldMap?.visibility = View.VISIBLE
                            treeImageBackground?.visibility = View.VISIBLE
                            indianaImageBackground?.visibility = View.VISIBLE
                            treeName?.text = trees[position]
                            latinTreeName?.text = latinTrees[position]
                            generalInfo?.visibility = View.VISIBLE

                    }
                    if (position == 1){
                        treeImage.setImageResource(R.drawable.sugar_maple)
                    } else if (position == 2){
                        treeImage.setImageResource(R.drawable.red_maple)
                    } else if (position == 3){
                        treeImage.setImageResource(R.drawable.black_cherry)
                    } else if (position == 4){
                        treeImage.setImageResource(R.drawable.white_ash)
                    } else if (position == 5) {
                        treeImage.setImageResource(R.drawable.yellow_poplar)
                    }
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}