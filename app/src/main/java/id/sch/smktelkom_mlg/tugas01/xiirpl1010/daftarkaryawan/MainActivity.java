package id.sch.smktelkom_mlg.tugas01.xiirpl1010.daftarkaryawan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

import id.sch.smktelkom_mlg.tugas01.xiirpl1010.daftarkaryawan.adapter.KotaAdapter;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama, etDate, etAlamat;
    DatePickerDialog datePickerDialog;
    RadioButton rbLK, rbP;
    RadioGroup rgKelamin;
    Spinner spProvinsi, spKota, spAgama, spPendidikan;
    CheckBox cbPEM, cbJAR, cbDES, cbANI;
    Button bProses, bTGL;
    TextView tvHasil;
    LinearLayout lldaftar, llberhasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etDate = (EditText) findViewById(R.id.editTextDate);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbP = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        rgKelamin = (RadioGroup) findViewById(R.id.radioGroupJnsKelamin);
        lldaftar = (LinearLayout) findViewById(R.id.LinearLayoutDaftar);
        llberhasil = (LinearLayout) findViewById(R.id.LinearLayoutBerhasil);


        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        spKota = (Spinner) findViewById(R.id.spinnerKota);
        spAgama = (Spinner) findViewById(R.id.spinnerAgama);
        spPendidikan = (Spinner) findViewById(R.id.spinnerPendidikan);

        cbPEM = (CheckBox) findViewById(R.id.checkBoxPEM);
        cbJAR = (CheckBox) findViewById(R.id.checkBoxJAR);
        cbDES = (CheckBox) findViewById(R.id.checkBoxDES);
        cbANI = (CheckBox) findViewById(R.id.checkBoxANI);

        cbPEM.setOnCheckedChangeListener(this);
        cbJAR.setOnCheckedChangeListener(this);
        cbDES.setOnCheckedChangeListener(this);
        cbANI.setOnCheckedChangeListener(this);

        bProses = (Button) findViewById(R.id.buttonProses);
        bTGL = (Button) findViewById(R.id.buttonTGL);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        final String[][] arKota = {{"Jakarta Barat", "Jakarta Pusat", "Jakarta Selatan",
                "Jakarta Timur", "Jakarta Utara"},
                {"Bandung", "Cirebon", "Bekasi"}, {"Semarang",
                "Magelang", "Surakarta"},
                {"Surabaya", "Malang", "Blitar"}, {"Denpasar"}};
        final ArrayList<String> listKota = new ArrayList<>();
        final KotaAdapter adapter;

        adapter = new KotaAdapter(this, listKota);
        spKota.setAdapter(adapter);

        spProvinsi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKota.clear();
                listKota.addAll(Arrays.asList(arKota[pos]));
                adapter.setProvinsi((String) spProvinsi.getItemAtPosition(pos));
                adapter.notifyDataSetChanged();
                spKota.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        bTGL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                etDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }
        });

        findViewById(R.id.checkBoxPEM).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbPEM.setError(null);
                cbDES.setError(null);
                cbJAR.setError(null);
                cbANI.setError(null);
            }
        });

        findViewById(R.id.checkBoxDES).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbPEM.setError(null);
                cbDES.setError(null);
                cbJAR.setError(null);
                cbANI.setError(null);
            }
        });

        findViewById(R.id.checkBoxJAR).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbPEM.setError(null);
                cbDES.setError(null);
                cbJAR.setError(null);
                cbANI.setError(null);
            }
        });

        findViewById(R.id.checkBoxANI).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbPEM.setError(null);
                cbDES.setError(null);
                cbJAR.setError(null);
                cbANI.setError(null);
            }
        });

        findViewById(R.id.radioButtonLaki).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbLK.setError(null);
                rbP.setError(null);
            }
        });

        findViewById(R.id.radioButtonPerempuan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbLK.setError(null);
                rbP.setError(null);
            }
        });


        findViewById(R.id.buttonProses).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
                lldaftar.setVisibility(View.VISIBLE);
                lldaftar.setFocusableInTouchMode(true);
                lldaftar.requestFocus();
            }
        });

        findViewById(R.id.buttonDaftar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llberhasil.setVisibility(View.VISIBLE);
                llberhasil.setFocusableInTouchMode(true);
                llberhasil.requestFocus();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }

    private void doClick() {

        if (Validasi()) {
            StringBuilder builder = new StringBuilder();
            builder.append("Laporan Pengisian Data.");
            builder.append("\n\n");

            builder.append("Name : ");
            builder.append(etNama.getText().toString());
            builder.append("\n\n");

            builder.append("Tanggal Lahir : ");
            builder.append(etDate.getText().toString());
            builder.append("\n\n");

            builder.append("Agama : ");
            builder.append(spAgama.getSelectedItem().toString());
            builder.append("\n\n");

            builder.append("Asal Daerah : ");
            builder.append(spProvinsi.getSelectedItem().toString());
            builder.append(", Kota ");
            builder.append(spKota.getSelectedItem().toString());
            builder.append("\n\n");

            builder.append("Alamat Lengkap : ");
            builder.append(etAlamat.getText().toString());
            builder.append("\n\n");

            String hasil = null;

            if (rgKelamin.getCheckedRadioButtonId() != -1) {
                RadioButton rb = (RadioButton)
                        findViewById(rgKelamin.getCheckedRadioButtonId());
                hasil = rb.getText().toString();
            }

            if (hasil == null) {
                builder.append("Jenis kelamin belum dipilih");
            } else {
                builder.append("Jenis Kelamin  : " + hasil);
            }
            builder.append("\n\n");

            builder.append("Pendidikan Terakhir : ");
            builder.append(spPendidikan.getSelectedItem().toString());
            builder.append("\n\n");

            builder.append("Keterampilan   : ");
            builder.append("\n");
            int startlen = builder.length();
            if (cbPEM.isChecked()) builder.append(cbPEM.getText()).append("\n");
            if (cbJAR.isChecked()) builder.append(cbJAR.getText()).append("\n");
            if (cbDES.isChecked()) builder.append(cbDES.getText()).append("\n");
            if (cbANI.isChecked()) builder.append(cbANI.getText()).append("\n");

            if (builder.length() == startlen) builder.append("Tidak ada pada pilihan");

            tvHasil.setText(builder);
        }

    }

    private boolean Validasi() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tanggal = etDate.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (tanggal.isEmpty()) {
            etDate.setError("Tanggal Belum diisi");
            valid = false;
        } else {
            etDate.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }

        if (rgKelamin.getCheckedRadioButtonId() == -1) {
            rbLK.setError("");
            rbP.setError("");
            valid = false;
        } else {
            rbLK.setError(null);
            rbP.setError(null);
        }

        if (!cbPEM.isChecked() && !cbDES.isChecked() && !cbJAR.isChecked() && !cbANI.isChecked()) {
            cbPEM.setError("");
            cbDES.setError("");
            cbJAR.setError("");
            cbANI.setError("");
            valid = false;
        } else {
            cbPEM.setError(null);
            cbDES.setError(null);
            cbJAR.setError(null);
            cbANI.setError(null);
        }

        return valid;
    }
}
