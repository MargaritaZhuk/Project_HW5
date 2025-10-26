package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final SelenideElement yearPicker = $(".react-datepicker__year-select"),
            monthPicker = $(".react-datepicker__month-select");
    private final String dayPickerPattern = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    public void setDate(String year, String month, String day) {
        yearPicker.selectOption(year);
        monthPicker.selectOption(month);
        String formattedDay = String.format("%02d", Integer.parseInt(day));
        String dayLocator = String.format(dayPickerPattern, formattedDay);
        $(dayLocator).click();
    }
}
