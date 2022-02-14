/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.inclass2;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author soblab
 */
public class Employee {

   

        @SerializedName("namexyz")
        private String name;
        @SerializedName("id")
        private int id;
        
        @Override
        public String toString(){
            return name + " " + id;
        }
    
}
