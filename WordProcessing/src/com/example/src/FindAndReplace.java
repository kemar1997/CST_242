/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.src;

import javax.swing.JOptionPane;

/**
     * A programmer-defined class that handles all the event processing for 
     * buttons.
     *
     * @author Kemar
     */
   public class FindAndReplace extends WordProcessing{

       String initialString;
       String findString;
       
       public FindAndReplace() throws EmptyStringException {
           this(" ", " ");
       }

       public FindAndReplace(String initialString, String findString) throws EmptyStringException {
           setInitialString(initialString);
           setFindString(findString);
       }
       
       public void setInitialString(String initialString) throws EmptyStringException {
           try {
               if (taWordProcessing.getText().isEmpty()) {
                   throw new EmptyStringException();
               }
           } catch (EmptyStringException ex) {
               JOptionPane.showMessageDialog(null, ex);
           }
           
           initialString = taWordProcessing.getText();
           this.initialString = initialString;
       }
       
       public void setFindString(String findString) {
           try {
               if (tfFind.getText().isEmpty()) {
                   throw new EmptyStringException();
               }
           } catch (EmptyStringException ex) {
               JOptionPane.showMessageDialog(null, ex);
           }
           
           findString = tfFind.getText();
           this.findString = findString;
       }
       
       public String getInitialString() {
           return initialString;
       }
       
       public String getFindString() {
           return findString;
       }
       
       public int findString() {
           return initialString.indexOf(findString);
       }
       
       public String replaceString() {
           findString();
           
           String newString = tfReplace.getText();
           
           String updatedString = initialString.replace(findString, newString);
           
           return updatedString;
       }
    }
