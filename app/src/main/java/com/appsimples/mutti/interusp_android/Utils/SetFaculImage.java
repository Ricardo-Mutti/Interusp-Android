package com.appsimples.mutti.interusp_android.Utils;

import com.appsimples.mutti.interusp_android.R;

/**
 * Created by Mutti on 07/05/16.
 */
public class SetFaculImage {

    public static int Drawable(String facul_id){

        int drawable_id = 0;

        switch (facul_id) {
            case "1":
               drawable_id = R.drawable.icon_poli;
                break;
            case "2":
                drawable_id = R.drawable.icon_fea;
                break;
            case "3":
                drawable_id = R.drawable.icon_farma;
                break;
            case "4":
                drawable_id = R.drawable.icon_esalq;
                break;
            case "5":
                drawable_id = R.drawable.icon_riberao;
                break;
            case "6":
                drawable_id = R.drawable.icon_sanfran;
                break;
            case "7":
                drawable_id = R.drawable.icon_odonto;
                break;
            case "8":
                drawable_id = R.drawable.icon_pinheiros;
                break;
        }

        return drawable_id;
    }

}
