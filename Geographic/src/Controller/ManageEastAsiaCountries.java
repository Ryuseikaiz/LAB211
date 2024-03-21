package Controller;

import java.util.ArrayList;
import Model.EastAsiaCountries;
import View.GeoView;
import View.Menu;

public class ManageEastAsiaCountries extends Menu {

    ArrayList<EastAsiaCountries> arrEastAsia = new ArrayList<>();
    GeoView geoView = new GeoView();

    public ManageEastAsiaCountries() {
        super("\t\t\t\tMENU",
                new String[]{"Input the infomation of 11 countries in East Asia",
                    "Display the information of country you've just input",
                    "Search the information of country by user-entered name",
                    "Display the information of countries sorted name in ascending order",
                    "Exit"});
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                geoView.addCountryInfomation(arrEastAsia);
                break;
            case 2:
                geoView.getRecentlyEnterdInfomation(arrEastAsia);
                break;
            case 3:
                geoView.searchInfomationByName(arrEastAsia);
                break;
            case 4:
                geoView.printCountrySorted(arrEastAsia);
                break;
            case 5:
                System.exit(0);

        }
    }

}
