package isfaaghyth.app.cleanarch.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by isfaaghyth on 1/9/18.
 * github: @isfaaghyth
 */

public class GlideAdapter {

    public static void load(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

}
