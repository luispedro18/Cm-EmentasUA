package cm.ua.pt.ementasua;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    public static final String ARG_DATE = "date";
    public static final String ARG_NAME = "name";
    public static final String ARG_TYPE = "type";
    public static final String ARG_SOPA = "sopa";
    public static final String ARG_CARNE = "carne";
    public static final String ARG_PEIXE = "peixe";
    public static final String ARG_POSITION = "position";
    public static final String ARG_ENCERRADA = "encerrada";

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_details, container,
                false);
        Bundle args = getArguments();

        TextView textView_date = (TextView) rootView.findViewById(R.id.date_textView);
        textView_date.setText("Data: " + args.getString(ARG_DATE));
        TextView textView_name = (TextView) rootView.findViewById(R.id.name_textView);
        textView_name.setText("Cantina: " + args.getString(ARG_NAME));
        TextView textView_type = (TextView) rootView.findViewById(R.id.type_textView);
        textView_type.setText("Horário: " + args.getString(ARG_TYPE));
        TextView textView_sopa_title = (TextView) rootView.findViewById(R.id.sopa);
        TextView textView_pratoCarne_title = (TextView) rootView.findViewById(R.id.pratocarne);
        TextView textView_pratoPeixe_title = (TextView) rootView.findViewById(R.id.pratopeixe);
        ImageView imgView_sopa = (ImageView) rootView.findViewById(R.id.imageView_sopa);
        ImageView imgView_carne = (ImageView) rootView.findViewById(R.id.imageView_carne);
        ImageView imgView_peixe = (ImageView) rootView.findViewById(R.id.imageView_peixe);

        if(!args.getBoolean(ARG_ENCERRADA)) {
            textView_sopa_title.setVisibility(View.VISIBLE);
            textView_pratoCarne_title.setVisibility(View.VISIBLE);
            textView_pratoPeixe_title.setVisibility(View.VISIBLE);
            imgView_sopa.setVisibility(View.VISIBLE);
            imgView_carne.setVisibility(View.VISIBLE);
            imgView_peixe.setVisibility(View.VISIBLE);
            TextView textView_sopa = (TextView) rootView.findViewById(R.id.sopa_textView);
            textView_sopa.setText(args.getString(ARG_SOPA));
            TextView textView_pratoCarne = (TextView) rootView.findViewById(R.id.pratoCarne_textView);
            textView_pratoCarne.setText(args.getString(ARG_CARNE));
            TextView textView_pratoPeixe = (TextView) rootView.findViewById(R.id.pratoPeixe_textView);
            textView_pratoPeixe.setText(args.getString(ARG_PEIXE));
        }
        else{
            textView_sopa_title.setVisibility(View.INVISIBLE);
            textView_pratoCarne_title.setVisibility(View.INVISIBLE);
            textView_pratoPeixe_title.setVisibility(View.INVISIBLE);
            imgView_sopa.setVisibility(View.INVISIBLE);
            imgView_carne.setVisibility(View.INVISIBLE);
            imgView_peixe.setVisibility(View.INVISIBLE);
            TextView textView_cantina_encerrada = (TextView) rootView.findViewById(R.id.cantinaEncerrada_textView);
            textView_cantina_encerrada.setText("Cantina encerrada!");
        }


        // Inflate the layout for this fragment
        return rootView;
    }

}
