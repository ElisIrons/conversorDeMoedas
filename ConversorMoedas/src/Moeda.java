import com.google.gson.annotations.SerializedName;

public class Moeda {
    @SerializedName("base_code")
    private String base_code;

    @SerializedName("target_code")
    private String target_code;

    @SerializedName("result")
    private String result;

    @SerializedName("conversion_rate")
    private double conversionRate;


    public Moeda(String base_code, String target_code, double conversionRate) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.result = result;
        this.conversionRate = conversionRate;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}
