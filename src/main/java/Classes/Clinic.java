package Classes;
import java.util.LinkedList;
import java.lang.String;

abstract class Clinic {
    public LinkedList<String> radioQueue = new LinkedList<String>();
    public LinkedList<String> doctorQueue = new LinkedList<String>();

    abstract public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom);

}
class RadioQueueFifo extends Clinic {
    public TriageType radioQueueType;
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(gravity < 2) {
            return;
        }
        if (visibleSymptom == visibleSymptom.BROKEN_BONE || visibleSymptom == visibleSymptom.SPRAIN) {
            this.radioQueue.add(name);
        }
    }
}
class RadioQueueGravity extends Clinic {
    public TriageType radioQueueType;
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(gravity < 2) {
            return;
        }
        if (visibleSymptom == visibleSymptom.BROKEN_BONE || visibleSymptom == visibleSymptom.SPRAIN) {
            this.radioQueue.add(0, name);
        }
    }
}
class DoctorQueueFifo extends Clinic {
    public TriageType doctorQueueType;
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if (gravity < 2) {
            return;
        }
        if (visibleSymptom == visibleSymptom.FLU && !this.doctorQueue.isEmpty()) {
            this.doctorQueue.add(1, name);
            return;
        }
        if (gravity > 5 || visibleSymptom == visibleSymptom.MIGRAINE || visibleSymptom == visibleSymptom.SPRAIN){
            this.doctorQueue.add(0, name);
            return;
        } else {
            this.doctorQueue.add(name);
        }
    }
}
class DoctorQueueGravity extends Clinic {
    public TriageType doctorQueueType;
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if(gravity < 2){
            return;
        }
        this.doctorQueue.add(0, name);
    }
}
