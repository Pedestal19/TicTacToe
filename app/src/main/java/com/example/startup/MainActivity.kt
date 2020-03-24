package com.example.startup

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

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
            buSelected.setBackgroundResource(R.color.blue)
            playerOne.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }
        else{
            buSelected.text="O"
            buSelected.setBackgroundResource(R.color.darkgreen)
            playerTwo.add(cellID)
            ActivePlayer=1
        }
        buSelected.isEnabled=false
        checkWinner()
    }

    fun checkWinner(){

        var winner =-1

        //row 1
        if(playerOne.contains(1) && playerOne.contains(2) && playerOne.contains(3)){
            winner=1;
        }
        if(playerTwo.contains(1) && playerTwo.contains(2) && playerTwo.contains(3)){
            winner=2;
        }

        //row 2
        if(playerOne.contains(4) && playerOne.contains(5) && playerOne.contains(6)){
            winner=1;
        }
        if(playerTwo.contains(4) && playerTwo.contains(5) && playerTwo.contains(6)){
            winner=2;
        }

        //row 3
        if(playerOne.contains(7) && playerOne.contains(8) && playerOne.contains(9)){
            winner=1;
        }
        if(playerTwo.contains(7) && playerTwo.contains(8) && playerTwo.contains(9)){
            winner=2;
        }


        //col 1
        if(playerOne.contains(1) && playerOne.contains(4) && playerOne.contains(7)){
            winner=1;
        }
        if(playerTwo.contains(1) && playerTwo.contains(4) && playerTwo.contains(7)){
            winner=2;
        }

        //col 2
        if(playerOne.contains(2) && playerOne.contains(5) && playerOne.contains(8)){
            winner=1;
        }
        if(playerTwo.contains(2) && playerTwo.contains(5) && playerTwo.contains(8)){
            winner=2;
        }

        //col 3
        if(playerOne.contains(3) && playerOne.contains(6) && playerOne.contains(9)){
            winner=1;
        }
        if(playerTwo.contains(3) && playerTwo.contains(6) && playerTwo.contains(9)){
            winner=2;
        }


        if (winner != -1) {
            if (winner == 1){
                Toast.makeText(this, "player 1 wins", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "player 2 wins", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun AutoPlay(){

        var emptyCells = ArrayList<Int>()

        for(cellID in 1..9){

            if(!(playerOne.contains(cellID) || playerTwo.contains(cellID))){
                emptyCells.add(cellID)
            }

        }

        var r = Random()
        println("empty cells size is "+emptyCells.size)
        val randIndex=r.nextInt(emptyCells.size-0)+0
        println("random index is $randIndex")

        val cellID = emptyCells[randIndex]
        println("cell id  is $cellID")

        var buSelect:Button?

        when(cellID){
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
            else->{
                buSelect=bu1
            }
        }

        PlayGame(cellID, buSelect)
    }
}
