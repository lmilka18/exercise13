public class Time {
    final int SECONDSINDAY = 86400,
            SECONDSINHOUR = 3600,
            SECONDSINMINUTE = 60;
    private int minutes, hours, seconds;
    private String strMinutes, strHours, strSeconds;

    // переводим переданное время в секунды
    private int toSeconds() {
        return hours * SECONDSINHOUR + minutes * SECONDSINMINUTE + seconds;
    }

    // переводим из секунд во время
    private String fromSeconds(int InSeconds) {
        int woDays = InSeconds % SECONDSINDAY;
        int newHours = woDays / SECONDSINHOUR;
        int woHours = woDays % SECONDSINHOUR;
        int newMinutes = woHours / SECONDSINMINUTE;
        int newSeconds = woHours % SECONDSINMINUTE;
        return (("00" + Integer.toString(newHours)).substring((Integer.toString(newHours)).length()) +
                ("00" + Integer.toString(newMinutes)).substring((Integer.toString(newMinutes)).length()) +
                ("00" + Integer.toString(newSeconds)).substring((Integer.toString(newSeconds)).length()));
    }

    // добавление  seconds секунд и отображение в длинном или коротком формат
    public String addSeconds(int seconds, String format) {
        String StrNewTime = fromSeconds(toSeconds() + seconds);
        Time newTime = new Time(StrNewTime);
        return newTime.format(format);
    }

    public Time(String time) {
        strMinutes = time.substring(2, 4);
        strHours = time.substring(0, 2);
        strSeconds = time.substring(4, 6);
        minutes = Integer.parseInt(strMinutes);
        hours = Integer.parseInt(strHours);
        seconds = Integer.parseInt(strSeconds);
    }

    // добавление  minutes числа минут и отображение в длинном или коротком формате
    public String addMinutes(int minutes, String format) {
        String StrNewTime = fromSeconds(toSeconds() + minutes * SECONDSINMINUTE % SECONDSINDAY);
        Time newTime = new Time(StrNewTime);
        return newTime.format(format);
    }
     // добавление   hours числа часов и отображение в длинном или коротком формате
    public String addHours(int hours, String format) {
        String StrNewTime = fromSeconds(toSeconds() + hours * SECONDSINHOUR % SECONDSINDAY);
        Time newTime = new Time(StrNewTime);
        return newTime.format(format);
    }
     // форматирование даты
    public String format(String format) {
        String result = format;
        result = result.replace("mm", strMinutes);
        result = result.replace("m", (strMinutes.charAt(0) == '0') ? strMinutes.substring(1) : strMinutes);
        result = result.replace("ss", strSeconds);
        result = result.replace("s", (strSeconds.charAt(0) == '0') ? strSeconds.substring(1) : strSeconds);
        result = result.replace("HH", strHours);
        result = result.replace("H", (strHours.charAt(0) == '0') ? strHours.substring(1) : strHours);
        String shortHours = Integer.toString(hours % 12);
        shortHours = ("00" + shortHours).substring(shortHours.length());
        shortHours = (shortHours.equals("00")) ? "12" : shortHours;
        result = result.replace("hh", shortHours);
        result = result.replace("h", (shortHours.charAt(0) == '0') ? shortHours.substring(1) : shortHours);

        return result;

    }

    public boolean checkIsNoTime() {
        try {
            if (hours > 24) {
                throw new Exception("Ошибка при вводе часов");
            }
            if (minutes > 60) {
                throw new Exception("Ошибка при вводе минут");
            }
            if (seconds > 60) {
                throw new Exception("Ошибка при вводе секунд");
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
            return true;
        }
        return false;
    }
}
