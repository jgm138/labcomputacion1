package co.edu.udea.compumovil.gr03_20182.lab1;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.net.Uri;

public class FoodsActivity extends AppCompatActivity {

    ImageView imagenComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);
        imagenComida = (ImageView) findViewById(R.id.imageComida);
    }

    public void onClickImage(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), 10);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(resultCode == RESULT_OK) {
            Uri path = data.getData();
            imagenComida.setImageURI(path);
        }
    }
}
