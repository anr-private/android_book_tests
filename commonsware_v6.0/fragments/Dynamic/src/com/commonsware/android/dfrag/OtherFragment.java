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
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

// Extends ListFragment -- which uses a ListView as its GUI
// and so there is no XML for this fragment

// The ListView uses the ArrayAdapter to access the items
// list, which it uses to populate the on-screen list.
// The user can pick something from the list, but there
// is nothing registered to receive such an event...

// See <proj-root>/ANR_README/logcat_*.log for log captures.

public class OtherFragment extends ListFragment {


  private static final String[] items= { "lorem", "ipsum", "dolor",
      "sit", "amet", "consectetuer", "adipiscing", "elit", "morbi",
      "vel", "ligula", "vitae", "arcu", "aliquet", "mollis", "etiam",
      "vel", "erat", "placerat", "ante", "porttitor", "sodales",
      "pellentesque", "augue", "purus" };

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    setListAdapter(new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_1, items));
  }


    @Override
    public void onListItemClick(ListView lv, View v, int position, long id)
    {
        // lv is a ListView
        // v is a TextView
        // both position and id are 0..N-1

        L.i("ONLIST_ITEM_CLICK called. lv=" + lv);
        L.i("ONLIST_ITEM_CLICK called. view=" + v);
        if (v != null) {
            if (v instanceof TextView) {
                TextView tv = (TextView) v;
                L.i("ONLIST_ITEM_CLICK called. view.text=" + tv.getText());
            }
        }
        L.i("ONLIST_ITEM_CLICK called. pos=" + position);
        L.i("ONLIST_ITEM_CLICK called. id=" + id);
    }


  @Override
  public void onAttach(Activity a) {
    super.onAttach(a);
    L.d(getClass().getSimpleName()+" onAttach()");
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    L.d(getClass().getSimpleName()+" onCreate()");
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
