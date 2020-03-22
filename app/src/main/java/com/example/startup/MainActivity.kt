package com.example.startup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buClick(view: View){
        val buttonSelected:Button = view as Button
        var cellID = 0;

        when(buttonSelected.id){
            R.id.bu1->cellID=1
            R.id.bu2->cellID=2
            R.id.bu3->cellID=3
            R.id.bu4->cellID=4
            R.id.bu5->cellID=5
            R.id.bu6->cellID=6
            R.id.bu7->cellID=7
            R.id.bu8->cellID=8
            R.id.bu9->cellID=9

        }

        Toast.makeText(applicationContext, "ID is $cellID", Toast.LENGTH_SHORT).show()

        PlayGame(cellID, buttonSelected)

    }

    var playerOne = ArrayList<Int>()
    var playerTwo = ArrayList<Int>()
    var ActivePlayer = 1;

    fun PlayGame(cellID:Int, buSelected:Button){

        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            playerOne.add(cellID)
            ActivePlayer==2
        }
        else{
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.BLUE)
            playerTwo.add(cellID)
            ActivePlayer==1
        }
        buSelected.isEnabled=false
    }
}
