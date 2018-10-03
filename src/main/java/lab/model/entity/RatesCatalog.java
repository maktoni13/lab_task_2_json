package lab.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RatesCatalog {
    private List<Rate> rates;

    public RatesCatalog() {
        rates = new ArrayList<>();
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public RatesCatalog getFilteredRatesByAlfaCode(List<String> alfaCodeList){
        Set<String> alfaCodeSet = new HashSet<>();
        List<Rate> filteredRates = new ArrayList<>();
        alfaCodeSet.addAll(alfaCodeList);

        return null;
    }

    @Override
    public String toString() {
        return "RatesCatalog{" +
                "rates=" + rates +
                '}';
    }
}
