Commonsware projects from v6.0 of book


===  activities   ====

Explicit  - uses explicitly-specified class in Intent

Lifecycle - LifecycleLoggingActivity subclass shows
  the callbacks invoked during Activity lifecycle
  like onStart, onRestart, onStop, etc.


=== fragments  =====

Static - basic static Fragment

Dynamic - like Static but main frag is static,
  second (aka 'Other') frag is dynamic
  created using FragmentManager.


===  configchange    =====

Fragments - simple demo showing that a Fragment
  can be set to be 'retain'ed and so its
  state survivies across orientation changes.
  Project has 2 buttons, Pick and View, to 
  pick and view a Contact. The Contact's URI
  is retained in the Fragment's state.

Bundle - uses the savedInstanceState Bundle
  to save state (vs using a retained Fragment).
  This demo uses no Fragment, just an Activity.
  It shows the use of these callbacks:
    onSaveInstanceStateBundle
    onRestoreInstanceStateBundle
  It shows the same Pick/View buttons as Fragments
  demo to pick/view a Contact.

FragmentBundle - like Bundle and Fragment.
  Uses Pick/View buttons. Support orientation changes.
  While Bundle uses the bundle associated with the
  Activity, this demo uses the bundle associated
  with the fragment. Like the Activity-based version,
  the fragment uses the callbacks that save/restore
  the bundle:
    onSaveInstanceStateBundle
    onRestoreInstanceStateBundle
  NOTE that the state bundle does not survive the
  termination of the App's process. (You need to
  save the bundle's contents to a file or something
  similar like a database in order to get that 
  level of persistence.)


###

