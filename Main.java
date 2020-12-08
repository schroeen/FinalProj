/**
@author: Jake Knapke, Evan Schroeder, Damandeep Kaur
@version 12/7/2020

@return A game that takes us through various geographical facts. The user must then decide which fact is the correct one and then they will be awarded points. The final score will be shown at the end.


*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

class Main {
 public static void main(String args[]) {
   SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        new Game();
     }
   });
 }
} 