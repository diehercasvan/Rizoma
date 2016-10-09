package DTO;

import android.app.Activity;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;

import com.sinapsis.rizoma.*;

import java.util.ArrayList;

import class_project.General;

/**
 * Created by DIEGO H CASALLAS on 5/10/2016.
 */

public class Load_Content_Page {

    private DTO_General dto_general = new DTO_General();
    private Activity activity = General.ACTIVITY;
    private ArrayList<Integer> images_id = new ArrayList<>();
    private ArrayList<Integer> images_signaling_id = new ArrayList<>();
    private ArrayList<String> textDescription = new ArrayList<>();
    private ArrayList<String> textTitle = new ArrayList<>();
    private ArrayList<DTO_General> listObject = new ArrayList<>();
    private Resources resources = activity.getResources();
    private int iSelectionPage = 0;

    public Load_Content_Page(int iSelectionPage) {

        this.iSelectionPage = iSelectionPage;
        loadObjectPage();
    }


    //Video               =1;
    //Image               =2;
    //lista Img + text    =3;
    //lista video         =4;

    private void loadObjectPage() {

        listObject.clear();
        switch (iSelectionPage) {
            case 0:
                General.iNUM_PAGE = 4;
                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.suelo);
                dto_general.setsTitle(resources.getString(R.string.titleSuelo));
                dto_general.setsDescription(resources.getString(R.string.Suelo));

                listObject.add(dto_general);

                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.fase1);
                dto_general.setsTitle(resources.getString(R.string.titlePhase1));
                dto_general.setsDescription(resources.getString(R.string.Fase1));
                dto_general.setiTypeView(3);
                listObject.add(dto_general);


                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.fase2);
                dto_general.setsTitle(resources.getString(R.string.titlePhase2));
                dto_general.setsDescription(resources.getString(R.string.Fase2));
                listObject.add(dto_general);


                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.fase3);
                dto_general.setsTitle(resources.getString(R.string.titlePhase3));
                dto_general.setsDescription(resources.getString(R.string.Fase3));
                listObject.add(dto_general);

                General.ARRAYLIST_DTO_GENERAL = listObject;

                break;
            case 1:

                General.iNUM_PAGE = 4;
                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.abono1);
                dto_general.setsTitle(resources.getString(R.string.fertilizers));
                dto_general.setsDescription(resources.getString(R.string.Abonos));
                listObject.add(dto_general);

                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.abono2);
                dto_general.setsTitle(resources.getString(R.string.fertilizers1));
                dto_general.setsDescription(resources.getString(R.string.Compostaje));
                dto_general.setiTypeView(3);
                listObject.add(dto_general);


                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.abono3);
                dto_general.setsTitle(resources.getString(R.string.fertilizers2));
                dto_general.setsDescription(resources.getString(R.string.Lombri_compost));
                listObject.add(dto_general);


                dto_general = new DTO_General();
                dto_general.setiUriImage(R.drawable.abono4);
                dto_general.setsTitle(resources.getString(R.string.fertilizers3));
                dto_general.setsDescription(resources.getString(R.string.Abono_foliar));
                listObject.add(dto_general);

                General.ARRAYLIST_DTO_GENERAL = listObject;

                break;
            case 2:


                images_id.add(R.drawable.plaga1);
                images_id.add(R.drawable.plaga2);
                images_id.add(R.drawable.plaga3);
                images_id.add(R.drawable.plaga4);
                images_id.add(R.drawable.plaga5);
                images_id.add(R.drawable.plaga6);
                images_id.add(R.drawable.plaga7);
                images_id.add(R.drawable.plaga8);
                images_id.add(R.drawable.plaga9);
                images_id.add(R.drawable.plaga10);
                images_id.add(R.drawable.plaga11);

                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);


                textDescription.add(activity.getResources().getString(R.string.plague1));
                textDescription.add(activity.getResources().getString(R.string.plague2));
                textDescription.add(activity.getResources().getString(R.string.plague3));
                textDescription.add(activity.getResources().getString(R.string.plague4));
                textDescription.add(activity.getResources().getString(R.string.plague5));
                textDescription.add(activity.getResources().getString(R.string.plague6));
                textDescription.add(activity.getResources().getString(R.string.plague7));
                textDescription.add(activity.getResources().getString(R.string.plague8));
                textDescription.add(activity.getResources().getString(R.string.plague9));
                textDescription.add(activity.getResources().getString(R.string.plague10));
                textDescription.add(activity.getResources().getString(R.string.plague11));

                String sTitles[] = activity.getResources().getStringArray(R.array.title);

                for (String sTitle : sTitles) {
                    textTitle.add(sTitle);
                }

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(false);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImages(images_id);
                dto_general.setiUriImagesSignal(images_signaling_id);
                dto_general.setsDescriptions(textDescription);
                dto_general.setsTitles(textTitle);
                General.DTO_GENERAL = dto_general;

                break;
            case 3:
                dto_general = new DTO_General();
                String sTitle[] = activity.getResources().getStringArray(R.array.glosario);
                String sTitleDes[] = activity.getResources().getStringArray(R.array.glosarioDescription);

                for (String text : sTitle) {
                    textTitle.add(text);
                }
                for (String text : sTitleDes) {
                    textDescription.add(text);
                }

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(false);
                dto_general.setsDescriptions(textDescription);
                dto_general.setsTitles(textTitle);
                General.DTO_GENERAL = dto_general;

                break;
            case 5:
                dto_general = new DTO_General();

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(true);
                dto_general.setsTextInfo(activity.getResources().getString(R.string.lorem_ipsum));
                dto_general.setiUriImage(R.drawable.basura);
                dto_general.setiUriImageSignal(R.drawable.logo_full);

                General.DTO_GENERAL = dto_general;

                break;
            case 6:
                dto_general = new DTO_General();

                images_id.add(R.drawable.diagrama1);
                images_id.add(R.drawable.diagrama2);
                images_id.add(R.drawable.diagrama3);
                images_id.add(R.drawable.diagrama4);
                images_id.add(R.drawable.diagrama5);


                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);
                images_signaling_id.add(R.drawable.logo_full);


                dto_general.setiUriVideo(R.raw.creditos);

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(false);
                dto_general.setiUriImages(images_id);
                dto_general.setiUriImagesSignal(images_signaling_id);
                General.DTO_GENERAL = dto_general;

                break;
            case 8:
                dto_general = new DTO_General();


                dto_general.setiUriVideo(R.raw.creditos);

                dto_general.setbImgIcon(false);
                dto_general.setbTextIcon(false);
                dto_general.setsDescriptions(textDescription);
                dto_general.setsTitles(textTitle);
                General.DTO_GENERAL = dto_general;

                break;
            case 9:
                break;
        }


    }
}
