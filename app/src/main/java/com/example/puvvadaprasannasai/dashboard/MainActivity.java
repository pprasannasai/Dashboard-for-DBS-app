package com.example.puvvadaprasannasai.dashboard;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private String TAG="MainActivity";
    private  float[]ydata={10,30,40};
    private String[] xdata={"Urgent" , "Not Urgent" ,"AboutBanking"};
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* TextView tvDisplayDate = (TextView) findViewById(R.id.date);


        final Calendar c = Calendar.getInstance();
        int yy = c.get(Calendar.YEAR);
        int mm = c.get(Calendar.MONTH);
        int dd = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview
        tvDisplayDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(yy).append(" ").append("-").append(mm + 1).append("-")
                .append(dd));
*/

        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate:present slots");
        pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        pieChart.setRotationEnabled(true);
        pieChart.setExtraOffsets(5,10,5,5);

        pieChart.setDragDecelerationFrictionCoef(0.95f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setHoleRadius(25f);
        //pieChart.setTransparentCircleAlpha(0);
        pieChart.setTransparentCircleRadius(20f);
        pieChart.setCenterText("slots");

        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                /*Log.d(TAG, "onValueSelected: e.toString()");
                Log.d(TAG, "onValueSelected: h.toString()");
                int pos1=e.toString().indexOf("(sum): ");
                String sales = e.toString().substring(pos1+7);
                for(int i=0;i<ydata.length;i++)
                {
                    if(ydata[i]==Float.parseFloat(sales)){
                        pos1=i;
                        break;
                    }
                }
                String employee=xdata[pos1+1];
                Toast.makeText(MainActivity.this,"Applicants"  ,Toast.LENGTH_LONG).show();   */
                Intent intent = new Intent(MainActivity.this,
                        Log1.class);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected() {

            }
        });
        Log.d(TAG, "addData:started ");
        ArrayList<PieEntry>yEntry=new ArrayList<>();
        ArrayList<String>xEntry=new ArrayList<>();

        for (int i=0;i<xdata.length;i++)
        {
            yEntry.add(new PieEntry(ydata[i],xdata[i]));
        }

        PieDataSet pieDataSet = new PieDataSet(yEntry,"Slots");
        pieDataSet.setSliceSpace(0f);
        pieDataSet.setSelectionShift(5f);
        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
       /* colors.add(Color.CYAN);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);*/

        pieDataSet.setColors(colors);
       // pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.animateY(1000, Easing.EasingOption.EaseOutCubic);

        PieData pieData=new PieData(pieDataSet);
        pieData.setValueTextSize(10f);
        pieChart.setData(pieData);

    }

}
