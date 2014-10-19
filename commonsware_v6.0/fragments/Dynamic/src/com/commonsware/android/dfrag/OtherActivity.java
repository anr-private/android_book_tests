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

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

// See <proj-root>/ANR_README/logcat_*.log for log captures.

public class OtherActivity extends LifecycleLoggingActivity {

    /* Brief 'normal' version, uses Builder pattern to chain the calls that
     * create the FragmentManager and FragmentTransaction.
     * /
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {

            L.d(getClass().getSimpleName() + " onCreate: INFLATE the OtherFragment");

            L.d(getClass().getSimpleName() + " onCreate: INFLATE the OtherFragment");
            getFragmentManager().beginTransaction()
                                .add(android.R.id.content, new OtherFragment())
                                .commit();

            L.d(getClass().getSimpleName() + " onCreate: INFLATED ...  the OtherFragment");
        }
    }
    / * */


    /* Step-by-step logging version that logs each step of the transaction.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        if (getFragmentManager().findFragmentById(android.R.id.content) == null) {

            L.d(getClass().getSimpleName() + " onCreate: INFLATE the OtherFragment");

            L.d(getClass().getSimpleName() + " onCreate: INFLATE the OtherFragment: get frag mgr");

            FragmentManager fm = getFragmentManager();
            L.d(getClass().getSimpleName() + " onCreate: GOT FRAG MGR=" + fm);

            FragmentTransaction ft = fm.beginTransaction();
            L.d(getClass().getSimpleName() + " onCreate: GOT FRAG TRANSACTION=" + ft);

            L.d(getClass().getSimpleName() + " onCreate: ADD the OtherFragment to transaction");
            ft.add(android.R.id.content, new OtherFragment());

            L.d(getClass().getSimpleName() + " onCreate: COMMIT the fragment transaction");
            ft.commit();
            L.d(getClass().getSimpleName() + " onCreate: COMMIT completed");


            L.d(getClass().getSimpleName() + " onCreate: INFLATED ...  the OtherFragment");
        }
    }
    /* */



}

// ### end ###
