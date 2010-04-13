/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ftimsradio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Kamil Zygmuntowicz
 */
public class RadioControl {
    private RadioView view;

    //Constructor
    public RadioControl(RadioView view) {
        this.view = view;
         view.setFunctionButtonsVisibility(false);

     //setting up action listeners

        //function buttons
        view.addSaveButtonListener(new SaveListener());
        view.addPowerButtonListener(new PowerListener());
        view.addNextButtonListener(new NextListener());
        view.addPrevButtonListener(new PrevListener());
        view.addSettingsButtonListener(new SettingsListener());
        view.addAboutButtonListener(new AboutListener());

        //station buttons
        view.addStationButtonListeners(new StationListener());

        //sliders
        view.addVolumeSliderChangeListener(new VolumeListener());
        view.addfrequencySliderChangeListener(new FrequencyListener());
    }


//------------------- Action listeners ---------------------
    //the power button affects the behavior of other view elements
    class PowerListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(view.getPowerButton().isSelected()){
                view.getPowerButton().setText("OFF");
                //setting up the default station
                view.getScreenText().setText("xxx");
                view.setFunctionButtonsVisibility(true);
            }
            else{
               view.getPowerButton().setText("ON");
               view.getScreenText().setText("TIME");
               view.setFunctionButtonsVisibility(false);
            }
        }
    }

    //function buttons
    class SaveListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "zapis");
        }
    }

    class NextListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //here we should ask model to give us the current station
            //playing and increment it
            JOptionPane.showMessageDialog(view, "nastepny");
        }
    }

    class PrevListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //same as with NextListener
            JOptionPane.showMessageDialog(view, "poprzedni");
        }
    }

    class SettingsListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "opcje");
        }
    }

    class AboutListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(view, "o programie");
        }
    }
    //----------------

    //this is just a temporary solution , we need to change it to
    //more elegant one ;)
    class StationListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            switch(Integer.parseInt(e.getActionCommand())){
                case 1:
                    view.getScreenText().setText("cur station 1");
                break;

                case 2:
                    view.getScreenText().setText("cur station 2");
                break;

                case 3:
                    view.getScreenText().setText("cur station 3");
                break;

                case 4:
                    view.getScreenText().setText("cur station 4");
                break;

                case 5:
                    view.getScreenText().setText("cur station 5");
                break;

                case 6:
                    view.getScreenText().setText("cur station 6");
                break;
                }
        }
    }

    //sliders
    class VolumeListener implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            view.getScreenText().setText("volume: " + view.getVolumeSlider().getValue() + " %");
        }
    }

    class FrequencyListener implements ChangeListener{
        public void stateChanged(ChangeEvent e) {
            view.getScreenText().setText("frequency: " + view.getFrequencySlider().getValue() + " Hz");
        }
    }
//-------------------------------------------------------------------

    
}
