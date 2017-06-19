package com.example.vuminhduc.duoihinhbatchu;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private String[] answer = new String[]{"HOIDONG",
            "AOMUA", "BAOCAO", "OTO", "DANONG", "XAKEP", "XAPHONG", "TOHOAI",
            "CANTHIEP", "CATTUONG", "DANHLUA", "TICHPHAN", "QUYHANG", "GIANGMAI",
            "GIANDIEP", "SONGSONG", "THOTHE", "THATTINH", "TRANHTHU",
            "TOTIEN", "MASAT", "HONGTAM"};

    private int n, rd, j = 0, dem = 0;
    public static int diem = 0, tim = 5 ;
    private Random r = new Random();
    private LinearLayout linear, linear1, linearPick1, linearPick2,
            linearXam1, linearXam2, linearButton;
    private Button btn_next;
    private Button btnPick[] = new Button[16];
    private char[] dapAn = new char[16];
    private Button btnXam[];
    private String ketqua = "";
    private TextView tv_diem, tv_tim;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedIndstanceState) {
        super.onCreate(savedIndstanceState);
        setContentView(R.layout.activity_main);
        rd = random();
        creatImage();
        //creatButtonAgain();
        creatButtonPick();
        initControls();
        initEvents();
    }


    private void initEvents() {

        findViewById(R.id.btn_next).setOnClickListener(this);
        tv_diem.setText(diem + "");
        tv_tim.setText(tim + "");

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initControls() {

        tv_diem = (TextView) findViewById(R.id.tv_diem);
        tv_tim = (TextView) findViewById(R.id.tv_tim);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        btn_next = (Button) findViewById(R.id.btn_next);

    }

    public static final int[] image = {
            R.drawable.hoidong,
            R.drawable.aomua,
            R.drawable.baocao,
            R.drawable.oto,
            R.drawable.danong,
            R.drawable.xakep,
            R.drawable.xaphong,
            R.drawable.tohoai,
            R.drawable.canthiep,
            R.drawable.cattuong,
            R.drawable.danhlua,
            R.drawable.tichphan,
            R.drawable.quyhang,
            R.drawable.giangmai,
            R.drawable.giandiep,
            R.drawable.songsong,
            R.drawable.thothe,
            R.drawable.thattinh,
            R.drawable.tranhthu,
            R.drawable.totien,
            R.drawable.masat,
            R.drawable.hongtam,
    };


    public int random() {
        ArrayList<Integer> arrRD = new ArrayList<>();
        int rdNumber;
        rdNumber = r.nextInt(image.length);

        while (check(arrRD, rdNumber) == false ) {
            arrRD.add(rdNumber);
            rdNumber = r.nextInt(image.length);

        }
        return rdNumber;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void creatButtonPick() {

        linearPick1 = (LinearLayout) findViewById(R.id.linearPick1);
        linearPick2 = (LinearLayout) findViewById(R.id.linearPick2);
        for (int i = 0; i < 8; i++) {

            Button btn = new Button(this);
            btn.setLayoutParams(new LinearLayout.LayoutParams(130, 130));
            btn.setBackgroundResource(R.drawable.tile_hover);
            btn.setId(i);
            btn.setTextColor(Color.BLACK);
            linearPick1.addView(btn);
            btn.setOnClickListener(this);
            btnPick[i] = (Button) findViewById(btn.getId());
        }

        for (int i = 8; i < 16; i++) {

            Button btn2 = new Button(this);
            btn2.setLayoutParams(new LinearLayout.LayoutParams(130, 130));
            btn2.setBackgroundResource(R.drawable.tile_hover);
            btn2.setId(i);
            btn2.setTextColor(Color.BLACK);
            btn2.setOnClickListener(this);
            btn2.setGravity(Gravity.CENTER_HORIZONTAL);
            linearPick2.addView(btn2);
            btnPick[i] = (Button) findViewById(btn2.getId());
        }

        addChar();
        addButton();

    }

    private void addChar() {
        RandomText();

        int [] array = GenRandomPermutation(16) ;
        for(int i = 0; i < dapAn.length; i++) {
            btnPick[i].setText("" + dapAn[array[i]]);
        }


    }

    public static int[] GenRandomPermutation(int n)
    {
        Random r = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = i;
        }
        for (int i = 0; i < n; i++)
        {
            int j = r.nextInt(n);
            int t = a[0];
            a[0] = a[j];
            a[j] = t;
        }
        return a;
    }

    private void RandomText() {

        Random ran = new Random();
        for (int i = 0; i < answer[rd].length(); i++) {
            dapAn[i] = answer[rd].charAt(i);
        }
        for (int i = answer[rd].length(); i < 16; i++) {
            dapAn[i] = (char) (ran.nextInt(25) + 65);
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void creatImage() {
        linear = (LinearLayout) findViewById(R.id.linear);
        ImageView[] im = new ImageView[image.length];
        im[rd] = new ImageView(this);
        im[rd].setPadding(140, 160,50,50);
        im[rd].setScaleX((float) 1.5);
        im[rd].setScaleY((float) 1.5);
        im[rd].setImageResource(image[rd]);
        im[rd].setScaleType(ImageView.ScaleType.CENTER_CROP);
        linear.setGravity(LinearLayout.HORIZONTAL);
        linear.addView(im[rd]);

    }


    private boolean check(ArrayList<Integer> arr0, int a) {
        for (int i = 0; i < arr0.size(); i++) {
            if (a == arr0.get(i)) {
                return true;
            }

        }
        return false;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void addButton() {
        linearXam1 = (LinearLayout) findViewById(R.id.linearXam_1);
        linearXam2 = (LinearLayout) findViewById(R.id.linearXam_2);
        n = answer[rd].length();
        btnXam = new Button[n];

        if (n < 8) {
            for (int i = 0; i < n; i++) {

                Button button = new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(140, 140));
                button.setGravity(Gravity.CENTER_HORIZONTAL);
                button.setId(i);
                button.setTextColor(Color.BLACK);
                button.setBackgroundResource(R.drawable.button_xam);
                linearXam1.addView(button);
                btnXam[i] = (Button) findViewById(button.getId());


            }
        } else {

            for (int i = 0; i < 8; i++) {

                Button button = new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(140, 140));
                button.setGravity(Gravity.CENTER_HORIZONTAL);
                button.setId(i);
                button.setTextColor(Color.BLACK);
                button.setBackgroundResource(R.drawable.button_xam);
                linearXam1.addView(button);
                btnXam[i] = (Button) findViewById(button.getId());


            }

            for (int i = 0; i < n - 8; i++) {

                Button button = new Button(this);
                button.setLayoutParams(new LinearLayout.LayoutParams(140, 140));
                button.setGravity(Gravity.CENTER_HORIZONTAL);
                button.setId(i);
                button.setBackgroundResource(R.drawable.button_xam);
                linearXam2.addView(button);
                btnXam[i] = (Button) findViewById(button.getId());


            }

        }
    }


    private void creatButtonAgain() {

        linearButton = (LinearLayout) findViewById(R.id.LinearButton);
        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(300, 110));
        button.setGravity(Gravity.CENTER_HORIZONTAL);
        button.setBackgroundResource(R.drawable.next);
        button.setText("AGAIN");
        button.setId(0);
        button.setOnClickListener(this);
        linearButton.addView(button);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        Button button = (Button) v;

        try {
            btnXam[j].setText(button.getText());
            button.setVisibility(View.INVISIBLE);
            ketqua += button.getText();
            j++;
            dem++;
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        if (dem == answer[rd].length()) {
            if (ketqua.equals(answer[rd])) {
                for (int i = 0; i < answer[rd].length(); i++) {
                    btnXam[i].setBackgroundResource(R.drawable.tile_true);
                }
                btn_next.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Bạn đã trả lời đúng nhấn Next đê tiếp tục", Toast.LENGTH_SHORT).show();

                switch (v.getId()) {
                    case R.id.btn_next:

                        linear.removeAllViews();
                        linearXam1.removeAllViews();
                        linearXam2.removeAllViews();
                        linearPick1.removeAllViews();
                        linearPick2.removeAllViews();
                        diem += 100;
                        ketqua = "";
                        dem = 0;
                        j = 0;
                        rd = random();
                        creatImage();
                        creatButtonPick();
                        initEvents();
                        btn_next.setVisibility(View.INVISIBLE);
                        break;
                }
                return;
            } else {
                for (int i = 0; i < answer[rd].length(); i++) {
                    btnXam[i].setBackgroundResource(R.drawable.tile_false);
                }

                creatButtonAgain();
                linearButton.setVisibility(View.VISIBLE);
                linearPick1.setVisibility(View.INVISIBLE);
                linearPick2.setVisibility(View.INVISIBLE);
                switch (v.getId()) {
                    case 0:
                        //linear.removeAllViews();
                        linearButton.removeAllViews();
                        linearXam1.removeAllViews();
                        linearXam2.removeAllViews();
                        linearPick1.removeAllViews();
                        linearPick2.removeAllViews();
                        tim -= 1;
                        ketqua = "";
                        //rd = random();
                        dem = 0;
                        j = 0;
                        creatButtonPick();
                        //creatImage();
                        addChar();
                        initEvents();
                        btn_next.setVisibility(View.INVISIBLE);
                        linearPick1.setVisibility(View.VISIBLE);
                        linearPick2.setVisibility(View.VISIBLE);

                        break;
                }
                return;

            }


        }
        if (tim == 0) {
            Toast.makeText(this, "Bạn đã thua!!!", Toast.LENGTH_SHORT).show();
            return;
        }



    }
}
