package serenitylabs.tutorials.vetclinic.webdriver;

import java.util.Objects;

public class TripPreferences {

    String arriveOrDepart;
    String arrivalHour;
    String arrivalMinute;
    String arrivalDay;

    public String getArriveOrDepart() {
        return arriveOrDepart;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public String getArrivalMinute() {
        return arrivalMinute;
    }

    public String getArrivalDay() {
        return arrivalDay;
    }


    public TripPreferences(String arriveOrDepart,
                           String arrivalHour,
                           String arrivalMinute,
                           String arrivalDay) {
        this.arriveOrDepart = arriveOrDepart;
        this.arrivalHour = arrivalHour;
        this.arrivalMinute = arrivalMinute;
        this.arrivalDay = arrivalDay;
    }

    public static TripPreferencesBuilder arrivingOrDeparting(String arriveOrDepart) {
        return new TripPreferencesBuilder(arriveOrDepart);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripPreferences that = (TripPreferences) o;
        return arriveOrDepart.equals(that.arriveOrDepart) &&
                arrivalHour.equals(that.arrivalHour) &&
                arrivalMinute.equals(that.arrivalMinute) &&
                arrivalDay.equals(that.arrivalDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arriveOrDepart, arrivalHour, arrivalMinute, arrivalDay);
    }

    @Override
    public String toString() {
        return "TripPreferences{" +
                "arriveOrDepart='" + arriveOrDepart + '\'' +
                ", arrivalHour='" + arrivalHour + '\'' +
                ", arrivalMinute='" + arrivalMinute + '\'' +
                ", arrivalDay='" + arrivalDay + '\'' +
                '}';
    }

    public static class TripPreferencesBuilder {

        private final String arriveOrDepart;
        private String arrivalDay;

        public TripPreferencesBuilder(String arriveOrDepart) {

            this.arriveOrDepart = arriveOrDepart;
        }

        public TripPreferencesBuilder arrivingOn(String arrivalDay) {
            this.arrivalDay = arrivalDay;
            return this;
        }

        public TripPreferences at(String arrivalHour,String arrivalMinute) {
            return new TripPreferences(arriveOrDepart,
                    arrivalHour,
                    arrivalMinute,
                    arrivalDay);
        }
    }
}
