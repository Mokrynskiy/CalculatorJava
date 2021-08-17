package com.calculator;

public class ArabicRomanConvertor {
    public static String ArabicToRoman(int arabicNumber)
    {
        StringBuilder result = new StringBuilder();
        for (ArabicRomanNumbers item : ArabicRomanNumbers.values())
        {
            while (item.GetIndex() <= arabicNumber)
            {
                result.append(item);
                arabicNumber -= item.GetIndex();
            }
        }
        return result.toString();
    }
    public static int RomanToArabic(String romanNumber)
    {
        int result = 0;
        int previousValue = 0;
        int correntValue = 0;
        for (String item: romanNumber.split(""))
        {
            correntValue = ArabicRomanNumbers.valueOf(item).GetIndex();

            if (correntValue > previousValue)
            {
                result +=correntValue-previousValue*2;
            }
            else
            {
                result += correntValue;
            }
            previousValue = correntValue;

        }
        return result;
    }
}
