/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisiontree;

import constructionwmanagement.FinalMaterialEstimationFrame;
import java.util.ArrayList;

/**
 *
 * @author 1450
 */
public class DecisionForRaw 
{
   public  ArrayList  getWastageDecision(ArrayList user,ArrayList abt)
    {
        ArrayList result=new ArrayList();
        int areauser=Integer.parseInt((String)user.get(1));
        int cementbaguser=Integer.parseInt((String)user.get(2));
        int sanduser=Integer.parseInt((String)user.get(3));
        int stone10mmuser=Integer.parseInt((String)user.get(4));
        int stone20mmuser=Integer.parseInt((String)user.get(5));
        int bricksuser=Integer.parseInt((String)user.get(6));
        int rccuser=Integer.parseInt((String)user.get(7));
        
        
        String str1="Area of Plot (Sq. Ft.): "+" "+Integer.toString(areauser);
        String str2="Bags of Cement (50 Kg each): "+" "+Integer.toString(cementbaguser);
        String str3="Sand (Cu. ft.): "+" "+Integer.toString(sanduser);
        String str4="Stone Aggregates 10 mm (Cu. ft.): "+" "+Integer.toString(stone10mmuser);
        String str5="Stone Aggregates 20 mm (Cu. ft.): "+" "+Integer.toString(stone20mmuser);
        String str6="Nos. of Bricks: "+" "+Integer.toString(bricksuser);
        String str7="Reinforcement Steel (kg): "+" "+Integer.toString(rccuser);
        
        String userrawinput="\n"+str1+"\n"+str2+"\n"+str3+"\n"+str4+"\n"+str5+"\n"+str6+"\n"+str7;
        FinalMaterialEstimationFrame.res1=userrawinput;
        
        
          int areaann=Integer.parseInt((String)abt.get(1));
         int cementbagann=Integer.parseInt((String)abt.get(2));
        int sandann=Integer.parseInt((String)abt.get(3));
        int stone10mmann=Integer.parseInt((String)abt.get(4));
        int stone20mmann=Integer.parseInt((String)abt.get(5));
        int bricksann=Integer.parseInt((String)abt.get(6));
        int rccann=Integer.parseInt((String)abt.get(7));
        
        int actualcement=(areauser *cementbagann) / areaann;
        int actualsand=(areauser *sandann) / areaann;
        int actualstone10=(areauser *stone10mmann) / areaann;
        int actualstone20=(areauser *stone20mmann) / areaann;
        int actualbricks=(areauser *bricksann) / areaann;
        int actualrcc=(areauser *rccann) / areaann;
        
        System.out.println("Actual Required Cement: "+actualcement);
        System.out.println("Actual Required Sand: "+actualsand);
        System.out.println("Actual Required Stone10: "+actualstone10);
        System.out.println("Actual Required stone20: "+actualstone20);
        System.out.println("Actual Required Bricks: "+actualbricks);
        System.out.println("Actual Required RCC Steel: "+actualrcc);
        
        int diffcement=cementbaguser-actualcement;
        int diffsand=sanduser-actualsand;
        int diffstone10=stone10mmuser-actualstone10;
        int diffstone20=stone20mmuser-actualstone20;
        int diffbricks=bricksuser-actualbricks;
        int diffrcc=rccuser-actualrcc;
              
        
String cementresult=(diffcement>0)?"Cement is wasted by Units:  "+diffcement:(diffcement<0)?"Cement is Shortage by Units: "+Math.abs(diffcement):"No Wastage of Cement";
String sanresult=(diffsand>0)?"Sand is wasted by Units: "+diffsand:(diffsand<0)?"Sand is Shortage by Units:  "+Math.abs(diffsand):"No Wastage of Sand";
String stone10result=(diffstone10>0)?"Stone10mm is wasted by Units:  "+diffstone10:(diffstone10<0)?"Stone10mm is Shortage by Units:  "+Math.abs(diffstone10):"No Wastage of Stone10mm";
String stone20result=(diffstone20>0)?"Stone20mm is wasted by Units:  "+diffstone20:(diffstone20<0)?"Stone20mm is Shortage by Units:  "+Math.abs(diffstone20):"No Wastage of Stone20mm";
String bricksresult=(diffbricks>0)?"Bricks is wasted by Units:  "+diffbricks:(diffbricks<0)?"Bricks is Shortage by Units:  "+Math.abs(diffbricks):"No Bricks of Cement";
String rccresult=(diffrcc>0)?"Rcc Steel is wasted by Units:  "+diffrcc:(diffrcc<0)?"Rcc Steel is Shortage by Units:  "+Math.abs(diffrcc):"No Wastage of RCC Steel";


String rawestimated="\n"+cementresult+"\n"+sanresult+"\n"+stone10result+"\n"+stone20result+"\n"+bricksresult+"\n"+rccresult;
FinalMaterialEstimationFrame.res3=rawestimated;


        ArrayList temp1=new ArrayList();
        ArrayList temp2=new ArrayList();
        ArrayList temp3=new ArrayList();
        ArrayList temp4=new ArrayList();
        ArrayList temp5=new ArrayList();
        ArrayList temp6=new ArrayList();
        ArrayList temp7=new ArrayList();
        
        temp1.add(Integer.toString(areauser));
        temp1.add("");
        
        temp2.add(Integer.toString(cementbaguser));
        temp2.add(cementresult);
        
        temp3.add(Integer.toString(sanduser));
        temp3.add(sanresult);
        
        temp4.add(Integer.toString(stone10mmuser));
        temp4.add(stone10result);
        
        temp5.add(Integer.toString(stone20mmuser));
        temp5.add(stone20result);
        
        temp6.add(Integer.toString(bricksuser));
        temp6.add(bricksresult);
        
         temp7.add(Integer.toString(bricksuser));
        temp7.add(rccresult);
        result.add(temp1);
        result.add(temp2);
        result.add(temp3);
        result.add(temp4);
        result.add(temp5);
        result.add(temp6);
        result.add(temp7);
        

        return result;
    }
}
