/***
  Copyright (c) 2012-2014 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain	a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
	
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
 */

package com.commonsware.android.rotation.frag;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RotationFragment extends Fragment implements
    View.OnClickListener {

  static final int PICK_REQUEST=1337;
  private Uri _contactUri = null;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                           Bundle savedInstanceState) {

      // IF YOU COMMENT THIS OUT, the fragment is re-create'd
      // on each orientation change -- and the value in
      // _contactUri is lost.
      setRetainInstance(true);

      View result=inflater.inflate(R.layout.main, parent, false);

      // Connect to the buttons on the layout

      // ORIG result.findViewById(R.id.pick).setOnClickListener(this);
      View pickBtn = result.findViewById(R.id.pick);
      pickBtn.setOnClickListener(this);

      View viewBtn = result.findViewById(R.id.view);
      viewBtn.setOnClickListener(this);

      // If a contact url string has been saved, enabled the view btn.
      viewBtn.setEnabled(_contactUri != null);


      return(result);
  }

  // Callback invoked by Contacts when user finishes a PICK_REQUEST
  @Override
  public void onActivityResult(int requestCode, int resultCode,
                               Intent data) {
    if (requestCode == PICK_REQUEST) {
      if (resultCode == Activity.RESULT_OK) {
        _contactUri = data.getData();
        getView().findViewById(R.id.view).setEnabled(true);
      }
    }
  }

  @Override
  public void onClick(View v) {
    if (v.getId() == R.id.pick) {
      _pickContact(v);
    } else {
      _viewContact(v);
    }
  }

  private void _pickContact(View v) {
    Intent i=
        new Intent(Intent.ACTION_PICK,
                   ContactsContract.Contacts.CONTENT_URI);

    startActivityForResult(i, PICK_REQUEST);
  }

  private void _viewContact(View v) {

      startActivity(new Intent(Intent.ACTION_VIEW, _contactUri));
  }
}
