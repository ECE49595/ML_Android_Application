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
//    public val spinner = R.id.spTree

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val treeName = binding.root.findViewById<TextView>(R.id.treeNameTV)
        val latinTreeName = binding.root.findViewById<TextView>(R.id.treeNameLatinTV)
        val treeInfo = binding.root.findViewById<TextView>(R.id.paragraphTreeInfoTV)
        val treeImage = binding.root.findViewById<ImageView>(R.id.treeIV)
        val worldImage = binding.root.findViewById<ImageView>(R.id.worldIV)
        val treeImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView2)
        val worldImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView3)
        val generalInfo = binding.root.findViewById<TextView>(R.id.generalInfoTV)
        treeName?.visibility = View.INVISIBLE
        latinTreeName?.visibility = View.INVISIBLE
        treeInfo?.visibility = View.INVISIBLE
        treeImage?.visibility = View.INVISIBLE
        worldImage?.visibility = View.INVISIBLE
        treeImageBackground?.visibility = View.INVISIBLE
        worldImageBackground?.visibility = View.INVISIBLE
        generalInfo?.visibility = View.INVISIBLE
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
                @SuppressLint("Recycle", "SetTextI18n")
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    // Components in fragment view
                    val treeName = binding.root.findViewById<TextView>(R.id.treeNameTV)
                    val latinTreeName = binding.root.findViewById<TextView>(R.id.treeNameLatinTV)
                    val treeInfo = binding.root.findViewById<TextView>(R.id.paragraphTreeInfoTV)
                    val treeImage = binding.root.findViewById<ImageView>(R.id.treeIV)
                    val worldImage = binding.root.findViewById<ImageView>(R.id.worldIV)
                    val treeImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView2)
                    val worldImageBackground = binding.root.findViewById<RecyclerView>(R.id.recyclerView3)
                    val generalInfo = binding.root.findViewById<TextView>(R.id.generalInfoTV)

                    // Get String array for component text/image replacement
                    val trees = resources.getStringArray(R.array.arTrees)
                    val latinTrees = resources.getStringArray(R.array.arLatinTrees)
                    val paragraph1 = resources.getStringArray(R.array.treeInformation1)
                    val paragraph2 = resources.getStringArray(R.array.treeInformation2)

                    if (position == 0){
                            treeName?.visibility = View.INVISIBLE
                            latinTreeName?.visibility = View.INVISIBLE
                            treeInfo?.visibility = View.INVISIBLE
                            treeImage?.visibility = View.INVISIBLE
                            worldImage?.visibility = View.INVISIBLE
                            treeImageBackground?.visibility = View.INVISIBLE
                            worldImageBackground?.visibility = View.INVISIBLE
                            generalInfo?.visibility = View.INVISIBLE
                    }
                    else{
                            treeName?.visibility = View.VISIBLE
                            latinTreeName?.visibility = View.VISIBLE
                            treeInfo?.visibility = View.VISIBLE
                            treeImage?.visibility = View.VISIBLE
                            worldImage?.visibility = View.VISIBLE
                            treeImageBackground?.visibility = View.VISIBLE
                            worldImageBackground?.visibility = View.VISIBLE
                            treeName?.text = trees[position]
                            latinTreeName?.text = latinTrees[position]
                            generalInfo?.visibility = View.VISIBLE
                            treeInfo?.text = paragraph1[position] + " \n\n" + paragraph2[position]
                    }

                    if (position == 1){
                        treeImage.setImageResource(R.drawable.sugar_maple)
                        worldImage.setImageResource(R.drawable.sugar_maple_world)
                    } else if (position == 2){
                        treeImage.setImageResource(R.drawable.red_maple)
                        worldImage.setImageResource(R.drawable.red_maple_world)
                    } else if (position == 3){
                        treeImage.setImageResource(R.drawable.black_cherry)
                        worldImage.setImageResource(R.drawable.black_cherry_world)
                    } else if (position == 4){
                        treeImage.setImageResource(R.drawable.black_walnut)
                        worldImage.setImageResource(R.drawable.black_walnut_world)
                    } else if (position == 5) {
                        treeImage.setImageResource(R.drawable.eastern_red_cedar)
                        worldImage.setImageResource(R.drawable.eastern_red_cedar_world)
                    } else if (position == 6) {
                        treeImage.setImageResource(R.drawable.white_ash)
                        worldImage.setImageResource(R.drawable.white_ash_world)
                    } else if (position == 7) {
                        treeImage.setImageResource(R.drawable.eastern_redbud)
                        worldImage.setImageResource(R.drawable.eastern_redbud_world)
                    } else if (position == 8) {
                        treeImage.setImageResource(R.drawable.yellow_poplar)
                        worldImage.setImageResource(R.drawable.yellow_poplar_world)
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