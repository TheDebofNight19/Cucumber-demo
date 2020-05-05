package Pages.autoRu;

public class ManufacturerPage {

public boolean compareNumbers(String num1, String num2){

    Integer int1 = Integer.parseInt(num1);
    Integer int2 = Integer.parseInt(num2);
    if((int2 <= (int1 + 10)) && (int2 >= (int1 - 10)))
        return true;
    else return false;

 }
}
