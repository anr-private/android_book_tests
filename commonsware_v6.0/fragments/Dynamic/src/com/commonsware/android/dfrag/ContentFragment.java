/***
  Copyright (c) 2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
  
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
 */

package com.commonsware.android.dfrag;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// See <proj-root>/ANR_README/logcat_*.log for log captures.

public class ContentFragment extends Fragment implements
    View.OnClickListener {

  @Override
  public View onCreateView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState) {
    View result=inflater.inflate(R.layout.mainfrag, container, false);

    result.findViewById(R.id.showOther).setOnClickListener(this);

    return(result);
  }

    // Handles the button click, forwards it to our Activity
  @Override
  public void onClick(View v) {

      ((DynamicFragmentsDemoActivity)getActivity()).showOther(v);
  }
  
  @Override
  public void onAttach(Activity a) {
    super.onAttach(a);
    L.d(getClass().getSimpleName() + " onAttach()");
  }
  
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    L.d(getClass().getSimpleName()+" onCreate()");
  }
  
  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    L.d(getClass().getSimpleName()+" onActivityCreated()");
  }

  @Override
  public void onStart() {
    super.onStart();
    L.d(getClass().getSimpleName()+" onStart()");
  }

  @Override
  public void onResume() {
    super.onResume();
    L.d(getClass().getSimpleName()+" onResume()");
  }

  @Override
  public void onPause() {
    L.d(getClass().getSimpleName()+" onPause()");
    super.onPause();
  }

  @Override
  public void onStop() {
    L.d(getClass().getSimpleName()+" onStop()");
    super.onStop();
  }

  @Override
  public void onDestroyView() {
    L.d(getClass().getSimpleName()+" onDestroyView()");
    super.onDestroyView();
  }

  @Override
  public void onDestroy() {
    L.d(getClass().getSimpleName()+" onDestroy()");
    super.onDestroy();
  }

  @Override
  public void onDetach() {
    L.d(getClass().getSimpleName()+" onDetach()");
    super.onDetach();
  }
}