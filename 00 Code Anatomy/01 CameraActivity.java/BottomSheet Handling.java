// https://stackoverflow.com/questions/61424482/java-spring-what-is-from-used-with-example
// https://stackoverflow.com/questions/62082132/detail-explanation-of-all-states-in-bottomsheetbehavior-android

/* BottomSheetBehavior

com.google.android.material.bottomsheet.BottomSheetBehavior<V extends View> 
public BottomSheetBehavior(@NonNull android.content.Context context,
                           android.util.AttributeSet attrs)
                                                      
An interaction behavior plugin for a child view of CoordinatorLayout to make it work as a bottom sheet.
To send useful accessibility events, set a title on bottom sheets that are windows or are window-like. 
For BottomSheetDialog use AppCompatDialog.setTitle(int), 
and for BottomSheetDialogFragment use ViewCompat.setAccessibilityPaneTitle(View, CharSequence).
*/

import com.google.android.material.bottomsheet.BottomSheetBehavior;

private LinearLayout bottomSheetLayout;
private BottomSheetBehavior<LinearLayout> sheetBehavior;


sheetBehavior = BottomSheetBehavior.from(bottomSheetLayout);

   ViewTreeObserver vto = gestureLayout.getViewTreeObserver();
    vto.addOnGlobalLayoutListener(
        new ViewTreeObserver.OnGlobalLayoutListener() {
          @Override
          public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
              gestureLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            } else {
              gestureLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            //                int width = bottomSheetLayout.getMeasuredWidth();
            int height = gestureLayout.getMeasuredHeight();

            sheetBehavior.setPeekHeight(height);
          }
        });
    sheetBehavior.setHideable(false);

    sheetBehavior.setBottomSheetCallback(
        new BottomSheetBehavior.BottomSheetCallback() {
          @Override
          public void onStateChanged(@NonNull View bottomSheet, int newState) {
            switch (newState) {
              case BottomSheetBehavior.STATE_HIDDEN:
                break;
              case BottomSheetBehavior.STATE_EXPANDED:
                {
                  bottomSheetArrowImageView.setImageResource(R.drawable.icn_chevron_down);
                }
                break;
              case BottomSheetBehavior.STATE_COLLAPSED:
                {
                  bottomSheetArrowImageView.setImageResource(R.drawable.icn_chevron_up);
                }
                break;
              case BottomSheetBehavior.STATE_DRAGGING:
                break;
              case BottomSheetBehavior.STATE_SETTLING:
                bottomSheetArrowImageView.setImageResource(R.drawable.icn_chevron_up);
                break;
            }
          }

          @Override
          public void onSlide(@NonNull View bottomSheet, float slideOffset) {}
        });
