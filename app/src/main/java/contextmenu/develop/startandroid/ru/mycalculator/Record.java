package contextmenu.develop.startandroid.ru.mycalculator;

public class Record {

    private String TAG;
    private String note;
    private String result;

    public Record(){}

    public Record(String tag, String result){
        this.TAG = tag;
        this.note = "";
        this.result = result;
    }
    public Record(String tag,String note, String result){
        this.TAG = tag;
        this.note = note;
        this.result = result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public void setNote(String note) {

        this.note = note;
    }
    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
    public String getResult() {
        return result;
    }
    public String getNote() {
        return note;
    }
    public String getTAG() {
        return TAG;
    }

    @Override
    public String toString() {
        return getTAG();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj==null) return false;
        else if (obj.hashCode()!=this.hashCode()) return false;
        else if (!this.toString().equalsIgnoreCase(obj.toString())) return false;
        else return true;
    }
    @Override
    public int hashCode() {
        return getTAG().length();
    }
}
