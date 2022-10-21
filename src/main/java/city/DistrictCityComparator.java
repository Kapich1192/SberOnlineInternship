package city;

import java.util.Comparator;

public class DistrictCityComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        int val1 = o1.getDistrict().charAt(0) - o2.getDistrict().charAt(0);
        if (val1 == 0) {
            int val2 = o1.compareTo(o2);
            if(val2 == 0)
                return val1;
            else
                return val2;
        }
        return val1;
    }
}
