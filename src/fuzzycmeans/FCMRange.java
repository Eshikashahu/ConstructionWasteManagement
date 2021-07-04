/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fuzzycmeans;

import java.util.ArrayList;

/**
 *
 * @author 1084
 */
public class FCMRange {

    public ArrayList getMinMax(ArrayList summation)
    {
        
        double min=Double.parseDouble((String) summation.get(0));
        double max=Double.parseDouble((String) summation.get(1));

        for(int i=0;i<summation.size();i++)
        {
            double x=Double.parseDouble((String) summation.get(i));
            if(min>x)
                min=x;
            if(max<x)
                max=x;
        }
       // System.out.println("min---"+min+"  max----"+max);
        ArrayList range=getRange(min,max);
        return range;
    }




    public ArrayList getRange(double min,double max)
    {

       double r1=0,r2=0;
       double diff=max-min;
       double addup=diff/5;
       
       ArrayList range=new ArrayList();
       
        for(int i=0;i<5;i++)
        {
            ArrayList temp=new ArrayList();
            r1=min;
            r2=r1+addup;

            min=r2;
            temp.add(r1);
            temp.add(r2);
            range.add(temp);
        
        }

       return range;

    }

}
