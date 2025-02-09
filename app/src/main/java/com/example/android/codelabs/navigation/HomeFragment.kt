/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding


/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    private var _binding : HomeFragmentBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = HomeFragmentBinding.inflate(inflater,container,false)
        val view = binding.root
        return view

        //return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*        // Set an OnClickListener, using Navigation.createNavigateOnClickListener()
       val button = view.findViewById<Button>(R.id.navigate_destination_button)
       button?.setOnClickListener {
           //use the convenience method Navigation.createNavigateOnClickListener(@IdRes destId:
           // int, bundle: Bundle). This method will build an OnClickListener to navigate to the
           // given destination with a bundle of arguments to be passed to the destination.
           Navigation.createNavigateOnClickListener(R.id.flow_step_one_dest,null)
          // findNavController().navigate(R.id.flow_step_one_dest, null)
        }*/


        //Set NavOptions
        //pressing the Navigate To Destination button shows a custom transition animation.
        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        binding.navigateDestinationButton.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }

  /*      view.findViewById<Button>(R.id.navigate_destination_button)?.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }
*/

        // Update the OnClickListener to navigate using an action
        binding.navigateActionButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.next_action, null)
            )
      /*  view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )*/

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
