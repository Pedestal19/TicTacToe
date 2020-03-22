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

        //Toast.makeText(applicationContext, "ID is $cellID", Toast.LENGTH_SHORT).show()

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
            ActivePlayer=2
        }
        else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.BLUE)
            playerTwo.add(cellID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
    }

    fun checkWinner(){

        var winner =-1

        //row 1
        if(playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)){
            winner=1;
        }
        if(playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)){
            winner=1;
        }

        //row 2
        if(playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)){
            winner=1;
        }
        if(playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)){
            winner=1;
        }

        //row 3
        if(playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)){
            winner=1;
        }
        if(playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)){
            winner=1;
        }


        //col 1
        if(playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)){
            winner=1;
        }
        if(playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)){
            winner=1;
        }

        //col 2
        if(playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)){
            winner=1;
        }
        if(playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)){
            winner=1;
        }

        //col 3
        if(playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)){
            winner=1;
        }
        if(playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)){
            winner=1;
        }
    }
}
