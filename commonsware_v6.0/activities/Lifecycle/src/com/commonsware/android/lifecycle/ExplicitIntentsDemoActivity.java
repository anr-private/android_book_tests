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

package com.commonsware.android.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

// This is the main activity (see AndroidManifest.xml)

// To see the log files, use this filter in logcat:  ^.*Activity$
// which means
//   ^  start of line
//  .*  any seq of any chars
//  Activity  literal 'Activity'
//   $ end of line
// Ie matches lines that end with Activity.

public class ExplicitIntentsDemoActivity extends
    LifecycleLoggingActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      L.d("ExplicitIntents.onCreate returns");
  }

  public void showOther(View v) {

      Intent other=new Intent(this, OtherActivity.class);

      other.putExtra(OtherActivity.EXTRA_MESSAGE,
                   getString(R.string.other));

      L.d("ExplicitIntents.showOther Start the other activity");

      startActivity(other);
  }
}