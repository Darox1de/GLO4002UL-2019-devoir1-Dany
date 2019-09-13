package Classes;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Vector;
import java.lang.String;

public class Clinic {
    public LinkedList<String> radioQueue = new LinkedList<String>();
    public LinkedList<String> doctorQueue = new LinkedList<String>();
    public TriageType doctorListType;
    public TriageType radioListType;

    public Clinic(TriageType doctorType, TriageType radioType){
        doctorListType = doctorType;
        radioListType = radioType;
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {

        if (gravity > 5) {
            doctorQueue.add(0, name);
        }
        if (visibleSymptom == visibleSymptom.BROKEN_BONE || visibleSymptom == visibleSymptom.SPRAIN) {
            radioQueue.add(name);
            if (visibleSymptom == visibleSymptom.SPRAIN && gravity <= 5) {
                doctorQueue.add(0, name);
            }
            return;
        }
        if (visibleSymptom == visibleSymptom.FLU) {
            doctorQueue.add(1, name);
            return;
        }
        if (visibleSymptom == visibleSymptom.MIGRAINE) {
            doctorQueue.add(0, name);
            return;
        } else {
            doctorQueue.add(name);
            return;
        }
    }
}
