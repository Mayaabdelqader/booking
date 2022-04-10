package com.example.maya20180974

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

var addmeal: Int = 0;
var b: Int = 115;
var c: Int = 70;
var f: Int = 30;
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.btConfirm)
        val edtxt1: EditText = findViewById(R.id.Pnum)
        val edtxt2: EditText = findViewById(R.id.Nnum)
        val resultTV: TextView = findViewById(R.id.textTotal)

        var flag : String = "5 Star Hotel      Price 115$"
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("5 Star Hotel      Price 115$","4 Star Hotel      Price 70$","3 Star Hotel      Price 30$")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )

        button.setOnClickListener{ view ->
            //code here
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            var pricetoatal: Int = 0;

            var res: Int = multiply(x,y);
            if(flag =="5 Star Hotel      Price 115$") {
                pricetoatal = b + addmeal;
                resultTV.text = multiply(res,pricetoatal).toString();
            }
            else if (flag =="4 Star Hotel      Price 70$") {
                pricetoatal = c + addmeal;
                resultTV.text = multiply(res,pricetoatal).toString();
            }
            else {
                pricetoatal = f + addmeal;
                resultTV.text = multiply(res,pricetoatal).toString();
            }
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val ratingTV: TextView = findViewById(R.id.TVrating)
        ratingTV.setOnClickListener {
            var dialog_var = CustomDialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
    }

    fun receiveFeedback(feedback: String) {
        val ratingTV: TextView = findViewById(R.id.TVrating)
        ratingTV.text = feedback;
        if (feedback == "Breakfast                         5$ per night"){
            addmeal = 5;
        }
        if (feedback == "Lunch                              10$ per night" || feedback == "Dinner                             10$ per night"){
            addmeal = 10;
        }
        if (feedback == "Breakfast And Dinner  15$ per night"){
            addmeal = 15;
        }
        if (feedback == "All meals                        25$ per night"){
            addmeal = 25;
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.my_first_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this, "customer.service@booking.com", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> Toast.makeText(this, "Instagram Account: Bookingcom ", Toast.LENGTH_SHORT).show()
            R.id.subitem2 -> Toast.makeText(this, "Facebook Account: Booking.com ", Toast.LENGTH_SHORT).show()
            R.id.subitem3 -> Toast.makeText(this, "Twitter Account: Booking.com ", Toast.LENGTH_SHORT).show()
        }
        return true;
    }
}
public fun multiply(a: Int, b: Int): Int {
    return a*b
}
