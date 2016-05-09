package com.example.mutti.interusp_android.Utils;

import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 01/05/16.
 */
public class SetListModalidade {

    public static int Drawable(String modalidade_id) {

        int drawable_id = 0;

        switch (Integer.parseInt(modalidade_id)) {
            case 1:
                drawable_id = R.drawable.modalidade_atletismo_fem;
                break;
            case 2:
                drawable_id = R.drawable.modalidade_atletismo;
                break;
            case 3:
                drawable_id = R.drawable.modalidade_basquete_fem;
                break;
            case 4:
                drawable_id = R.drawable.modalidade_basquete;
                break;
            case 5:
                drawable_id = R.drawable.modalidade_beisebol;
                break;
            case 6:
                drawable_id = R.drawable.modalidade_campo;
                break;
            case 7:
                drawable_id = R.drawable.modalidade_futsal_fem;
                break;
            case 8:
                drawable_id = R.drawable.modalidade_futsal;
                break;
            case 9:
                drawable_id = R.drawable.modalidade_handball_fem;
                break;
            case 10:
                drawable_id = R.drawable.modalidade_handball;
                break;
            case 11:
                drawable_id = R.drawable.modalidade_judo;
                break;
            case 12:
                drawable_id = R.drawable.modalidade_karate;
                break;
            case 13:
                drawable_id = R.drawable.modalidade_natacao_fem;
                break;
            case 14:
                drawable_id = R.drawable.modalidade_natacao;
                break;
            case 15:
                drawable_id = R.drawable.modalidade_polo;
                break;
            case 16:
                drawable_id = R.drawable.modalidade_rugby;
                break;
            case 17:
                drawable_id = R.drawable.modalidade_soft;
                break;
            case 18:
                drawable_id = R.drawable.modalidade_tenis_fem;
                break;
            case 19:
                drawable_id = R.drawable.modalidade_tenis;
                break;
            case 20:
                drawable_id = R.drawable.modalidade_tenismesa_fem;
                break;
            case 21:
                drawable_id = R.drawable.modalidade_tenismesa;
                break;
            case 22:
                drawable_id = R.drawable.modalidade_volei_fem;
                break;
            case 23:
                drawable_id = R.drawable.modalidade_volei;
                break;
            case 24:
                drawable_id = R.drawable.modalidade_xadrez;
                break;
            case 25:
                drawable_id = R.drawable.modalidade_rugby_fem;
                break;
            default:
                break;
        }

        return drawable_id;

    }


}
